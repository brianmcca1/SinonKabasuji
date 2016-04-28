package sinon.models.data;

import java.util.List;
import java.util.Optional;

import sinon.models.ReleaseNumber;
import sinon.models.data.LevelType.Types;

public class LevelProperty {
	Optional<Integer> maxTime = Optional.empty();
	Optional<Integer> maxMoves = Optional.empty();
	Optional<List<ReleaseNumber>> releaseSet = Optional.empty();

	public LevelProperty(int levelProperty, Types t) {

		if (t == Types.PUZZLE) {
			this.maxMoves = Optional.of(levelProperty);
		} else if (t == Types.LIGHTNING) {
			this.maxTime = Optional.of(levelProperty);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public LevelProperty(List<ReleaseNumber> levelProperty, Types t) {
		if (t == Types.RELEASE) {
			this.releaseSet = Optional.of(levelProperty);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getMaxMoves() {
		if (this.maxMoves.isPresent()) {
			return this.maxMoves.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getMaxTime() {
		if (this.maxTime.isPresent()) {
			return this.maxTime.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public List<ReleaseNumber> getReleaseSet() {
		if (this.releaseSet.isPresent()) {
			return this.releaseSet.get();
		} else {
			throw new IllegalArgumentException();
		}
	}
}
