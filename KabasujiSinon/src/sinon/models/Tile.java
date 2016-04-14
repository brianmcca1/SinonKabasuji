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
	Hint hint;
	Shadow shadow;
	NumberSet numberSet;
	//Shadow shadow;
	//Hint hint;
	
	public Tile(int row, int column, boolean playable){
		this.row = row;
		this.column = column;
		this.playable = playable;
		this.hex = null;
		this.hint = null;
		this.shadow = null;
	}
	
	public void addHexomino(Hexomino hex){
		if(!this.hasHex()){
			this.hex = hex;
		} else {
			System.err.println("Error: Tile already contains Hexomino");
		}
	}
	
	public void addHint(Hint hint){
		if(!this.hasHint()){
			this.hint = hint;
		} else {
			System.err.println("Error: Tile already contains Hint");
		}
	}
	
	public void addShadow(Shadow shadow){
		if(!this.hasShadow()){
			this.shadow = shadow;
		} else {
			System.err.println("Error: Tile already contains Hint");
		}
	}

	public Hexomino getHexomino(){
		return this.hex;
	}
	
	public Hint getHint(){
		return this.hint;
	}
	
	public Shadow getShadow(){
		return this.shadow;
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
	
	public boolean hasHint(){
		if (this.hint == null){
			return false;
		}
		else return true;
	}
	
	public boolean hasShadow(){
		if (this.shadow == null){
			return false;
		}
		else return true;
	}
	
	
}
