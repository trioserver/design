/**
 * 
 */
package design;

import javax.swing.JLabel;

/** 
 * @author artur
 */
public class Win4Fact implements WindowFactory {

	/**
	 * @uml.property  name="fourWins"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="win4Fact:design.FourWins"
	 */
	private FourWins fourWins = new design.FourWins();

	/**
	 * Getter of the property <tt>fourWins</tt>
	 * @return  Returns the fourWins.
	 * @uml.property  name="fourWins"
	 */
	public JLabel getWindow() {
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
