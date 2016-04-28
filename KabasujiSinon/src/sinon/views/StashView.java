package sinon.views;

import javax.swing.JPanel;

import sinon.main.HexStashRegistrator;

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
