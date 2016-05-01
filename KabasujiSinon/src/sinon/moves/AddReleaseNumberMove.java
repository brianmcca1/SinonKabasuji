package sinon.moves;

import java.util.Objects;

import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.models.ReleaseTile;

/**
 * Adding a ReleaseNumber to a Tile in a Release Level
 * 
 * @author Brian
 *
 */
public class AddReleaseNumberMove extends Move {

	ReleaseNumber releaseNumber;

	ReleaseTile releaseTile;

	ReleaseLevel level;

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

	public boolean valid() {
		if (releaseTile.hasReleaseNumber()) {
			return false;
		}

		return true;
	}

}
