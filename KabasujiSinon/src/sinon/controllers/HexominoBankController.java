package sinon.controllers;

import sinon.models.BullPen;
import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * This controller responds to mouse interactions with the HexominoBullpenViews
 * in the bank of the builder.
 * 
 * @author kartik
 */
public class HexominoBankController extends AbstractHexStashController {

	private BullPen bullpen;

	public HexominoBankController(Level level, MainView mainView,
			HexominoBullpenView hex) {
		super(level, mainView, hex);
		this.bullpen = level.getBullpen();
		assert bullpen != null;
	}

	@Override
	protected void handleClicked() {
		System.out.println("I AM A BANK HEXOMINO AND I GOT CLICKED ON");
		bullpen.addHexomino(this.hex.getHexomino());
		System.out.println(this.bullpen.getPieces().toString());
	}
}
