package sinon.controllers;

import sinon.models.Level;
import sinon.models.data.LevelType.Types;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * This is the tile controller in the game that is mostly responsible for firing
 * off moves, setting shadows, etc.
 * 
 * @author kartik
 *
 */
public class GameTileController extends TileController {

	public GameTileController(Level level, TileView view, MainView mainView) {
		super(level, view, mainView);
	}

	@Override
	public void handleRightClick() {
		// Do nothing.
	}

	@Override
	public void handleLeftClick() {

		if (level.hasSelected()) {

			if (level.getBullpen().containsHexID(level.getSelectedHexomino().get().getID())) {
				// else move from bullpen to board
				MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(this.level, this.tileView.getRow(),
						this.tileView.getColumn());

				if (move.doMove()) {
					level.pushMove(move);
					level.deselect();
				}
			}

			else if (level.getBoard().containsHexID(level.getSelectedHexomino().get().getID())) {
				// then move from board to board
				int x, y;
				x = level.getBoard().getHexominoLocation(level.getSelectedHexomino().get()).x;
				y = level.getBoard().getHexominoLocation(level.getSelectedHexomino().get()).y;
				MoveInBoard move = new MoveInBoard(level, x, y, this.tileView.getRow(), this.tileView.getColumn());

				if (move.doMove()) {
					level.pushMove(move);
					level.deselect();
				}

			}
		} else {
			if (this.tileView.getTile().hasHex() & (this.level.getLevelData().getLevelType() != Types.RELEASE)) {
				level.select(this.tileView.getTile().getHexomino().get());
			}
		}
	}

}
