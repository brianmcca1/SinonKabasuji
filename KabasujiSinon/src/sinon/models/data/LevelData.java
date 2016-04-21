package sinon.models.data;

import java.io.Serializable;

import sinon.models.Board;
import sinon.models.BullPen;

/**
 * This class holds all of the data necessary to save/load a level.
 */
public final class LevelData implements Serializable {

    /** Enum representing three types of level */
    enum LevelType {
        PUZZLE, LIGHTNING, RELEASE
    }

    /** Type of level */
    LevelType levelType;
    /** Board that the level will be played on. */
    BoardData board;
    /** Bullpen holding all the level hexominoes. */
    BullPenData bullpen;
    /** This level's number (1 to 15). */
    int levelNum;

    /**
     * Builds an empty board which is ready for game play based on the data
     * stored in this object.
     * 
     * @return a Board for game play.
     */
    public Board getBoard() {
        return new Board(board);
    }

    /**
     * Builds a BullPen which is ready for game play based on the data stored in
     * this object.
     * 
     * @return a Bullpen for game play.
     */
    public BullPen getBullpen() {
        return new BullPen(bullpen);
    }

    /**
     * Gets the number of this level.
     * 
     * @return Value between 1 and 15
     */
    public int getLevelNum() {
        return this.levelNum;
    }

    /**
     * Gets the enum value of the type of level.
     * 
     * @return The type of level.
     */
    public LevelType getLevelType() {
        return this.levelType;
    }

}
