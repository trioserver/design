/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		ImageContainer.java
 * Description: 
 */

package design;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/** Image Container */
public class ImageContainer {
	ImageContainer(String path) {
		_imgPull = new LocalImg(path);
		_imgContainer=new ArrayList<BufferedImage>();
	}
	
	/**  */
	private LoadImg _imgPull;
	
	/**  */
	private ArrayList<BufferedImage> _imgContainer;
	
	/**
	 * Gets the next medical image(s) in a study
	 * @param currentIndex		Index of the current image
	 * @param currentState		Current display state
	 * @return _imgContainer	The container of images
	 */
	public ArrayList<BufferedImage>  doNext(int currentIndex, int currentState) {
		// put in throw here for empty, incorrect inputs, etc --mikey
		_imgContainer.clear();
		for (int i = currentIndex; i < currentIndex+currentState; ++i) {
			try {
				_imgContainer.add(_imgPull.load(i));
			}catch (IOException e) {
				break;
			}
		}
		return _imgContainer;
	}
	
	/**
	 * Gets the previous medical image(s) in a study
	 * @param currentIndex		Index of the current image
	 * @param currentState		Current display state
	 * @return _imgContainer	The container of images
	 */
	public ArrayList<BufferedImage> doPrevious(int currentIndex, int currentState) {
		_imgContainer.clear();
		for (int i = currentIndex; i >= currentIndex-currentState; --i) {
			try {
				_imgContainer.add(_imgPull.load(i));
			}catch (IOException e) {
				break;
			}
		}
		return _imgContainer;
	}
	
	/*public void changeState(int currentIndex, int toState,String dirpath) {
		for (int i = 0; i < toState; ++i) {
			if (_allImages.size() <= currentIndex + i ) {
				break;
			} else {
				_imageContainer.addLoadImg(_allImages[currentIndex + i]);
			}
		}				_imgContainer.
		return _imageContainer.loadImgToArray();
	}*/
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public int findSize(String path) {
		return _imgPull.getSize(path);
	}
	

	public void saveStudy(String params) {
		// TODO Auto-generated method stub
		
	}
}