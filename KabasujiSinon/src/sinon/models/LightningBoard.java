package sinon.models;

import java.awt.Point;

public class LightningBoard extends Board {

	@Override
	protected void initializeTiles(Point p, boolean playable) {
		tilesViaPoints.put(p, new LightningTile(p, playable));
	}
}
