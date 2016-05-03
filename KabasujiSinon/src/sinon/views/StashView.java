package sinon.views;

import javax.swing.JPanel;

import sinon.controllers.HexStashRegistrator;

/**
 * The interface used to stash views.
 * @author PDeBrine.
 *
 */
public interface StashView {

	/**
	 * Sets the HexStashRegistrator of the View. This is to be done after the
	 * view is initialized.
	 * 
	 * @param hexStashRegistrator
	 *            Registrator which this StashView will use.
	 */
	void setRegistrator(HexStashRegistrator hexStashRegistrator);

	/**
	 * Gets the panel where you should register bankController or
	 * BullpenController
	 * 
	 * @return JPanel to register controller
	 */
	JPanel getPanelToRegisterController();

}
