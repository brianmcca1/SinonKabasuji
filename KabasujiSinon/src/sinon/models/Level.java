package sinon.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import sinon.models.data.LevelData;
import sinon.models.data.LevelType.Types;
import sinon.views.Observer;

public class Level implements Observable {

	/** Board model for this level. */
	Board board;
	/** Bullpen model for this level. */
	BullPen bullpen;
	/** The stars currently unlocked on this level, out of 3 */
	int stars;
	/** The highest amount of stars unlocked on this level, out of 3 */
	int starRecord;
	/**
	 * This is used for Serializing and Deserializing data relevant to the
	 * Level. @see LevelData
	 */
	LevelData levelData;

	/** The Hexomino model that is currently selected. */
	Optional<Hexomino> selectedHexomino;
	/** Observers of the level */
	List<Observer> observers;

	public Level(Types type, Board board, BullPen bullpen) {
		this.board = Objects.requireNonNull(board);
		this.bullpen = Objects.requireNonNull(bullpen);
		Objects.requireNonNull(type);
		this.levelData = new LevelData(type);
		this.starRecord = 0;
		observers = new LinkedList<Observer>();
		selectedHexomino = Optional.empty();
	}

	public Level(LevelData levelData) {
		this.board = new Board(levelData.getBoardData());
		this.bullpen = new BullPen(levelData.getBullpenData());
		this.starRecord = levelData.getStarRecord();
		this.levelData = levelData;
		observers = new LinkedList<Observer>();
		selectedHexomino = Optional.empty();
	}

	/** @return BullPen model of this level. */
	public BullPen getBullpen() {
		return this.bullpen;
	}

	/** @return Board model of this level. */
	public Board getBoard() {
		return board;
	}

	/** @return this level's LevelData. */
	public LevelData getLevelData() {
		return this.levelData;
	}

	// TODO why would this ever need to be called?
	// remove this if possible imo.
	public void setLevelData(LevelData l) {
		this.levelData = l;
	}

	public void setStars(int s) {
		this.stars = s;
	}

	public int getStarRecord() {
		return this.starRecord;
	}

	public void setStarRecord(int s) {
		this.starRecord = s;
	}

	/**
	 * Sets the selected hexomino
	 * 
	 * @param hex
	 *            The Hexomino model to select.
	 */
	public void select(Hexomino hex) {
		this.selectedHexomino = Optional.of(hex);
	}

	/** Sets the selected hexomino to empty. */
	public void deselect() {
		this.selectedHexomino = Optional.empty();
	}

	/**
	 * Determines if there is a selected hexomino.
	 * 
	 * @return True if there is currently a hexomino selected.
	 */
	public boolean hasSelected() {
		return this.selectedHexomino.isPresent();
	}

	/**
	 * Determines whether this level is completed.
	 * 
	 * @return Returns true if the level has been won (Three stars have been
	 *         attained), otherwise returns false
	 * @author PDeBrine
	 */

	public boolean hasWon() {
		if (this.countStars() == 3) {
			return true;
		}
		return false;
	}

	/**
	 * Counts the number of stars earned for this level
	 * 
	 * @return Returns the number of stars earned, the max being 3, and the min
	 *         being 0
	 * @author PDeBrine
	 */
	public int countStars() {
		return 0;
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);

	}

	@Override
	public void update() {
		for (Observer o : observers) {
			o.updated();
		}
	}

	/**
	 * Gets the selected hexomino.
	 * 
	 * @return The optional with either the selected hexomino if there is one,
	 *         or null.
	 */
	public Optional<Hexomino> getSelectedHexomino() {
		return this.selectedHexomino;
	}

}
