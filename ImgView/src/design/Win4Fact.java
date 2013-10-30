/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		Win4Fact.java
 * Description: 
 */

package design;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;

/** Four image Window Factory */
public class Win4Fact implements WindowFactory {
	
	/**
	 * 
	 */
	public Win4Fact() {
		fourWins = new FourWins();
	}

	/**
	 * 
	 * @param list
	 */
	public Win4Fact(ArrayList<BufferedImage> list) {
		fourWins = new FourWins(list);
	}
	
	/**
	 * 
	 */
	public void update(ArrayList<BufferedImage> list) {
		fourWins = new FourWins(list);
	}
	
	/**  */
	private JComponent fourWins;

	/**
	 * Gets a fourWins object
	 * @return  Returns the fourWins
	 */
	public JComponent getWindow() {
		return fourWins;
	}

	/**
	 * Sets a fourWins object
	 * @param fourWins  The fourWins to set
	 */
	public void setFourWins(FourWins fourWins) {
		this.fourWins = fourWins;
	}
}
