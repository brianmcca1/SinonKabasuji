package sinon.views;

/**
 * Both the bullpenView and bankView register controllers to their hexominos
 * dynamically. This interface is for allowing the Main application class to
 * inject the type of controller that needs to be dynamically registered to the
 * views as they are added.
 * 
 * @author Josh Desmond
 */
public interface HexRegistrator {

	/**
	 * Registers a given HexominoView to the controller which this class uses.
	 * This logic will change depending on what the controller needs for
	 * instantiation.
	 * 
	 * @param view
	 *            The HexominoView to register a controller to.
	 */
	public void registerHexominoView(HexominoBullpenView view);
}
