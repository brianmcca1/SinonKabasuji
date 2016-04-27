package sinon.models;

import sinon.models.data.LevelType.types;

public class PuzzleLevel extends Level {
    /** The maximum number of moves allowed */
    int maxMoves;

    /** The number of moves made so far */
    int moves;

    public PuzzleLevel(Board b, BullPen bp, int maxMoves) {
        super(types.PUZZLE, b, bp);
        this.maxMoves = maxMoves;
        this.moves = 0;
    }

    public PuzzleLevel(Level level) {
        super(types.PUZZLE, level.getBoard(), level.getBullpen());
        this.maxMoves = level.getLevelData().getLevelProperty()
                .getPropertyValue();
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

    public int countStars() {
    	int numNotPlayed = 0;
		for (Tile t : this.board.getTiles()){
			if (!t.hasHex()){
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
