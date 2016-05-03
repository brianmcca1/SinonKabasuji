package sinon.models.data;

import java.io.Serializable;
import java.util.ArrayList;

import sinon.models.ReleaseNumber;
import sinon.models.data.LevelType.Types;

/**
 * The LevelProperty contains information specific to the level type. For a
 * Puzzle level, it contains the Maximum number of moves allowed. For a
 * Lightning level, it contains the Time allowed, in seconds. For a Release
 * level, it contains a list of the Release numbers contained by the board
 * 
 * @author Brian
 *
 */
public class LevelProperty implements Serializable {

	private static final long serialVersionUID = -166019953009468288L;
	Integer maxTime;
	Integer maxMoves;
	ArrayList<ReleaseNumberData> releaseSet;

	/**
	 * LevelProperty for a Puzzle or Lightning level.
	 * 
	 * Throws an IllegalArgumentException if used for a ReleaseLevel
	 * 
	 * @param levelProperty
	 *            The Maximum moves, or the maximum time, for Puzzle and
	 *            Lightning levels respectively
	 * @param t
	 *            The level type.
	 */
	public LevelProperty(int levelProperty, Types t) {

		if (t == Types.PUZZLE) {
			this.maxMoves = levelProperty;
		} else if (t == Types.LIGHTNING) {
			this.maxTime = levelProperty;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * LevelProperty for a Release Level
	 * 
	 * Throws an IllegalArgumentException if used with a Puzzle or Lightning
	 * level
	 * 
	 * @param levelProperty
	 *            the Array of ReleaseNumbers for the level
	 * @param t
	 *            The type of level
	 */
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

	/**
	 * @return The maximum moves allowed, in a Puzzle level
	 * 
	 *         Throws an IllegalArgumentException if the LevelProperty is not
	 *         associated with a Puzzle level
	 */
	public int getMaxMoves() {
		if (this.maxMoves != null) {
			return this.maxMoves;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 
	 * @return The maximum time allowed, in a Lightning level
	 * 
	 *         Throws an IllegalArgumentException if the LevelProperty is not
	 *         associated with a Lightning Level
	 */
	public int getMaxTime() {
		if (this.maxTime != null) {
			return this.maxTime;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @return The List of ReleaseNumbers, in a Release Level
	 * 
	 *         Throws an IllegalArgumentException if the LevelProperty is not
	 *         associated with a Release level
	 */
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
