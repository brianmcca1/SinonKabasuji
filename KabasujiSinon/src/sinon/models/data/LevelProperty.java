package sinon.models.data;

import java.util.List;

import sinon.models.ReleaseNumber;
import sinon.models.data.LevelType.Types;

public class LevelProperty {
	Integer maxTime;
	Integer maxMoves;
	List<ReleaseNumber> releaseSet;

	public LevelProperty(int levelProperty, Types t) {

		if (t == Types.PUZZLE) {
			this.maxMoves = levelProperty;
		} else if (t == Types.LIGHTNING) {
			this.maxTime = levelProperty;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public LevelProperty(List<ReleaseNumber> levelProperty, Types t) {
		if (t == Types.RELEASE) {
			this.releaseSet = levelProperty;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getMaxMoves() {
		if (this.maxMoves == null) {
			return this.maxMoves;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getMaxTime() {
		if (this.maxTime == null) {
			return this.maxTime;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public List<ReleaseNumber> getReleaseSet() {
		if (this.releaseSet == null) {
			return this.releaseSet;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
