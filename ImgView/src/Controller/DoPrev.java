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


/** Do Previous Action */
public class DoPrev extends Actions {
	
	/** 
	 * Initiates the DoPrev Action 
	 * @param params	Optional parameters
	 */
	public void initAction(Object params){
		_session.doPrevious();
	}
}
