package sinon.controllers;

import sinon.models.ReleaseLevel;
import sinon.models.ReleaseTile;
import sinon.moves.AddReleaseNumberMove;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * This is the tile controller that is exclusively responsible for handling
 * interactions with the tiles in a release level.
 *
 */
public class ReleaseBuilderTileController extends BuilderTileController {

	ReleaseLevel level;
	TileView tileView;
	MainView mainView;
	ReleaseTile tile;

	public ReleaseBuilderTileController(ReleaseLevel level, TileView tileView, MainView mainView) {
		super(level, tileView, mainView);
		this.level = level;
		this.tileView = tileView;
		this.mainView = mainView;
		this.tile = (ReleaseTile) tileView.getTile();
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
					System.out.println("Move successfully completed!");
					level.deselect();
				} else {
					System.out.println("There was some error doing the move.");
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
					System.out.println("The move was successfully completed!");
					level.deselect();
				} else {
					System.out.println("The move couldn't be completed!");
				}

			}
		} else if (this.level.hasSelectedReleaseNumber() && this.tile.isPlayable()) {
			AddReleaseNumberMove move = new AddReleaseNumberMove(this.level, this.tile);
			if (move.doMove()) {
				level.pushMove(move);
				System.out.println("The ReleaseNumber was successfully added!");
			} else {
				System.out.println("The move couldn't be completed!");
			}

		} else {
			if (this.tileView.getTile().hasHex()) {
				level.select(this.tileView.getTile().getHexomino().get());
			}
		}
	}
}
