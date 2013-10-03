/**
 * 
 */
package design;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * @author artur
 */
public class FourWins extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7169147603191135658L;
	
	public FourWins()
	{
		super();
	}
	public FourWins(ArrayList<BufferedImage> list)
	{
		super();
		Iterator<BufferedImage> itr=list.iterator();
		//if (list.size()!=4)  throw new IllegalArgumentException("Number of images "+list.size());
		setLayout(new GridLayout(2, 2, 0, 0));
		int i=0;
		while(itr.hasNext()&&i<4)
		{
			JLabel label=new JLabel(new ImageIcon((BufferedImage)itr.next()));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			add(label);
			i++;
		}
		
		//if(list.size()!=1) throw new
	}
}
