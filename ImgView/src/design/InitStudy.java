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
	 * 
	 * @param params
	 * @param ui
	 */
	public InitStudy(String params,MainView ui) {
		Actions._session=new Session();
		Actions.addUiObserver(ui);
		initAction(params);
	}
	
	/**
	 * 
	 */
	@Override
	public void initAction(Object params) {
		if (params instanceof String) {
			Actions.changeSession((String)params);
		}
	}
}
