package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import javax.swing.SwingUtilities;

import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * Is the controller which gets added to Bullpen Hexominos and Bank Hexominos.
 */
public abstract class AbstractHexStashController implements MouseListener {

	/** Current level that the game/builder is in. */
	Level level;
	/** MainView associated with the current level */
	MainView mainView;
	/** HexominoView associated with this controller. */
	HexominoBullpenView hex;

	/**
	 * Creates a new HexominoStashController
	 * 
	 * @param level
	 *            Level for access to the applications model.
	 * @param mainView
	 *            View for access to the applications view.
	 * @param hex
	 *            Panel which the controller is applied to.
	 */
	public AbstractHexStashController(Level level, MainView mainView, HexominoBullpenView hex) {
		this.level = Objects.requireNonNull(level);
		this.mainView = Objects.requireNonNull(mainView);
		this.hex = Objects.requireNonNull(hex);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * This method should contain the logic for handling a left mouse click on
	 * the HexominoPanel in the stash.
	 */
	protected abstract void handleLeftClicked();

	/**
	 * This method should contain the logic for handling a right mouse click on
	 * the HexominoPanel in the stash.
	 */
	protected abstract void handleRightClicked();

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			handleLeftClicked();
		} else {
			handleRightClicked();
		}
	};

	@Override
	public void mouseReleased(MouseEvent e) {
	};

	@Override
	public void mouseEntered(MouseEvent e) {
	};

	@Override
	public void mouseExited(MouseEvent e) {
	};

}
