package sinon.models;

import java.awt.Point;

import sinon.models.data.BoardData;

/**
 * This is the subclass lightning board that extends the
 * main Board class. We need this because the tiles in a lightning
 * level behave in different ways than the tiles in puzzle/release
 * levels.
 *
 */
public class LightningBoard extends Board {

	public LightningBoard() {
		super();
	}

	public LightningBoard(BoardData boardData) {
		super(boardData);
	}

	@Override
	protected void initializeTiles(Point p, boolean playable) {
		tilesViaPoints.put(p, new LightningTile(p, playable));
	}
}
