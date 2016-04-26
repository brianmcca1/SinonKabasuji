package sinon.models;

import sinon.models.data.LevelType.types;

public class PuzzleLevel extends Level{
	/** The maximum number of moves allowed */
	int maxMoves;
	
	/** The number of moves made so far */
	int moves;
	
	public PuzzleLevel(int levelNum, Board b, BullPen bp, int maxMoves) {
		super(levelNum, types.PUZZLE, b, bp);
		this.maxMoves = maxMoves;
		this.moves = 0;
	}
	
	/**
	 * Increments the moves made so far
	 * @return True if the move limit has not been met, False otherwise
	 */
	public boolean incrementMoves(){
		moves++;
		return(moves < maxMoves);
	}
	/**
	 * Get the moves made so far
	 * @return the number of moves made so far
	 */
	public int getMoves(){
		return this.moves;
	}
	/**
	 * Get the maximum number of moves
	 * @return the maximum number of moves
	 */
	public int getMaxMoves(){
		return this.maxMoves;
	}

}