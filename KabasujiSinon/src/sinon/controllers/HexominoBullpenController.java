package sinon.controllers;

import java.awt.event.MouseEvent;

import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * This controller responds to mouse interactions with HexominoBullpenViews in
 * the BullpenView.
 */

public class HexominoBullpenController extends AbstractHexStashController {

	BullPen bullpen;

	public HexominoBullpenController(Level level, MainView mainView,
			HexominoBullpenView hex) {
		super(level, mainView, hex);
		this.bullpen = level.getBullpen();
	}

	/** Hexomino model that's associated with this controller. */
	Hexomino hex;

	/**
	 * Event where a hexomino gets selected from the bullpen.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	protected void handleClicked() {
		System.out
		.println("I AM A BULLPEN HEXOMINO AND I JUST GOT CLICKED ON!");

		if (level.hasSelected()) {
			Hexomino alreadySelected = level.selectedHexomino.get();
			this.level.getBullpen().addHexomino(alreadySelected);

			level.deselect();
			System.out.println("SELECTED HEXOMINO HAS BEEN DESELECTED");
		} else {
			level.select(hex);
			System.out.println("NEWLY SELECTED HEXOMINO: "
					+ level.selectedHexomino.toString());
		}
	}
}
