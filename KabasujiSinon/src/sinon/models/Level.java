package sinon.models;

import java.util.Optional;

public class Level {
	int levelNum;
	public Board board;
	BullPen bullpen;
	LevelData levelData;
	public Optional<Hexomino> selected;
	
	public Level(int levelNum, Board b, BullPen bp){
		this.levelNum = levelNum;
		this.board = b;
		this.bullpen = bp;
		selected = Optional.empty();
	}
	
	public void open(){
		
	}
	
	/** 
	 * This returns the bullpen from the level.
	 * @return
	 */
	public BullPen getBullpen() {
		return bullpen;
	}
	
	public void select(Optional<Hexomino> hex){
		this.selected = hex;
	}
	
	public void deselect(){
		this.selected = Optional.empty();
	}
	
	public boolean hasSelected(){
		return this.selected.isPresent();
	}
	
}
