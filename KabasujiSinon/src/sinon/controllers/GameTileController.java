package sinon.controllers;

import java.awt.event.MouseEvent;

import sinon.models.Board;
import sinon.models.Level;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * This is the tile controller in the game that is mostly responsible 
 * for firing off moves, setting shadows, etc.
 * @author kartik
 *
 */
public class GameTileController extends TileController {

	public GameTileController(Level level, TileView view, MainView mainView) {
		super(level, view, mainView);
	}

	/** Accesses the board from the fields this class has */
	private Board getBoard() {
		return level.getBoard();
	}


	@Override
	public void handleRightClick() {
		// Do nothing.
	}

	

}
