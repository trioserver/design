/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		LocalImg.java
 * Description: Load a local image
 */

package design;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

/** Local Image */
public class LocalImg implements LoadImg {
	
	/** ArrayList of paths for images */
	ArrayList<File> _imagesPaths;
	
	/**
	 * Constructs a LocalImg with an ArrayList of paths
	 * @param path	Directory of a medical image
	 */
	public LocalImg(String path) {
		_imagesPaths = new ArrayList<File>();
		init(path);
	}
	
	/** 
	 * Initial actions for images
	 */
	public void init(String path) {
		File dir = new File(path);
		if (dir.isDirectory()) {
			File[] tab = dir.listFiles();
			Arrays.sort(tab);
			_imagesPaths = new ArrayList<File>(Arrays.asList(tab));
		}
	}
	
	/**
	 * Load a local image
	 */
	public BufferedImage load(int index) throws IOException {
		BufferedImage myPicture;
		File imgpath = _imagesPaths.get(index);
		myPicture = ImageIO.read(imgpath);
		return myPicture;	
	}

	/**
	 * Get the size of a list of paths
	 */
	@Override
	public int getSize(String path) {
		return _imagesPaths.size();
	}
}