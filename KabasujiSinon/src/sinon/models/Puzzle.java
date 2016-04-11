package sinon.models;

public class Puzzle extends Level{
	int maxMoves;
	int usedMoves;
	public Puzzle(int levelNum, Board b, BullPen bp, int maxMoves, int usedMoves){
		super(levelNum, b, bp);
		this.maxMoves = maxMoves;
		this.usedMoves = usedMoves;
	}
}
