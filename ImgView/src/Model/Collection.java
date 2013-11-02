/**
 * 
 */
package Model;

import java.util.ArrayList;

/** 
 * @author artur
 */
public class Collection {
	Collection(String studyPath)
	{
		
	}
	/**
	 * @uml.property  name="_imageContainer"
	 * @uml.associationEnd  multiplicity="(1 1)" aggregation="composite" inverse="collection:design.ImageContainer"
	 */
	private ImageContainer _imageContainer;
	private ArrayList<String> _allImagePaths = new ArrayList<String>();

	/**
	 * Getter of the property <tt>_imageContainer</tt>
	 * @return  Returns the _imageContainer.
	 * @uml.property  name="_imageContainer"
	 */
	public ImageContainer get_imageContainer() {
		return _imageContainer;
	}

	/**
	 * Setter of the property <tt>_imageContainer</tt>
	 * @param _imageContainer  The _imageContainer to set.
	 * @uml.property  name="_imageContainer"
	 */
	public void set_imageContainer(ImageContainer _imageContainer) {
		this._imageContainer = _imageContainer;
	}
	
	}