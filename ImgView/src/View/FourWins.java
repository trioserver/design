/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		FourWins.java
 * Description: 
 */

package View;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** FourWins */
public class FourWins extends JPanel {

	private static final long serialVersionUID = -7169147603191135658L;
	
	/**
	 * 
	 */
	public FourWins() {
		super();
	}
	
	/**
	 * 
	 * @param list
	 */
	public FourWins(ArrayList<BufferedImage> list) {
		super();
		Iterator<BufferedImage> itr = list.iterator();
		//if (list.size()!=4)  throw new IllegalArgumentException("Number of images "+list.size());
		setLayout(new GridLayout(2, 2, 0, 0));
		int i = 0;
		while(itr.hasNext() && i < 4) {
			JLabel label = new JLabel(new ImageIcon((BufferedImage)itr.next()));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			add(label);
			i++;
		}
		for (; i < 4; i++) {
			JLabel label = new JLabel();
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			add(label);
		}
		
		//if(list.size()!=1) throw new
	}
}