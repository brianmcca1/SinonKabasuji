package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.models.Hexomino;

/**
 * This controller responds to mouse interactions with HexominoBullpenViews in the BullpenView.
 */
@Deprecated
public class HexominoBullpenController extends AbstractHexStashController implements MouseListener{



	/** Hexomino model that's associated with this controller. */
	Hexomino hex;

	/** Event where a hexomino gets selected
	 * from the bullpen.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("I AM A BULLPEN HEXOMINO AND I JUST GOT CLICKED ON!");

		if(level.hasSelected()) {
			Hexomino alreadySelected = level.selectedHexomino.get();
			this.level.getBullpen().addHexomino(alreadySelected);
			bpview.redrawBullpenView();
			level.deselect();
			System.out.println("SELECTED HEXOMINO HAS BEEN DESELECTED");
		}
		else {
			level.select(hex);
			System.out.println("NEWLY SELECTED HEXOMINO: " + level.selectedHexomino.toString());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
