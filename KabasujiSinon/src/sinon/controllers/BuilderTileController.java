package sinon.controllers;

import java.awt.Point;

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
			Hint toBeAdded = new Hint(tileView.getTile().getHexomino().get(), new Point(tileView.getRow(), tileView.getColumn()));
			Move AddHint = new AddHint(this.level, toBeAdded);
			AddHint.doMove();
			this.mainView.getBoardView().updateHints();
			this.level.pushMove(AddHint);
		} else {
			tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
		}
	}

}
