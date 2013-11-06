/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		SaveStudy.java
 * Description: Action used to save a study
 */

package Model;

import java.util.ArrayList;

import Controller.Actions;

/** Save Study */
public class SaveStudy extends Actions {

	/**
	 * Initiate SaveStudy Action
	 * @param params	optional parameters
	 */
	@Override
	public int initAction() {
		//if (params instanceof String) Actions._session.saveStudy((String) params);
		return 0;
	}
	
	public ArrayList<Integer> undoAction() {
		return new ArrayList<Integer>();
	}
}