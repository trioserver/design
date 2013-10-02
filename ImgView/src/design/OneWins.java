/**
 * 
 */
package design;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** 
 * @author artur
 */
public class OneWins extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OneWins(List<BufferedImage> list)
	{
		super(new ImageIcon(list.get(0)));
		//if(list.size()!=1) throw new
	}
}
