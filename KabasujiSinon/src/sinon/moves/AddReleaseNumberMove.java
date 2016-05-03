package sinon.moves;

import java.util.Objects;

import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.models.ReleaseTile;

/**
 * Adding a ReleaseNumber to a Tile in a Release Level.
 * This is counted as a move because it can be undone.
 * 
 * @author Brian
 *
 */
public class AddReleaseNumberMove extends Move {

	/** Release number that is being added to the tile. */
	ReleaseNumber releaseNumber;

	/** The release tile that is being added to.  */
	ReleaseTile releaseTile;

	/** The main release level. */
	ReleaseLevel level;

	/** Constructor takes in a level and the release tile. */
	public AddReleaseNumberMove(ReleaseLevel level, ReleaseTile releaseTile) {
		this.level = Objects.requireNonNull(level);
		this.releaseNumber = level.getSelectedReleaseNumber();
		this.releaseTile = releaseTile;
	}

	@Override
	public boolean doMove() {
		if (!this.valid()) {
			return false;
		}
		releaseTile.addReleaseNumber(releaseNumber);
		this.level.deselectReleaseNumber();
		return true;
	}

	@Override
	public boolean undo() {
		if (!releaseTile.hasReleaseNumber()) {
			return false;
		}
		releaseTile.removeReleaseNumber();
		return true;
	}

	/** Determine if the move is valid */ 
	public boolean valid() {
		if (releaseTile.hasReleaseNumber()) {
			return false;
		}

		return true;
	}
	

}
