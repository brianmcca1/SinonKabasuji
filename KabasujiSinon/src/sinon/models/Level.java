package sinon.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;

import sinon.models.data.LevelData;
import sinon.models.data.LevelType.Types;
import sinon.moves.Move;
import sinon.views.Observer;

public class Level implements Observable {

	/** Board model for this level. */
	Board board;
	/** Bullpen model for this level. */
	BullPen bullpen;
	/** The stars currently unlocked on this level, out of 3 */
	int stars;
	/**
	 * This is used for Serializing and Deserializing data relevant to the
	 * Level. @see LevelData
	 */
	LevelData levelData;

	/** The Hexomino model that is currently selected. */
	Optional<Hexomino> selectedHexomino;
	/** Observers of the level */
	List<Observer> observers;

	/**
	 * Stack of Moves to undo
	 */
	Stack<Move> undo;

	/**
	 * Stack of Moves to redo
	 */
	Stack<Move> redo;

	public Level(Types type, Board board, BullPen bullpen) {
		this.board = Objects.requireNonNull(board);
		this.bullpen = Objects.requireNonNull(bullpen);
		Objects.requireNonNull(type);
		this.levelData = new LevelData(type);
		observers = new LinkedList<Observer>();
		selectedHexomino = Optional.empty();
		undo = new Stack<Move>();
		redo = new Stack<Move>();
	}

	public Level(LevelData levelData) {
		switch (levelData.getLevelType()) {
		case PUZZLE:
			this.board = new Board(levelData.getBoardData());
			break;
		case LIGHTNING:
			this.board = new LightningBoard(levelData.getBoardData());
			break;
		case RELEASE:
			this.board = new ReleaseBoard(levelData.getBoardData());
			break;
		}

		this.bullpen = new BullPen(levelData.getBullpenData());
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

	public void setStars(int s) {
		this.stars = s;
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
		// Only called when a move is done?
		// Otherwise we need to go to every doMove and reset redo
		// redo = new Stack<Move>();
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

	/**
	 * Pops the last move off the stack undo and undoes it, then pushes it to
	 * redo does nothing if undo is empty
	 */

	public void undo() {
		System.out.println("Hit undo");
		int sizePre = undo.size();
		if (undo.empty())
			return;
		Move move;
		move = undo.pop();
		System.out.println(undo.size() + "Pre size ->" + sizePre);
		if (move.undo()) {
			redo.push(move);
		} else
			System.out.println("Undo failed");
	}

	/**
	 * Attempts to pop the last move off the stack redo and (re)do it does
	 * nothing if redo is empty
	 */

	public void redo() {
		if (redo.empty())
			return;
		Move move;
		move = redo.pop();
		move.doMove();
		this.pushMove(move);
	}

	/**
	 * Pushes the move onto the stack undo
	 * 
	 * @param move
	 *            to be pushed
	 */

	public void pushMove(Move move) {
		undo.push(move);
		System.out.println(this.undo.size());
	}

}
