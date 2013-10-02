/**
 * 
 */
package design;

import java.awt.image.BufferedImage;
import java.util.List;

/** 
 * @author artur
 */
public class Win1Fact implements WindowFactory {

	Win1Fact(List<BufferedImage> list)
	{
		_oneWins = new design.OneWins(list);
	}
	/**
	 * @uml.property  name="_oneWins"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="win1Fact:design.OneWins"
	 */
	private OneWins _oneWins;

	/**
	 * Getter of the property <tt>_oneWins</tt>
	 * @return  Returns the _oneWins.
	 * @uml.property  name="_oneWins"
	 */
	public OneWins get_oneWins() {
		return _oneWins;
	}

	/**
	 * Setter of the property <tt>_oneWins</tt>
	 * @param _oneWins  The _oneWins to set.
	 * @uml.property  name="_oneWins"
	 */
	public void set_oneWins(OneWins _oneWins) {
		this._oneWins = _oneWins;
	}

}
