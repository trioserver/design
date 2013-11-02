/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		WindowFactory.java
 * Description: Creates window views based on the display state and the current images 
 * 				being rendered on screen.
 */

package View;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;

/** Window Factory */
public interface WindowFactory {
	
	public abstract JComponent getWindow();
	public abstract void update(ArrayList<BufferedImage> list);
}


