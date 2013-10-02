/**
 * 
 */
package design;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** 
 * @author artur
 */
public class FourWins extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7169147603191135658L;
	
	public FourWins(ArrayList<BufferedImage> list)
	{
		super(new ImageIcon(list.get(0)));
		//if(list.size()!=1) throw new
	}
}
