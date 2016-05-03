package sinon.models;

import java.awt.Point;

import sinon.models.data.BoardData;

/**
 * This is the subclass lightning board that extends the main Board class. We
 * need this because the tiles in a lightning level behave in different ways
 * than the tiles in puzzle/release levels.
 *
 */
public class LightningBoard extends Board {

	/**
	 * Creates a 12x12 empty LightningBoard.
	 */
	public LightningBoard() {
		super();
	}

	/**
	 * Creates a LightningBoard from the given Board Data.
	 * 
	 * @param boardData
	 *            The BoardData to base the LightningBoard off of.
	 */
	public LightningBoard(BoardData boardData) {
		super(boardData);
	}

	@Override
	protected void initializeTiles(Point p, boolean playable) {
		tilesViaPoints.put(p, new LightningTile(p, playable));
	}
}
