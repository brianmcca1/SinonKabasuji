package sinon.models;

import java.util.Optional;

import sinon.models.data.LevelData;
import sinon.models.data.LevelType.types;

public class Level {
	int levelNum;
	public Board board;
	BullPen bullpen;
	LevelData levelData;
	public Optional<Hexomino> selectedHexomino;
	
	public Level(int levelNum, Board b, BullPen bp){
		this.levelNum = levelNum;
		this.board = b;
		this.bullpen = bp;
		selectedHexomino = Optional.empty();
	}
	
	/**
	 * Used by the Builder's new level controllers to set the Level field regarding its type
	 * @param t Enum type of level (puzzle/lightning/release)
	 */
	public Level(types t){
		this.levelData = new LevelData(t);
	}
	
	/** 
	 * @return returns BullPen of this level
	 */
	public BullPen getBullpen() {return this.bullpen;}
	
	/**
	 * Sets the selected hexomino
	 * @param hex
	 */
	public void select(Optional<Hexomino> hex){this.selectedHexomino = hex;}
	
	/**
	 * Sets the selected hexomino to empty
	 */
	public void deselect(){this.selectedHexomino = Optional.empty();}
	
	/**
	 * @return TRUE - There is a selected hexomino
	 * 		   FALSE - There is no selected hexomino
	 */
	public boolean hasSelected(){return this.selectedHexomino.isPresent();}
	
}
