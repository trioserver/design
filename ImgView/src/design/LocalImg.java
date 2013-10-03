/**
 * 
 */
package design;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

/** 
 * @author artur
 */
public class LocalImg implements LoadImg {
	ArrayList<File> _imagesPaths;
	public LocalImg(String path)
	{
		_imagesPaths=new ArrayList<File>();
		init(path);
	}
	public void init(String path)
	{
		File dir = new File(path);
		if (dir.isDirectory())
		{
			File[] tab=dir.listFiles();
			Arrays.sort(tab);
			_imagesPaths=new ArrayList<File>(Arrays.asList(tab));
		}
	}
	public BufferedImage load(int index) throws IOException {
		BufferedImage myPicture;
		File imgpath = _imagesPaths.get(index);
		myPicture = ImageIO.read(imgpath);
		return myPicture;	
	}

	@Override
	public int getSize(String path) {
		return _imagesPaths.size();
	}
	
	
}