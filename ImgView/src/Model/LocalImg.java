/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		LocalImg.java
 * Description: Load a local image
 */

package Model;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javax.imageio.ImageIO;

/** Local Image */
public class LocalImg extends BufferedImage {
	
	public LocalImg(ColorModel cm, WritableRaster raster,
			boolean isRasterPremultiplied, 
			Hashtable<?, ?> properties) {
	    super(cm, raster, isRasterPremultiplied, properties);
	}

	// actual return type should be that of array of pixels
	// check if we are going from top to bottom or bottom to top
	public void getRow(int row) {
	    
	}
	
	// actual return type should be that of array of pixels
	// check if we are going from top to bottom or bottom to top	
	public void getCol(int col) {
	    
	}
	
	/** ArrayList of paths for images */
	//ArrayList<BufferedImage> _imagesPaths;
	
	/**
	 * Constructs a LocalImg with an ArrayList of paths
	 * @param path	Directory of a medical image
	 */
	//public void BufferedImage(String path) {
	//}
	
	/** 
	 * Initial actions for images
	 */
	/*
	public void init(String path) {
		File dir = new File(path);
		if (dir.isDirectory()) {
			File[] tab = dir.listFiles();
			Arrays.sort(tab);
			_imagesPaths = new ArrayList<File>(Arrays.asList(tab));
		}
	}
	*/
	
	/**
	 * Load a local image
	 */
	/*
	public BufferedImage load(int index) throws IOException {
		BufferedImage myPicture;
		File imgpath = _imagesPaths.get(index);
		myPicture = ImageIO.read(imgpath);
		return myPicture;	
	}
	*/

	/**
	 * Get the size of a list of paths
	 */
	//@Override
	/*
	public int getSize(String path) {
		return _imagesPaths.size();
	}
	*/
}