package sinon.models.data;

import java.io.Serializable;
import java.util.ArrayList;

import sinon.models.ReleaseNumber;
import sinon.models.data.LevelType.Types;

public class LevelProperty implements Serializable {

	private static final long serialVersionUID = -166019953009468288L;
	Integer maxTime;
	Integer maxMoves;
	ArrayList<ReleaseNumberData> releaseSet;

	public LevelProperty(int levelProperty, Types t) {

		if (t == Types.PUZZLE) {
			this.maxMoves = levelProperty;
		} else if (t == Types.LIGHTNING) {
			this.maxTime = levelProperty;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public LevelProperty(ArrayList<ReleaseNumber> levelProperty, Types t) {
		if (t == Types.RELEASE) {
			ArrayList<ReleaseNumberData> releaseSet = new ArrayList<ReleaseNumberData>();
			for (ReleaseNumber r : levelProperty) {
				releaseSet.add(new ReleaseNumberData(r));
			}
			this.releaseSet = releaseSet;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getMaxMoves() {
		if (this.maxMoves != null) {
			return this.maxMoves;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getMaxTime() {
		if (this.maxTime != null) {
			return this.maxTime;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public ArrayList<ReleaseNumber> getReleaseSet() {
		if (this.releaseSet != null) {
			ArrayList<ReleaseNumber> releaseSetNumbers = new ArrayList<ReleaseNumber>();
			for (ReleaseNumberData r : this.releaseSet) {
				releaseSetNumbers.add(new ReleaseNumber(r));
			}
			return releaseSetNumbers;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
