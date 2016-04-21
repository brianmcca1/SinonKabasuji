package sinon.models;

import java.io.Serializable;

import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;

/**
 * This class holds all of the data necessary to save/load a level.
 */
public class LevelData implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3147645287701832176L;

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
        return null;
    }

    /**
     * Builds a BullPen which is ready for game play based on the data stored in
     * this object.
     * 
     * @return a Bullpen for game play.
     */
    public BullPen getBullpen() {
        return null;
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
