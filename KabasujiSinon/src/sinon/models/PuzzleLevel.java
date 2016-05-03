package sinon.models;

import sinon.models.data.LevelType.Types;

/**
 * This is the class that extends the Level class that encapsulates the
 * attributes and behaviors that are exclusive to the puzzle level.
 *
 */
public class PuzzleLevel extends Level {
	/** The maximum number of moves allowed. */
	int maxMoves;

	/** The number of moves made so far. */
	int moves;

	/**
	 * Creates a PuzzleLevel with the given board, bullpen, and max moves
	 * allowed.
	 * 
	 * @param b
	 *            The level's board.
	 * @param bp
	 *            The bullpen's board.
	 * @param maxMoves
	 *            The maximum moves allowed.
	 */
	public PuzzleLevel(Board b, BullPen bp, int maxMoves) {
		super(Types.PUZZLE, b, bp);
		this.maxMoves = maxMoves;
		this.moves = 0;
	}

	/**
	 * Creates a PuzzleLevel based off a generic level.
	 * 
	 * @param level
	 *            The generic level the PuzzleLevel is based off of.
	 */
	public PuzzleLevel(Level level) {
		super(Types.PUZZLE, level.getBoard(), level.getBullpen());
		this.maxMoves = level.getLevelData().getLevelProperty().getMaxMoves();
		this.levelData = level.levelData;
	}

	/**
	 * Increments the moves made so far.
	 * 
	 * @return True if the move limit has not been met, False otherwise.
	 */
	@Override
	public boolean incrementMoves() {
		moves++;
		this.update();
		return (moves < maxMoves);
	}

	/**
	 * Get the moves made so far.
	 * 
	 * @return the number of moves made so far.
	 */
	public int getMovesLeft() {
		int movesLeft = (this.maxMoves - this.moves);
		if (movesLeft < 0) {
			throw new IllegalStateException("There should never be a negative number of moves left");
		}
		return movesLeft;
	}

	/**
	 * Get the maximum number of moves.
	 * 
	 * @return the maximum number of moves.
	 */
	public int getMaxMoves() {
		return this.maxMoves;
	}

	/**
	 * Increment the moves made in the puzzle level.
	 * 
	 * @return True if the increment was valid, false otherwise.
	 */
	public boolean incrementMovesMade() {
		if (this.moves < this.maxMoves) {
			this.moves++;
			return true;
		}
		this.update();
		return false;
	}

	@Override
	public boolean hasLost() {
		// A puzzle left is over if there are no more levels.
		if (this.getMovesLeft() <= 0) {
			return true;
		}

		return false;
	}

	@Override
	public int countStars() {
		int numNotPlayed = 0;
		for (Tile t : this.board.getTiles()) {
			if (!t.hasHex() & t.isPlayable()) {
				numNotPlayed++;
			}
		}

		int hexSpacesLeft = numNotPlayed / 6;

		int stars = 3 - hexSpacesLeft;
		if (stars < 0)
			stars = 0;

		return stars;

	}

}
