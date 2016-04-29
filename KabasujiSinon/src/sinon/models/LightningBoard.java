package sinon.models;

import java.awt.Point;

import sinon.models.data.BoardData;

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
