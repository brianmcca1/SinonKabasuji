package sinon.controllers;

import java.awt.Point;

import sinon.models.ReleaseLevel;
import sinon.models.ReleaseTile;
import sinon.models.data.LevelType.Types;
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
					if (this.level.getLevelData().getLevelType() != Types.LIGHTNING) {
						this.tile.getHexomino().get()
								.setAnchor(new Point(this.tileView.getRow(), this.tileView.getColumn()));
					}
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
		} else if (this.level.hasSelectedReleaseNumber() && this.tile.isPlayable()) {
			AddReleaseNumberMove move = new AddReleaseNumberMove(this.level, this.tile);
			if (move.doMove()) {
				level.pushMove(move);
			}

		} else if (this.tileView.getTile().hasHex()) {
			level.select(this.tileView.getTile().getHexomino().get());
		} else {
			ReleaseTile releaseTile = (ReleaseTile) this.tileView.getTile();
			if (releaseTile.hasReleaseNumber()) {
				releaseTile.removeReleaseNumber();
			}

		}
	}
}
