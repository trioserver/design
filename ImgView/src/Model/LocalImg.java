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
import java.util.Hashtable;

/** Local Image */
public class LocalImg extends BufferedImage {
	
    	private int[][] pixels2DArray;
    	
    	private int rowSize;
    	private int colSize;
    	
	public LocalImg(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
	    super(cm, raster, isRasterPremultiplied, properties);
	    rowSize = this.getWidth();
	    colSize = this.getHeight();
	    pixels2DArray = new int[rowSize][colSize];
	    
	    for (int _row = 0; _row < colSize; ++_row) {
		for (int _col = 0; _col < rowSize; ++_col) {
		    pixels2DArray[_row][_col] = this.getRGB(_col, _row);
		}
	    }
	}

	// actual return type should be that of array of pixels
	// check if we are going from top to bottom or bottom to top
	public void getRow(int _col) {
	    int[] row = new int[rowSize];
	    for (int pixel = 0; pixel < rowSize; ++pixel) {
		row[pixel] = pixels2DArray[pixel][_col];
	    }
	}
	
	// actual return type should be that of array of pixels
	// check if we are going from top to bottom or bottom to top	
	public void getCol(int _row) {
	    int[] col = new int[colSize];
	    for (int pixel = 0; pixel < colSize; ++pixel) {
		col[pixel] = pixels2DArray[_row][pixel];
	    }
	}
	
	public int getRowCol(int _row, int _col) {
	    return pixels2DArray[_row][_col];
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