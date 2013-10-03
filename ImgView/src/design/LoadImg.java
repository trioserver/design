package design;

import java.awt.image.BufferedImage;
import java.io.IOException;


public interface LoadImg {
	public void init(String path);
	public abstract BufferedImage load(int index) throws IOException;
	public abstract int getSize(String path);
}