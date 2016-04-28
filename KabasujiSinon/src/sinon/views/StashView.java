package sinon.views;


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

}
