/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		ChgState.java
 * Description: Changes the display state of the medical images
 * 				View one image
 * 				View four tiled images
 */

package design;

/** Change State Action */
public class ChgState extends Actions {
	
	/**
	 * Initiate the ChgState Action
	 * @param params	Optional parameters
	 */
	public void initAction(Object params) {
		Actions._session.changeState((Integer)params);
	}
}
