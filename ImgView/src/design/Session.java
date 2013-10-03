/**
 * 
 */
package design;
import java.util.Observable;
/** 
 * @author artur
 */
public class Session extends Observable{

	
	public void chgStudy(String path)
	{
		_dirPath=path;
		collection=new ImageContainer(path);
		nbrImages = collection.findSize(path);
		currentImage = 0;
		displayState = 4;
		doNext();
		if (nbrImages==0)notifyObservers(-1);
	}
	/** 
	 * @uml.property name="imageCont"
	 * @uml.associationEnd multiplicity="(1 1)" aggregation="shared" inverse="session:design.ImageContainer"
	 */
	private int displayState;
	private ImageContainer collection;
	private int currentImage;
	private int nbrImages;
	String _dirPath;

	/** 
	 * Getter of the property <tt>imageCont</tt>
	 * @return  Returns the imageCont.
	 * @uml.property  name="imageCont"
	 */
	public ImageContainer getCollection() {
		return collection;
	}

	/** 
	 * Setter of the property <tt>imageCont</tt>
	 * @param imageCont  The imageCont to set.
	 * @uml.property  name="imageCont"
	 */
	public void setCollection(ImageContainer  imageCont) {
		this.collection = imageCont;
	}
	
	public void doNext() {
		int overload=(currentImage+displayState)-nbrImages;
		if (overload<displayState){	
			setChanged();
			if(overload<=0){
			notifyObservers(collection.doNext(currentImage, displayState));
			currentImage+=displayState;
			}
			else{
			notifyObservers(collection.doNext(currentImage, displayState-overload));
			currentImage=nbrImages-1;
			}
		}
	}
	
	public void doPrevious() {
		if (currentImage-2*displayState>=0)
		{
			setChanged();
			currentImage=currentImage-2*displayState;
			if(currentImage>=displayState){
			notifyObservers(collection.doPrevious(currentImage, displayState));
			currentImage=currentImage+displayState;
			}else{
			notifyObservers(collection.doPrevious(currentImage, currentImage));
			currentImage=0;
			}
		}
	}
	
	public void changeState(int toState) {
		currentImage = currentImage-displayState;
		if (currentImage<0)currentImage=0;
		if (currentImage+toState>=nbrImages)currentImage=nbrImages-toState-1;
		displayState = toState;
		setChanged();
		notifyObservers(collection.doNext(currentImage, toState));
	}

	@Override
	public synchronized boolean hasChanged() {
		// TODO Auto-generated method stub
		return super.hasChanged();
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.notifyObservers();
	}
	

}