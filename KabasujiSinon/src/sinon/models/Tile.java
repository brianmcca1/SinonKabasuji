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
	
	public void addHexomino(Hexomino hex){
		if(!this.hasHex()){
			this.setHexomino(hex);
		} else {
			System.err.println("Error: Tile already contains Hexomino");
		}
	}
	
	//public void addHint(Hint hint){
		
	//}
	
	//public void addShadow(Shadow shadow){
		
	//}
	public void setHexomino(Hexomino hex){
		this.hex = hex;		
	}
	
	public Hexomino getHexomino(){
		return this.hex;
	}
	
	public void removeHex(){
		if(this.hasHex() == true){
			this.hex = null;
		} else {
			System.err.println("Tile does not have a Hexomino");
		}
		
	}
	
	public void setPlayable(boolean bool){
		this.playable = bool;
	}
	
	public boolean hasHex(){
		if (this.hex == null){
			return false;
		}
		else return true;
	}
	
}
