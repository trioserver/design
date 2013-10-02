/**
 * 
 */
package design;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
	
	public OneWins(ArrayList<BufferedImage> list)
	{
		super();
		Image img = resize(list.get(0));
		setIcon(new ImageIcon(img));
		setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
		//if(list.size()!=1) throw new
	}
	public Image resize(BufferedImage img)
	{
		Image scaledImage = img.getScaledInstance((int)800, (int)600, Image.SCALE_SMOOTH);
        BufferedImage imageBuff = new BufferedImage((int)800, (int)600, BufferedImage.TYPE_INT_RGB);
        Graphics g = imageBuff.createGraphics();
        g.drawImage(scaledImage, 0, 0, new Color(0,0,0), null);
        g.dispose();
        return scaledImage;
	}
}
