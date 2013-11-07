/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		ImageContainer.java
 * Description: 
 */

package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import javax.imageio.ImageIO;


/** Image Container */
public class ImageContainer extends Observable {
	
    public ImageContainer() {
    }
    
    public int changeStudy(String directory) {
	_imgContainerStock = new ArrayList<BufferedImage>();
	_imgContainer1 = new ArrayList<BufferedImage>();
	_imgContainer2 = new ArrayList<BufferedImage>();
	_imgContainerInUse = _imgContainerStock;
	
	File dir = new File(directory);
    	File[] files = dir.listFiles();
    	directoriesToPresent = new ArrayList<String>();
	Arrays.sort(files);
	for(File file : files) {
	    // add exception code here later!! important
	    try {
		if (file.isFile()) {
    	    	_imgContainerStock.add(ImageIO.read(file));
		} else if (file.isDirectory()) {
		    directoriesToPresent.add(file.toString());
		}
    	    } catch (IOException e) {
    		e.printStackTrace();
    	    }
	}
	
		cube = new int[files.length][_imgContainerStock.get(0).getWidth()][_imgContainerStock.get(0).getHeight()];
	    renderImages();
	    return files.length;
    }
	
	/**  */
	//private LoadImg _imgPull;
	
	/**  */
	private ArrayList<BufferedImage> _imgContainerStock = null;
	private ArrayList<BufferedImage> _imgContainer1 = null;
	private ArrayList<BufferedImage> _imgContainer2 = null;
	private ArrayList<BufferedImage> _imgContainerInUse = null;
	ArrayList<String> directoriesToPresent = new ArrayList<String>();
	
	
	private int[][][] cube;
	
	//private ArrayList<BufferedImage> displayedImages = null;
	
	/**
	 * Gets the next medical image(s) in a study
	 * @param currentIndex		Index of the current image
	 * @param currentState		Current display state
	 * @return _imgContainer	The container of images
	 */
	/*
	public ArrayList<BufferedImage>  doNext(int currentIndex, int currentState) {
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
	*/
	public String[] getDirectories() {
	    String[] directories = new String[directoriesToPresent.size()];
	    for (int i = 0; i < directoriesToPresent.size(); ++i) {
		directories[i] = directoriesToPresent.get(i);
	    }
	    return directories;
	}
	
	public ArrayList<BufferedImage> changeDisplayedImages(ArrayList<Integer> indexes) {
	    ArrayList<BufferedImage> imagesToReturn = new ArrayList<BufferedImage>();
	    for(int i = 0; i < indexes.size(); ++i) {
		imagesToReturn.add(_imgContainerInUse.get(indexes.get(i))); // here
	    }
	    return imagesToReturn;
	}
	
	public void changeTypeImages(String type) {
	    if (type == "xy" ) {
		_imgContainerInUse = _imgContainerStock;
	    }
	    if (type == "xz") {
		_imgContainerInUse = _imgContainer1;
	    }
	    if (type == "yz") {
		_imgContainerInUse = _imgContainer2;
	    }
	}
	
	public int getNumberImages() {
	    return _imgContainerInUse.size();
	}
	
	private void renderImages() {
	    for (int imageIndex = 0; imageIndex < _imgContainerStock.size(); ++imageIndex) {
		BufferedImage tempImage = _imgContainerStock.get(imageIndex);
		for (int row = 0; row < tempImage.getWidth(); ++row) {
		    for (int col = 0; col < tempImage.getHeight(); ++col) {
			cube[imageIndex][row][col] = tempImage.getRGB(row, col);
			
		    }
		}
	    }
	    createView1();
	    createView2();
	    cube = null;
	}
	
	private void createView1() {
	    _imgContainer1=new ArrayList<BufferedImage>(cube[0].length);
	    for (int k = 0; k < cube[0].length; ++k) {
		BufferedImage temp=new BufferedImage(cube[0][0].length,cube.length,BufferedImage.TYPE_BYTE_BINARY);
		for(int i=0;i < cube[0][0].length;++i){
		    for (int j=0;j < cube.length; ++j){
			temp.setRGB(i, j, cube[cube.length - j -1][k][i]);
		    }
		}
		_imgContainer1.add(temp);    
		}
		
	    }
	private void createView2(){
	    _imgContainer2=new ArrayList<BufferedImage>(cube[0][0].length);
	    for (int k = 0; k < cube[0][0].length; ++k) {
		BufferedImage temp=new BufferedImage(cube[0].length,cube.length,BufferedImage.TYPE_BYTE_BINARY);
		for(int i=0;i < cube[0].length;++i){
		    for (int j=0;j<cube.length; ++j){
			temp.setRGB(i, j, cube[cube.length - j - 1][i][k]);
		    }
		}
		_imgContainer2.add(temp);    
		}
		
	    }
	
	/**
	 * Gets the previous medical image(s) in a study
	 * @param currentIndex		Index of the current image
	 * @param currentState		Current display state
	 * @return _imgContainer	The container of images
	 */
	/*
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
	*/
	
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
	/*
	public int findSize(String path) {
	    if (_imgPull != null) {
		return _imgPull.getSize(path);
	    } else {
		return 0;
	    }
	}
	*/
	

	public void saveStudy(String params) {
		// TODO Auto-generated method stub
		
	}
}