/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		DoNext.java
 * Description: Action used to scroll to the next medical image(s) in a study
 */

package design;

/** Do Next Action */
public class DoNext extends Actions {
	
	/**
	 * Initiates the DoNext Action
	 * @param params 	Optional parameters
	 */
	public void initAction(Object params){
		_session.doNext();
	}
}
