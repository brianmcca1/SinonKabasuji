package sinon.models;
@Deprecated
public class Level {
	int levelNum;
	Board b;
	BullPen bp;
	LevelData ld;
	
	public Level(int levelNum, Board b, BullPen bp){
		this.levelNum = levelNum;
		this.b = b;
		this.bp = bp;
	}
	
	public void open(){
		
	}
	
	
}