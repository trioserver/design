/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		RemoteImg.java
 * Description: 
 */

package design;

import java.awt.image.BufferedImage;
import java.io.IOException;

/** Remote Image */
public class RemoteImg implements LoadImg {
	
	/**
	 * 
	 */
	public void init(String path) {}
	
	/**
	 * 
	 */
	public  BufferedImage load(int index) throws IOException {
		return new BufferedImage(0, 0, 0);
	}
	
	/**
	 * 
	 */
	public  int getSize(String path) {
		return 0;
	}
}
