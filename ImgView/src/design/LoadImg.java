/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		LoadImg.java
 * Description: 
 */

package design;

import java.awt.image.BufferedImage;
import java.io.IOException;

/** Load Image */
public interface LoadImg {
	/**
	 * 
	 * @param path
	 */
	public void init(String path);
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws IOException
	 */
	public abstract BufferedImage load(int index) throws IOException;
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public abstract int getSize(String path);
}