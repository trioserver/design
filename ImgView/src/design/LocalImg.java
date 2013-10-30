/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		LocalImg.java
 * Description: 
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
	
	/** ArrayList of paths for medical images */
	ArrayList<File> _imagesPaths;
	
	/**
	 * 
	 * @param path
	 */
	public LocalImg(String path) {
		_imagesPaths = new ArrayList<File>();
		init(path);
	}
	
	/** 
	 * 
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
	 * 
	 */
	public BufferedImage load(int index) throws IOException {
		BufferedImage myPicture;
		File imgpath = _imagesPaths.get(index);
		myPicture = ImageIO.read(imgpath);
		return myPicture;	
	}

	/**
	 * 
	 */
	@Override
	public int getSize(String path) {
		return _imagesPaths.size();
	}
}