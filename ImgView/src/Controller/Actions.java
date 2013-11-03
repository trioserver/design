/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		Actions.java
 * Description: An Action interface that all user commands must implement
 */

package Controller;

import java.util.ArrayList;
import java.util.Observable;

import Model.ImageContainer;
import View.MainView;

/** Actions */
public abstract class Actions extends Observable{
	
	/** Current medical image viewing Session */
	static protected ImageContainer _imageContainer;
	
	/** User Interface view */
	static protected MainView _ui;
	
	static protected Actions _previousAction = null;
	
	/**
	 * Start a new Session
	 * @param path	A directory with a medical image study
	 */
	/*
	static protected void changeSession(String path) {
		_session.chgStudy(path);
	}
	*/
	
	/** 
	 * 
	 * @param ui
	 */
	public void addUiObserver(MainView ui) {
		this.addObserver(ui);
	}
	
	public void addPreviousAction(Actions _action) {
	    _previousAction = _action;
	}
	public Actions getPreviousAction() {
	    return _previousAction;
	}
	
	/** 
	 * Initiates an Action
	 * @param params	Optional parameters
	 */
	public abstract int initAction();
	
	public abstract ArrayList<Integer> undoAction();
}
