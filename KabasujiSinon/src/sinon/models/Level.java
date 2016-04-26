package sinon.models;

import java.util.Optional;

import sinon.models.data.LevelData;
import sinon.models.data.LevelType.types;

public class Level {
	
    /** Board model for this level. */
    Board board;
    /** Bullpen model for this level. */
    BullPen bullpen;
    /** The stars currently unlocked on this level, out of 3 */
    int stars;
    /** The highest amount of stars unlocked on this level, out of 3 */
    int starRecord;
    /** This is used for Serializing and Deserializing data relevant to the Level. 
     *  Contains: 
     *  	this level number.
     *  	this level type.
     *  	data regarding playable tiles for the board.
     *  	data regarding the hexominos that should be in the bullpen.
     */
    LevelData levelData;
    /** The Hexomino model that is currently selected. */
    public Optional<Hexomino> selectedHexomino;

    
    public Level(types t, Board b, BullPen bp) {
        this.board = b;
        this.bullpen = bp;
        this.levelData = new LevelData(t);
        this.starRecord = 0;
    }
    
    public Level(LevelData levelData){
    	this.board = new Board(levelData.getBoardData());
    	this.bullpen = new BullPen(levelData.getBullpenData());
    	this.starRecord = levelData.getStarRecord();
    	this.levelData = levelData;
    	
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
    public LevelData getLevelData(){
    	return this.levelData;
    }

    public int getStars(){
    	return this.stars;
    }    
    
    public void setStars(int s){
    	this.stars = s;
    }
    
    public int getStarRecord(){
    	return this.starRecord;
    }
    
    public void setStarRecord(int s){
    	this.starRecord = s;
    }
    
    /**
     * Sets the selected hexomino
     * @param hex The Hexomino model to select.
     */
    public void select(Hexomino hex) {
        this.selectedHexomino = Optional.of(hex);
    }

    /** Sets the selected hexomino to empty. */
    public void deselect() {
        this.selectedHexomino = null;
    }

    /** @return if there is currently a hexomino selected. */
    public boolean hasSelected() {
        return this.selectedHexomino != null;
    }

    /**
     * Determines whether this level has been won
     * @return Returns true if the level has been won (Three stars have been attained), otherwise returns false
     * @author PDeBrine
     */
    
    public boolean hasWon(){
    	if (this.countStars() == 3){
    	return true;
    }
    	return false;
    }
    
    /**
     * Counts the number of stars earned for this level
     * @return Returns the number of stars earned, the max being 3, and the min being 0
     * @author PDeBrine
     */
    
    public int countStars(){
    	return 0;
    }

}
