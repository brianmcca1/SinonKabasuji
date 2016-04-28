package sinon.controllers;

import sinon.models.Level;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * Tile controller for builder specific interactions.
 */
public class BuilderTileController extends TileController {

	public BuilderTileController(Level level, TileView tileView,
			MainView mainView) {
		super(level, tileView, mainView);
	}

	@Override
	public void handleLeftClick() {
		if (level.hasSelected()) {

			if (level.getBullpen().containsHexID(
					level.getSelectedHexomino().get().getID())) {
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
