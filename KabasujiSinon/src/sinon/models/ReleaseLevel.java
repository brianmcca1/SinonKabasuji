package sinon.models;

import java.awt.Point;
import java.util.List;
import java.util.Optional;

import sinon.models.data.LevelType.Types;

public class ReleaseLevel extends Level {

	Optional<ReleaseNumber> selectedReleaseNumber = Optional.empty();
	List<ReleaseNumber> releaseSets;

	int setsCompleted;

	public ReleaseLevel(Board b, BullPen bp, List<ReleaseNumber> releaseSets) {
		super(Types.RELEASE, b, bp);
		this.releaseSets = releaseSets;
		setsCompleted = 0;
	}

	public ReleaseLevel(Level level) {
		super(Types.RELEASE, level.getBoard(), level.getBullpen());
		// Will work if we adjust LevelProperty to the new version
		this.releaseSets = level.getLevelData().getLevelProperty().getReleaseSet();
		setsCompleted = 0;
	}

	@Override
	public int countStars() {
		boolean redCollected = true;
		boolean greenCollected = true;
		boolean yellowCollected = true;
		int stars = 0;

		for (ReleaseNumber r : this.releaseSets) {
			if (r.getColor() == "red" & !(r.getCollected())) {
				redCollected = false;
			}
			if (r.getColor() == "green" & !(r.getCollected())) {
				greenCollected = false;
			}
			if (r.getColor() == "yellow" & !(r.getCollected())) {
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

	public void selectReleaseNumber(ReleaseNumber releaseNumber) {
		this.selectedReleaseNumber = Optional.of(releaseNumber);
	}

	public void deselectReleaseNumber(ReleaseNumber releaseNumber) {
		this.selectedReleaseNumber = Optional.empty();
	}

	public ReleaseNumber getSelectedReleaseNumber() {
		return this.selectedReleaseNumber.get();
	}

}
