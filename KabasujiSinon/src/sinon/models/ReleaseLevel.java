package sinon.models;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Optional;

import sinon.models.data.LevelType.Types;

/**
 * This is the model class that extends the main level class.
 * It encapsulates the attributes and behaviors that are 
 * exclusive to the release level.
 *
 */
public class ReleaseLevel extends Level {

	Optional<ReleaseNumber> selectedReleaseNumber = Optional.empty();
	List<ReleaseNumber> releaseSets;

	public ReleaseLevel(Board b, BullPen bp, List<ReleaseNumber> releaseSets) {
		super(Types.RELEASE, b, bp);
		this.releaseSets = releaseSets;
		((ReleaseBoard) this.getBoard()).addReleaseSet(this.releaseSets);
	}

	public ReleaseLevel(Level level) {
		super(Types.RELEASE, level.getBoard(), level.getBullpen());
		this.levelData = level.getLevelData();
		this.releaseSets = level.getLevelData().getLevelProperty().getReleaseSet();
		((ReleaseBoard) this.getBoard()).addReleaseSet(this.releaseSets);
	}

	@Override
	public int countStars() {
		boolean redCollected = true;
		boolean greenCollected = true;
		boolean yellowCollected = true;
		int stars = 0;

		for (ReleaseNumber r : this.releaseSets) {
			if (r.getColor() == Color.RED & !(r.isCollected())) {
				redCollected = false;
			}
			if (r.getColor() == Color.GREEN & !(r.isCollected())) {
				greenCollected = false;
			}
			if (r.getColor() == Color.YELLOW & !(r.isCollected())) {
				yellowCollected = false;
			}
		}
		if (redCollected) {
			stars++;
		}
		if (greenCollected) {
			stars++;
		}
		if (yellowCollected) {
			stars++;
		}
		return stars;
	}

	public void collectReleaseSet(Point location) {
		for (ReleaseNumber r : this.releaseSets) {
			if (r.getLocation().equals(location)) {
				r.collect();
			}
		}
	}

	public boolean hasSelectedReleaseNumber() {
		return this.selectedReleaseNumber.isPresent();
	}

	public void selectReleaseNumber(ReleaseNumber releaseNumber) {
		this.selectedReleaseNumber = Optional.of(releaseNumber);
	}

	public void deselectReleaseNumber() {
		this.selectedReleaseNumber = Optional.empty();
	}

	public ReleaseNumber getSelectedReleaseNumber() {
		return this.selectedReleaseNumber.get();
	}

}
