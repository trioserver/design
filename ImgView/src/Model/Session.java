/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		Session.java
 * Description: This class holds a reference to the logic to change state, 
 * 				the state which the view should reflect, the current paths for any current 
 * 				images being displayed, and a reference to the mouse for system interaction 
 * 				such as scrolling. It does not define much behavior, rather it is just a 
 * 				holder and state for the system.
 */

package Model;

import java.util.ArrayList;
import java.util.Observable;


/** Session */
public class Session extends Observable{

	private int displayState;
	private int currentImage;
	private int nbrImages;
	
	public int getDisplayState() {
	    return displayState;
	}
	
	public void setDisplayState(int _displayState) {
	    displayState = _displayState;
	}
	
	public int getCurrentImage() {
	    return currentImage;
	}
	
	public void setCurrentImage(int _currentImage) {
	    currentImage = _currentImage;
	}
	
	public int getNbrImages() {
	    return nbrImages;
	}
	
	public void setNbrImages(int _nbrImages) {
	    nbrImages = _nbrImages;
	}
	
	public void setAll(ArrayList<Integer> newSet) {
	    displayState = newSet.get(0);
	    currentImage = newSet.get(1);
	    nbrImages = newSet.get(2);
	}
	
	/** 
	 * Open a new medical image study
	 * @param path	A directory with a medical image study
	 */
	/*
	public void chgStudy() {
		collection=new ImageContainer(path);
		nbrImages = collection.findSize(path);
		currentImage = 0;
		displayState = 1;
		doNext();
		if (nbrImages==0)notifyObservers(-1);
	}
	*/
	
	/** 
	 * Gets an imageCont object
	 * @return  Returns the imageCont
	 */
	/*
	public ImageContainer getCollection() {
		return collection;
	}
	*/

	/** 
	 * Sets an imageCont object
	 * @param imageCont  The imageCont to set
	 */
	/*
	public void setCollection(ImageContainer imageCont) {
		this.collection = imageCont;
	}
	*/
	
	/**
	 * Scroll to the next medical image(s) in a study
	 */
	/*
	public void doNext() {
		int overload = (currentImage + displayState) - nbrImages;
		if (overload < displayState) {	
			setChanged();
			if (overload <= 0) {
				notifyObservers(collection.doNext(currentImage, displayState));
				currentImage += displayState;
			} else {
				notifyObservers(collection.doNext(currentImage, displayState - overload));
				currentImage = nbrImages - 1;
			}
		}
	}
	*/
	
	/**
	 * Scroll to the previous medical image(s) in a study
	 */
	/*
	public void doPrevious() {
		if (currentImage - 2 * displayState >= 0) {
			setChanged();
			currentImage = currentImage - 2 * displayState;
			if (currentImage >= displayState) {
				notifyObservers(collection.doPrevious(currentImage, displayState));
				currentImage = currentImage + displayState;
			} else {
			notifyObservers(collection.doPrevious(currentImage, currentImage));
			currentImage = 0;
			}
		}
	}
	*/
	
	/**
	 * Change the display state of the medical images
	 * @param toState	A new state
	 */
	/*
	public void changeState(int toState) {
		currentImage = currentImage - displayState;
		if (currentImage < 0) {
			currentImage = 0;
		}
		if (currentImage + toState >= nbrImages) {
			currentImage = nbrImages - toState - 1;
		}
		displayState = toState;
		setChanged();
		notifyObservers(collection.doNext(currentImage, toState));
	}
	*/

	/**
	 * Save a study to the local system
	 * @param params
	 */
	/*
	public void saveStudy(String params) {
		collection.saveStudy(params);
	}
	*/
	/*
	@Override
	public synchronized boolean hasChanged() {
		return super.hasChanged();
	}
	*/

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	

}