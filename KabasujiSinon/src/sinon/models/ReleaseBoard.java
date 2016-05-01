package sinon.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import sinon.models.data.BoardData;

/**
 * This is the board for a release level that extends the
 * Board superclass. 
 *
 */
public class ReleaseBoard extends Board {

	public ReleaseBoard() {
		super();
	}

	public ReleaseBoard(BoardData boardData) {
		super(boardData);
	}

	@Override
	protected void initializeTiles(Point p, boolean playable) {
		ReleaseTile tile = new ReleaseTile(p, playable);

		tilesViaPoints.put(p, new ReleaseTile(p, playable));

	}

	/**
	 * Gets the Release Set for the Release Numbers on the board
	 * 
	 * @return The Release Set
	 */
	public ArrayList<ReleaseNumber> getReleaseSet() {
		ArrayList<ReleaseNumber> releaseSet = new ArrayList<ReleaseNumber>();
		for (Tile t : this.getTiles()) {
			ReleaseTile releaseTile = (ReleaseTile) t;
			if (releaseTile.hasReleaseNumber()) {
				releaseSet.add(releaseTile.getReleaseNumber().get());
			}
		}
		return releaseSet;
	}

	/**
	 * TODO
	 * 
	 * Must be a valid release set to be added to a board.
	 * 
	 * @param releaseSet
	 */
	public void addReleaseSet(List<ReleaseNumber> releaseSet) {

		for (ReleaseNumber r : releaseSet) {
			if (r.hasLocation()) {
				ReleaseTile tile = (ReleaseTile) tilesViaPoints.get((r.getLocation().get()));
				tile.addReleaseNumber(r);
			}
		}
	}
}
