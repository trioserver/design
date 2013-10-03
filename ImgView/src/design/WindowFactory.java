/**
 * 
 */
package design;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

/** 
 * @author artur
 */
public interface WindowFactory {
	public abstract JComponent getWindow();
	public abstract void update(ArrayList<BufferedImage> list);

}


