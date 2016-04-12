package sinon.models;
@Deprecated
public class Tile {
	int row;
	int column;
	boolean playable;
	Hexomino hex;
	NumberSet numberSet;
	//Shadow shadow;
	//Hint hint;
	
	public Tile(int row, int column, boolean playable){
		this.row = row;
		this.column = column;
		this.playable = playable;
	}
	
	
}
