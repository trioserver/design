/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		LoadImg.java
 * Description: Interface to load an image
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
	 * Load an image
	 * @param index			Index of an image
	 * @return				The loaded image
	 * @throws IOException
	 */
	public abstract BufferedImage load(int index) throws IOException;
	
	/**
	 * Get the size of a study
	 * @param path	The path of a medical image study
	 * @return
	 */
	public abstract int getSize(String path);
}