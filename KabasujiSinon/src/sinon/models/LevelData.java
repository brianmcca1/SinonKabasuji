package sinon.models;

import java.io.Serializable;

/** This class holds all of the data necessary to save/load a level. */
public class LevelData implements Serializable{
	/** Board that the level will be played on.*/
    Board board;
    /** Bullpen holding all the level hexominoes.*/
    BullPen bullpen;
    /** This level's number (1 to 15).*/
    int levelNum;
    /** "puzzle", "lightning", or "release" level types.*/
    String levelType;

    public Board getBoard(){ return this.board;}
    
    public BullPen getBullpen(){ return this.bullpen;}
    
    public int getLevelNum(){ return this.levelNum;}
 
    public String getLevelType(){ return this.levelType;}
    
}
