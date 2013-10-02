/**
 * 
 */
package design;
import java.util.Observable;
/** 
 * @author artur
 */
public class Session extends Observable{

	/** 
	 * @uml.property name="collection"
	 * @uml.associationEnd multiplicity="(1 1)" aggregation="shared" inverse="session:design.Collection"
	 */
	private Collection collection = new design.Collection();

	/** 
	 * Getter of the property <tt>collection</tt>
	 * @return  Returns the collection.
	 * @uml.property  name="collection"
	 */
	public Collection getCollection() {
		return collection;
	}

	/** 
	 * Setter of the property <tt>collection</tt>
	 * @param collection  The collection to set.
	 * @uml.property  name="collection"
	 */
	public void setCollection(Collection collection) {
		this.collection = collection;
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