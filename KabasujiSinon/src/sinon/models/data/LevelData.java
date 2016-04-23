package sinon.models.data;

import java.io.Serializable;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.data.LevelType.types;

/**
 * This class holds all of the data necessary to save/load a level.
 */
public final class LevelData implements Serializable {

    /** Type of level */
    types levelType;
    /** Board that the level will be played on. */
    BoardData boardData;
    /** Bullpen holding all the level hexominoes. */
    BullPenData bullpenData;
    /** This level's number (1 to 15). */
    int levelNum;

    public LevelData(types puzzle, BoardData bData, BullPenData bpData, int num){
    	this.levelType = puzzle;
    	this.boardData = bData;
    	this.bullpenData = bpData;
    	this.levelNum = num;
    }
    
    public LevelData(types type){
    	this.levelType = type;
    }
    
    /**
     * Builds an empty board which is ready for game play based on the data
     * stored in this object.
     * 
     * @return a Board for game play.
     */
    public Board getBoard() {
        return new Board(boardData);
    }

    /**
     * Builds a BullPen which is ready for game play based on the data stored in
     * this object.
     * 
     * @return a Bullpen for game play.
     */
    public BullPen getBullpen() {
        return new BullPen(bullpenData);
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
    public types getLevelType() {
        return this.levelType;
    }

}
