package sinon.models;

public class Level {
	int levelNum;
	public Board board;
	BullPen bullpen;
	LevelData levelData;
	
	public Level(int levelNum, Board b, BullPen bp){
		this.levelNum = levelNum;
		this.board = b;
		this.bullpen = bp;
	}
	
	public void open(){
		
	}
	
	
}
