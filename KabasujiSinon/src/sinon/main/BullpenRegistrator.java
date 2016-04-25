package sinon.main;

import java.util.Objects;

import sinon.controllers.HexominoBullpenController;
import sinon.models.Level;
import sinon.views.BullpenView;
import sinon.views.HexRegistrator;
import sinon.views.HexominoBullpenView;

/**
 * A BullpenRegistrator registers HexominoBullpenControllers to HexominoBullpenViews.
 * 
 * @see BullpenView
 * @author Josh Desmond
 */
public class BullpenRegistrator implements HexRegistrator {

	private Level level;
	private BullpenView bullpenView;

	/**
	 * Creates a new BullpenRegistrator.
	 * 
	 * @param level
	 *            For use in constructing each controller
	 * @param bullpenView
	 *            For use in constructing each controller
	 */
	public BullpenRegistrator(Level level, BullpenView bullpenView) {
		this.level = Objects.requireNonNull(level);
		this.bullpenView = Objects.requireNonNull(bullpenView);
	}

	@Override
	public void registerHexominoView(HexominoBullpenView view) {
		// TODO Auto-generated method stub
		view.addMouseListener(new HexominoBullpenController(view, level,
				bullpenView));
	}

}
