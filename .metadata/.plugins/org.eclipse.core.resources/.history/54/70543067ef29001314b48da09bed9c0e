/**
 * 
 */
package Design;

import java.util.List;

/** 
 * @author artur
 */
public interface WindowFactory {

		
			
	public abstract void CreateWindow(List imgList);

	/**
	 * @return  Returns the mainView.
	 * @uml.property  name="mainView" default="new Design.MainView()"
	 * @uml.associationEnd  multiplicity="(1 1)" aggregation="shared" inverse="windowFactory:Design.MainView"
	 */
	public MainView getMainView();

	/**
	 * Setter of the property <tt>mainView</tt>
	 * @param mainView  The mainView to set.
	 * @uml.property  name="mainView"
	 */
	public void setMainView(MainView mainView);

	/**
	 * @return  Returns the mainView1.
	 * @uml.property  name="mainView1" default="new Design.MainView()"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="windowFactory1:Design.MainView"
	 */
	public MainView getMainView1();

	/**
	 * Setter of the property <tt>mainView1</tt>
	 * @param mainView1  The mainView1 to set.
	 * @uml.property  name="mainView1"
	 */
	public void setMainView1(MainView mainView1);
			
	
}
