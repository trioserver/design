/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		DoNext.java
 * Description: Action used to scroll to the next medical image(s) in a study
 */

package Controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.ImageContainer;


/** Do Next Action */
public class DoNext extends Actions {
	
    	private int displayState;
    	private int nbrImages;
    	private int oldCurrentImage;
    	private int newCurrentImage;
    	private ArrayList<BufferedImage> imagesToDisplay = null;
    
    	public DoNext(int _displayState, int _nbrImages, int _currentImage) {
    	    displayState = _displayState;
    	    nbrImages = _nbrImages;
    	    oldCurrentImage = _currentImage;
    	}
    	
	public int initAction() {
	    ArrayList<Integer> newImageIndexes = new ArrayList<Integer>();
	    int overload = displayState;
	    // check that the images to be displayed on next page
	    // does not exceed the number of images contained
	    if (oldCurrentImage + displayState >= nbrImages) {
		return oldCurrentImage;
	    }
	    newCurrentImage = oldCurrentImage + displayState;
	    if (oldCurrentImage + displayState > nbrImages - displayState) {
		//newCurrentImage = nbrImages - displayState - 1;
		overload = nbrImages - newCurrentImage;
	    } 
	    /*
	    else {
		newCurrentImage = oldCurrentImage + displayState;
	    }
	    */
	    for (int i = 0; i < overload; ++i) {
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
