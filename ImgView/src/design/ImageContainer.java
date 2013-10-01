/**
 * 
 */
package design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/** 
 * @author artur
 */
public class ImageContainer {

	/**
	 * @uml.property  name="loadImg"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="imageContainer:design.LoadImg"
	 */
	private ArrayList loadImg = new java.util.ArrayList();

	/**
	 * Getter of the property <tt>loadImg</tt>
	 * @return  Returns the loadImg.
	 * @uml.property  name="loadImg"
	 */
	public ArrayList getLoadImg() {
		return loadImg;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="loadImg"
	 */
	public LoadImg getLoadImg(int i) {
		return (LoadImg) loadImg.get(i);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="loadImg"
	 */
	public Iterator loadImgIterator() {
		return loadImg.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="loadImg"
	 */
	public boolean isLoadImgEmpty() {
		return loadImg.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="loadImg"
	 */
	public boolean containsLoadImg(LoadImg loadImg) {
		return this.loadImg.contains(loadImg);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="loadImg"
	 */
	public boolean containsAllLoadImg(Collection loadImg) {
		return this.loadImg.containsAll(loadImg);
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="loadImg"
	 */
	public int loadImgSize() {
		return loadImg.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="loadImg"
	 */
	public LoadImg[] loadImgToArray() {
		return (LoadImg[]) loadImg.toArray(new LoadImg[loadImg.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="loadImg"
	 */
	public LoadImg[] loadImgToArray(LoadImg[] loadImg) {
		return (LoadImg[]) this.loadImg.toArray(loadImg);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="loadImg"
	 */
	public void addLoadImg(int index, LoadImg loadImg) {
		this.loadImg.add(index, loadImg);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="loadImg"
	 */
	public boolean addLoadImg(LoadImg loadImg) {
		return this.loadImg.add(loadImg);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="loadImg"
	 */
	public Object removeLoadImg(int index) {
		return loadImg.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="loadImg"
	 */
	public boolean removeLoadImg(LoadImg loadImg) {
		return this.loadImg.remove(loadImg);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="loadImg"
	 */
	public void clearLoadImg() {
		loadImg.clear();
	}

	/**
	 * Setter of the property <tt>loadImg</tt>
	 * @param loadImg  the loadImg to set.
	 * @uml.property  name="loadImg"
	 */
	public void setLoadImg(ArrayList loadImg) {
		this.loadImg = loadImg;
	}

}
