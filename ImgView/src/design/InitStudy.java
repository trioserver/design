/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		InitStudy.java
 * Description: 
 */

package design;

/** Initiate Study */
public class InitStudy extends Actions {
    
	/**
	 * Constructs InitStudy
	 * @param params
	 * @param ui		The main view
	 */
	public InitStudy(String params, MainView ui) {
		Actions._session=new Session();
		Actions.addUiObserver(ui);
		initAction(params);
	}
	
	/**
	 * Initiate the Action to change Session
	 */
	@Override
	public void initAction(Object params) {
		if (params instanceof String) {
			Actions.changeSession((String)params);
		}
	}
}
