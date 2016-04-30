package sinon.models;

import sinon.models.data.LevelType.Types;

/**
 * This is the class that extends the Level class that 
 * encapsulates the attributes and behaviors that are exclusive
 * to the puzzle level.
 *
 */
public class PuzzleLevel extends Level {
	/** The maximum number of moves allowed */
	int maxMoves;

	/** The number of moves made so far */
	int moves;

	public PuzzleLevel(Board b, BullPen bp, int maxMoves) {
		super(Types.PUZZLE, b, bp);
		this.maxMoves = maxMoves;
		this.moves = 0;
	}

	public PuzzleLevel(Level level) {
		super(Types.PUZZLE, level.getBoard(), level.getBullpen());
		this.maxMoves = level.getLevelData().getLevelProperty().getMaxMoves();
		this.levelData = level.levelData;
	}

	/**
	 * Increments the moves made so far
	 * 
	 * @return True if the move limit has not been met, False otherwise
	 */
	public boolean incrementMoves() {
		moves++;
		this.update();
		return (moves < maxMoves);
	}

	/**
	 * Get the moves made so far
	 * 
	 * @return the number of moves made so far
	 */
	public int getMovesLeft() {
		return (this.maxMoves - this.moves);
	}

	/**
	 * Get the maximum number of moves
	 * 
	 * @return the maximum number of moves
	 */
	public int getMaxMoves() {
		return this.maxMoves;
	}

	public boolean incrementMovesMade() {
		if (this.moves < this.maxMoves) {
			this.moves++;
			return true;
		}
		this.update();
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
