package sinon.models;

import java.util.ArrayList;
@Deprecated
public class Board {
	ArrayList<Tile> tiles;
	ArrayList<Hint> hints; 
	
	public Board(ArrayList<Tile> tiles, ArrayList<Hint> hints){
		this.tiles = tiles;
		this.hints = hints;
		
	}
}
