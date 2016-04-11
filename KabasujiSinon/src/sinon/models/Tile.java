package sinon.models;

public class Tile {
	int row;
	int column;
	boolean playable;
	Hexonimo hex;
	NumberSet numberSet;
	Shadow shadow;
	Hint hint;
	
	public Tile(int row, int column, boolean playable){
		this.row = row;
		this.column = column;
		this.playable = playable;
	}
	
	
}
