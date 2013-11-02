/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		Win1Fact.java
 * Description: 
 */

package View;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;


/** One image Window Factory */
public class Win1Fact implements WindowFactory {
	
	/**
	 * 
	 */
	Win1Fact() {
		_oneWins = new View.OneWins();
	}
	
	/**
	 * 
	 * @param list
	 */
	Win1Fact(ArrayList<BufferedImage> list) {
		_oneWins = new View.OneWins(list);
	}
	
	/**
	 * 
	 */
	public void update(ArrayList<BufferedImage> list) {
		_oneWins = new View.OneWins(list);
	}
	
	/**  */
	private JComponent _oneWins;

	/**
	 * Gets a _oneWins object
	 * @return	Returns the _oneWins
	 */
	public JComponent getWindow() {
		return _oneWins;
	}

	/**
	 * Sets a _oneWins object
	 * @param _oneWins  The _oneWins to set
	 */
	public void set_oneWins(OneWins _oneWins) {
		this._oneWins = _oneWins;
	}
}
