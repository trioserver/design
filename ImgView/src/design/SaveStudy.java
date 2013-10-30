/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		SaveStudy.java
 * Description: 
 */

package design;

/** Save Study */
public class SaveStudy extends Actions {

	/**
	 * 
	 */
	@Override
	public void initAction(Object params) {
		if (params instanceof String) Actions._session.saveStudy((String) params);
	}
}