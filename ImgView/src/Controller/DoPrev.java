/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		DoPrev.java
 * Description: Action used to scroll to the previous medical image(s) in a study
 */

package Controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


/** Do Previous Action */
public class DoPrev extends Actions {
	
    private int displayState;
    private int nbrImages;
    private int oldCurrentImage;
    private int newCurrentImage;
    private ArrayList<BufferedImage> imagesToDisplay = null;
    
    public DoPrev(int _displayState, int _nbrImages, int _currentImage) {
	displayState = _displayState;
	nbrImages = _nbrImages;
	oldCurrentImage = _currentImage;
	}
	
	/** 
	 * Initiates the DoPrev Action 
	 * @param params	Optional parameters
	 */
    	public int initAction(){
	    ArrayList<Integer> newImageIndexes = new ArrayList<Integer>();
	    if (oldCurrentImage - displayState < 0) {
		newCurrentImage = 0;
	    } else {
		newCurrentImage = oldCurrentImage - displayState;
	    }
	    for (int i = 0; i < displayState; ++i) {
		newImageIndexes.add(newCurrentImage + i);
	    }
	    
	    imagesToDisplay = _imageContainer.changeDisplayedImages(newImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    return newCurrentImage;
	}
    	
    	public ArrayList<Integer> undoAction() {
    	    ArrayList<Integer> oldImageIndexes = new ArrayList<Integer>();
	    for (int i = 0; i < displayState; ++i) {
		oldImageIndexes.add(oldCurrentImage + i);
	    }
	    imagesToDisplay = _imageContainer.changeDisplayedImages(oldImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    
	    ArrayList<Integer> newStateValues = new ArrayList<Integer>();
	    newStateValues.add(displayState);
	    newStateValues.add(oldCurrentImage);
	    newStateValues.add(nbrImages);
	    
	    return newStateValues;
    	}
}
