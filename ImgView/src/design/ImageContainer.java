/**
 * 
 */
package design;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/** 
 * @author artur
 */
public class ImageContainer {
	ImageContainer(String path)
	{
		_imgPull = new LocalImg(path);
		_imgContainer=new ArrayList<BufferedImage>();
	}
	private LoadImg _imgPull;
	private ArrayList<BufferedImage> _imgContainer;
	
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
	public int findSize(String path)
	{
		return _imgPull.getSize(path);
	}
}