package Controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ChgTypeState extends Actions{
    private int displayState;
    private String oldTypeState;
    private String newTypeState;
    private int oldCurrentImage;
    private int newCurrentImage;
    private int oldNbrImages;
    private int newNbrImages;
    private ArrayList<BufferedImage> imagesToDisplay = null;
    
    public ChgTypeState(int _displayState, int _oldCurrentImage, int _newCurrentImage, String _oldTypeState, String _newTypeState) {
	displayState = _displayState;
	oldTypeState = _oldTypeState;
	newTypeState = _newTypeState;
	oldCurrentImage = _oldCurrentImage;
	newCurrentImage = _newCurrentImage;
    }
    
    public void setNbrImages(int _nbrImages) {
	
    }
    
    /**
     * Initiate the ChgState Action
     * @param params	Optional parameters
     */
	public int initAction() {
	    ArrayList<Integer> newImageIndexes = new ArrayList<Integer>();
	    for (int i = 0; i < displayState; ++i) {
		newImageIndexes.add(newCurrentImage + i);
	    }
	    oldNbrImages = _imageContainer.getNumberImages();
	    _imageContainer.changeTypeImages(newTypeState);
	    newNbrImages = _imageContainer.getNumberImages();
	    imagesToDisplay = _imageContainer.changeDisplayedImages(newImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    return newNbrImages;
	}
	
	public ArrayList<Integer> undoAction() {
	    ArrayList<Integer> oldImageIndexes = new ArrayList<Integer>();
	    for (int i = 0; i < displayState; ++i) {
		oldImageIndexes.add(oldCurrentImage + i);
	    }
	    _imageContainer.changeTypeImages(oldTypeState);
	    imagesToDisplay = _imageContainer.changeDisplayedImages(oldImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    
	    ArrayList<Integer> newStateValues = new ArrayList<Integer>();
	    newStateValues.add(displayState);
	    newStateValues.add(oldCurrentImage);
	    newStateValues.add(oldNbrImages);
	    
	    return newStateValues;
	}
}
