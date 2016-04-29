package sinon.models;

import java.awt.Point;

import sinon.models.data.BoardData;

public class ReleaseBoard extends Board {

	public ReleaseBoard() {
		super();
	}

	public ReleaseBoard(BoardData boardData) {
		super(boardData);
	}

	@Override
	protected void initializeTiles(Point p, boolean playable) {
		tilesViaPoints.put(p, new ReleaseTile(p, playable));
	}
}
