package sinon.models;

import java.awt.Point;

public class ReleaseBoard extends Board {
	@Override
	protected void initializeTiles(Point p, boolean playable) {
		tilesViaPoints.put(p, new ReleaseTile(p, playable));
	}
}
