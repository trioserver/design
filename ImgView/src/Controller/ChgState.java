/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		ChgState.java
 * Description: Changes the display state of the medical images
 * 				View one image
 * 				View four tiled images
 */

package Controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.ImageContainer;


/** Change State Action */
public class ChgState extends Actions {
    
    private int oldState;
    private int newState;
    private int oldCurrentImage;
    private int nbrImages;
    private ArrayList<BufferedImage> imagesToDisplay = null;
    
    public ChgState(int _displayState, int _nbrImages, int _currentImage, int _newState) {
	oldState = _displayState;
	newState = _newState;
	nbrImages = _nbrImages;
	oldCurrentImage = _currentImage;
    }
    
    /**
     * Initiate the ChgState Action
     * @param params	Optional parameters
     */
	public int initAction() {
	    ArrayList<Integer> newImageIndexes = new ArrayList<Integer>();
	    int overload = nbrImages - oldCurrentImage;
	    for (int i = 0; i < overload; ++i) {
		newImageIndexes.add(oldCurrentImage + i);
	    }
	    
	    imagesToDisplay = _imageContainer.changeDisplayedImages(newImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    return oldCurrentImage;
	}
	
	public ArrayList<Integer> undoAction() {
	    ArrayList<Integer> oldImageIndexes = new ArrayList<Integer>();
	    for (int i = 0; i < oldState; ++i) {
		oldImageIndexes.add(oldCurrentImage + i);
	    }
	    imagesToDisplay = _imageContainer.changeDisplayedImages(oldImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    
	    ArrayList<Integer> newStateValues = new ArrayList<Integer>();
	    newStateValues.add(oldState);
	    newStateValues.add(oldCurrentImage);
	    newStateValues.add(nbrImages);
	    
	    return newStateValues;
	}
}
