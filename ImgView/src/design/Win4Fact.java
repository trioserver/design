/**
 * 
 */
package design;

import javax.swing.JComponent;
import javax.swing.JLabel;

/** 
 * @author artur
 */
public class Win4Fact implements WindowFactory {

	/**
	 * @uml.property  name="fourWins"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="win4Fact:design.FourWins"
	 */
	private JComponent fourWins;

	/**
	 * Getter of the property <tt>fourWins</tt>
	 * @return  Returns the fourWins.
	 * @uml.property  name="fourWins"
	 */
	public JComponent getWindow() {
		return fourWins;
	}

	/**
	 * Setter of the property <tt>fourWins</tt>
	 * @param fourWins  The fourWins to set.
	 * @uml.property  name="fourWins"
	 */
	public void setFourWins(FourWins fourWins) {
		this.fourWins = fourWins;
	}

}
