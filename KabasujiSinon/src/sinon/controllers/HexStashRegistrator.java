package sinon.controllers;

import java.awt.event.MouseListener;
import java.util.Objects;

import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * Assigns HexominoControllers to Hexominos in the Bullpen and Bank.
 * 
 * Since the BullpenView and the BankView have a dynamically changing number of
 * controllers, they will each have a HexStashRegistrator which they can use to
 * assign controllers to it.
 * 
 * To create an instance of this class, you can use one of the two public static
 * fields {@link #BANK_CONTROLLER} or {@link #BULLPEN_CONTROLLER}. These are the
 * default controllers for the Bank and Bullpen Hexominos.
 * 
 * @author Josh Desmond
 */
public class HexStashRegistrator {

	/** True if this should be registering bank controllers */
	boolean isBankType;
	/** Model which is associated with the controllers which are to be built. */
	Level level;
	/** View which is associated with the controllers which are to be built */
	MainView mainView;

	/**
	 * Creates a new HexStashRegistrator.
	 * 
	 * @param level
	 *            Model which is associated with the controllers which are to be
	 *            built.
	 * @param mainView
	 *            View which is associated with the controllers which are to be
	 *            built.
	 * @param isBankType
	 *            True if the registrator should be registering bank
	 *            controllers. False if it should be registering Bullpen
	 *            controllers.
	 */
	public HexStashRegistrator(Level level, MainView mainView,
			boolean isBankType) {
		this.level = Objects.requireNonNull(level);
		this.mainView = Objects.requireNonNull(mainView);
		this.isBankType = isBankType;
	}

	/**
	 * Registers a Hexomino using this classes
	 * 
	 * @param hex
	 */
	public void registerHexominoView(HexominoBullpenView hex) {
		assert hex != null;
		assert level != null;
		assert mainView != null;

		if (isBankType) {
			MouseListener m = new HexominoBankController(level, mainView, hex);
			hex.addMouseListener(m);
		}

		else {
			MouseListener m = new HexominoBullpenController(level, mainView,
					hex);
			hex.addMouseListener(m);
		}
	}
}