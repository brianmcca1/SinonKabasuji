package sinon.models;

public class Tile {
	@Override
	public String toString() {
		return "Tile [row=" + row + ", column=" + column + ", playable=" + playable + ", hex=" + hex + ", numberSet="
				+ numberSet + "]";
	}

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
	
	public void setHexomino(Hexomino hex){
		this.hex = hex;		
	}
	
	public Hexomino getHexomino(){
		return this.hex;
	}
	public void removeHex(){
		this.hex = null;
	}
	
	public void setPlayable(boolean bool){
		this.playable = bool;
	}
	
	public boolean hasHex(){
		if (this.hex.equals(null)){
			return false;
		}
		else return true;
	}
	
}
