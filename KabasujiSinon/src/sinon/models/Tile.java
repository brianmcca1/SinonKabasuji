package sinon.models;

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
		this.hex = null;
	}
	
	void setHexomino(Hexomino hex){
		this.hex = hex;		
	}
	
	public Hexomino getHexomino(){
		return this.hex;
	}
	void removeHex(){
		this.hex = null;
	}
	
	void setPlayable(boolean bool){
		this.playable = bool;
	}
	
	public boolean hasHex(){
		if (this.hex.equals(null)){
			return false;
		}
		else return true;
	}
	
}
