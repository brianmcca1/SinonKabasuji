package sinon.controllers;

import sinon.models.Board;
import sinon.models.Level;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * Tile Controller for game specific interactions.
 * 
 * @author Peter Debrine
 * @author Josh Desmond
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
	public void handleLeftClick() {
		System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");

		if (level.hasSelected()) {

			if (level.getBullpen().containsHexID(level.getSelectedHexomino().get().getID())) {
				// else move from bullpen to board
				MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(
						this.level, this.tileView.getRow(),
						this.tileView.getColumn());

				if (move.doMove()) {
					System.out.println("Move successfully completed!");
					level.deselect();
				} else {
					System.out.println("There was some error doing the move.");
				}
			}

			else if (level.getBoard().containsHexID(level.getSelectedHexomino().get().getID())) {
				// then move from board to board
				int x, y;
				x = level.getBoard().getHexominoLocation(
						level.getSelectedHexomino().get()).x;
				y = level.getBoard().getHexominoLocation(
						level.getSelectedHexomino().get()).y;
				MoveInBoard move = new MoveInBoard(level, x, y,
						this.tileView.getRow(), this.tileView.getColumn());

				if (move.doMove()) {
					System.out.println("The move was successfully completed!");
					level.deselect();
				} else {
					System.out.println("The move couldn't be completed!");
				}

			}
		} else {
			if (this.tileView.getTile().hasHex()) {
				level.select(this.tileView.getTile().getHexomino().get());
			}
		}

	}

	@Override
	public void handleRightClick() {
		// Do nothing.
	}

}
