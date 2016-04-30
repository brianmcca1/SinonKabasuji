package sinon.controllers;

import java.awt.Point;
import java.awt.event.MouseEvent;

import sinon.models.Level;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
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

	public BuilderTileController(Level level, TileView tileView,
			MainView mainView) {
		super(level, tileView, mainView);
	}

	

	@Override
	public void handleRightClick() {
		System.out.println("I AM A TILEVIEW AND I WAS JUST RIGHT CLICKED ON");
		// int row = tileView.getRow();
		// int column = tileView.getColumn();

		// tileView.toggleColor();
		System.out.println("PLAYABLE BEFORE: "
				+ tileView.getTile().isPlayable());
		tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
		System.out
		.println("PLAYABLE AFTER: " + tileView.getTile().isPlayable());
	}

	


	

}
