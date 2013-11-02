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


/** Do Next Action */
public class DoNext extends Actions {
	
	/**
	 * Initiates the DoNext Action
	 * @param params 	Optional parameters
	 */
	public void initAction(Object params){
	    // casting to an int array might be bad lol
	    _imageContainer.changeDisplayedImages((int[])params);
	}
}
