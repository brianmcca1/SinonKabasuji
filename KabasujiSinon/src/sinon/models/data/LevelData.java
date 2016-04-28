package sinon.models.data;

import java.io.Serializable;

import sinon.models.data.LevelType.Types;

/**
 * Information needed to save/load a level to disk.
 * 
 * It contains: the level number, the level type, data regarding playable tiles
 * for the board, and data regarding the hexominos that should be in the
 * bullpen.
 */
public final class LevelData implements Serializable {

	private static final long serialVersionUID = -7014637350059511767L;
	/** Type of level (PUZZLE/LIGHTNING/RELEASE) */
	Types levelType;
	/** BoardData has the 2-D array of booleans for the playable tiles. */
	BoardData boardData;
	/**
	 * BullpenData has the list of hexominos that are in the bullpen for this
	 * level.
	 */
	BullPenData bullpenData;
	/** Highest number of stars reached on this level */
	int starRecord;
	/** Holds the info regarding number of moves/time/locations of number tiles. */
	LevelProperty levelProperty;

	public LevelData(Types t, BoardData bData, BullPenData bpData,
			int starRecord) {
		this.levelType = t;
		this.boardData = bData;
		this.bullpenData = bpData;
		this.starRecord = starRecord;
	}

	/** Used when creating a new Level to set this level type. */
	public LevelData(Types type) {
		this.levelType = type;
		this.starRecord = 0;
	}

	/**
	 * @return an empty board which is ready for game play based on the data
	 *         stored in this object.
	 */
	public BoardData getBoardData() {
		return this.boardData;
	}

	/**
	 * @return a BullPen which is ready for game play based on the data stored
	 *         in this object.
	 */
	public BullPenData getBullpenData() {
		return this.bullpenData;
	}

	/** @return This level's star record. */
	public int getStarRecord() {
		return this.starRecord;
	}

	/** @return The type of level. */
	public Types getLevelType() {
		return this.levelType;
	}

	/**
	 * Sets the BullPenData field.
	 * 
	 * @param bpData
	 *            The BullPenData to set.
	 */
	public void setBullpenData(BullPenData bpData) {
		this.bullpenData = bpData;
	}

	/**
	 * Sets the BoardData field.
	 * 
	 * @param bData
	 *            The BoardData to set.
	 */
	public void setBoardData(BoardData bData) {
		this.boardData = bData;
	}

	/** @return This level's LevelProperty. */
	public LevelProperty getLevelProperty() {
		return this.levelProperty;
	}

	/**
	 * Sets this level's LevelProperty.
	 * 
	 * @param l
	 *            LevelProperty to set.
	 */
	public void setLevelProperty(LevelProperty l) {
		this.levelProperty = l;
	}

	@Override
	public String toString() {
		String strLevelData = "";

		strLevelData += this.boardData.toString();
		strLevelData += this.bullpenData.toString();
		strLevelData += "\r\n";
		strLevelData += ("LEVEL TYPE: " + this.levelType);
		strLevelData += "\r\n";
		strLevelData += ("LEVEL PROPERTY: ")
				+ this.levelProperty.getPropertyValue();
		strLevelData += "\r\n";
		strLevelData += ("STAR RECORD: ") + this.starRecord;

		return strLevelData;
	}

}
