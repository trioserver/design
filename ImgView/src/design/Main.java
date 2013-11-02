/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		Main.java
 * Description: Allows access to main controller and handles termination
 */

package design;

import javax.swing.SwingUtilities;

import View.MainView;

/** Main class */
public class Main {

	/**
	 * The main method
	 * @param args	command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	MainView ex = new MainView();
            	ex.setVisible(true);
            }
        });
	}
}
