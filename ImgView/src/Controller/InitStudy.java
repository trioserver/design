/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		InitStudy.java
 * Description: 
 */

package Controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.ImageContainer;
import View.MainView;

/** Initiate Study */
public class InitStudy extends Actions {
    
    	private int displayState = 1;
    	private int currentImage = 0;
    	private int nbrImages = -1;
    	private ArrayList<BufferedImage> imagesToDisplay = null;
    	
    	
	/**
	 * Constructs InitStudy
	 * @param params
	 * @param ui		The main view
	 */
	public InitStudy(String params, MainView ui) {
		Actions._imageContainer = new ImageContainer();
		nbrImages = _imageContainer.changeStudy(params);
		_ui = ui;
		_previousAction = null;
	}
	
	/**
	 * Initiate the Action to change Session
	 */
	// will be buggy, deal with too few pictures with initstudy
	public int initAction() {
	    ArrayList<Integer> newImageIndexes = new ArrayList<Integer>();
	    for (int i = 0; i < displayState; ++i) {
		newImageIndexes.add(i);
	    }
	    imagesToDisplay = _imageContainer.changeDisplayedImages(newImageIndexes);
	    setChanged();
	    notifyObservers(imagesToDisplay);
	    setChanged();
	    notifyObservers(_imageContainer.getDirectories());
	    return nbrImages; // will change later
	}
	
	public ArrayList<Integer> undoAction() {
		ArrayList<Integer> noUndoFunctionality = new ArrayList<Integer>();
		return noUndoFunctionality;
	}
}
