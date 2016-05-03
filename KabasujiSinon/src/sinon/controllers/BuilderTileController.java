package sinon.controllers;

import java.awt.Point;

import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.HexominoNumberSet;
import sinon.models.Hint;
import sinon.models.Level;
import sinon.models.Tile;
import sinon.moves.AddHint;
import sinon.moves.Move;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * Tile Controller for builder interactions. This extends the TileController
 * superclass because Tile Click events should behave in different ways between
 * the builder and the game. It is mostly responsible for firing off moves,
 * setting unplayable tiles, etc.
 * 
 * @author kartik
 *
 */
public class BuilderTileController extends TileController {

	/**
	 * Controller for tiles in the builder.
	 * 
	 * @param level
	 *            The level containing the tiles.
	 * @param tileView
	 *            The TileView associated with the tile.
	 * @param mainView
	 *            The MainView object.
	 */
	public BuilderTileController(Level level, TileView tileView, MainView mainView) {
		super(level, tileView, mainView);
	}

	@Override
	public void handleRightClick() {
		// First let's check out if the tile we clicked on has a hint.
		// This is slightly round about logic because a tile does not contain a
		// hint, a board does.
		boolean hasHint = false;
		Hint toRemove = null;
		Board b = level.getBoard();
		for (Hint h : b.getHints()) {
			HexominoNumberSet set = h.getHexominoNumberSet();
			for (Point p : b.getPoints(h.getAnchor(), set)) {
				Tile t = b.getTile(p);
				if (t.getLocation().equals(tileView.getPosition())) {
					// Then we know that the tile contains a hint.
					hasHint = true;
					toRemove = h;
					break;
				}
			}
		}

		if (hasHint) {
			assert toRemove != null;
			b.removeHint(toRemove);
		}

		if (tileView.getTile().hasHex()) {
			Hexomino hex = tileView.getTile().getHexomino().get();
			Point anchor = hex.getAnchor();
			Hint toBeAdded = new Hint(hex, anchor);
			Move AddHint = new AddHint(this.level, toBeAdded);
			AddHint.doMove();
			this.level.pushMove(AddHint);
		} else {
			tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
		}
	}

}
