package sinon.controllers;

import java.awt.Point;

import sinon.models.Hexomino;
import sinon.models.Hint;
import sinon.models.Level;
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

	public BuilderTileController(Level level, TileView tileView, MainView mainView) {
		super(level, tileView, mainView);
	}

	@Override
	public void handleRightClick() {

		if(tileView.getTile().hasHex()) {
			Hexomino hex = tileView.getTile().getHexomino().get();
			Point anchor = new Point(tileView.getRow(), tileView.getColumn());
			Hint toBeAdded = new Hint(hex, anchor);
			Move AddHint = new AddHint(this.level, toBeAdded);
			AddHint.doMove();
			this.level.pushMove(AddHint);
		} else {
			tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
		}
	}

}
