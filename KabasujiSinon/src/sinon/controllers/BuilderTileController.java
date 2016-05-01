package sinon.controllers;

import sinon.models.Level;
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
		System.out.println("PLAYABLE BEFORE: " + tileView.getTile().isPlayable());
		tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
		System.out.println("PLAYABLE AFTER: " + tileView.getTile().isPlayable());
	}

}
