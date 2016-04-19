package sinon.models;

import java.util.ArrayList;

public class Board {
	@Override
	public String toString() {
		return "Board [tiles=" + tiles + ", hints=" + hints + "]";
	}

	ArrayList<Tile> tiles;
	ArrayList<Hint> hints; 
	
	public Board(ArrayList<Tile> tiles ){
		this.tiles = tiles;
		//this.hints = hints;
		
	}
	public void addPiece(AbsPiece piece){
		
		for(int i = 0; i < 6; i++){
			int deltaX = piece.otherSquares[i].x;
			int deltaY = piece.otherSquares[i].y;
			
			int row = piece.anchorRow + deltaX;
			int column = piece.anchorColumn + deltaY;
			
			Tile t = this.getTile(row,  column);
			if(t.playable == true){
				piece.addToTile(t);
			} else {
				System.err.println("Piece is not playable at that location");
			}
			
			
		}
	} 
	
	public void removeHexomino(Hexomino hex){
		
		for(int i = 0; i < 6; i++){
			int deltaX = hex.otherSquares[i].x;
			int deltaY = hex.otherSquares[i].y;
			
			int row = hex.anchorRow + deltaX;
			int column = hex.anchorColumn + deltaY;
			
			Tile t = this.getTile(row,  column);
			if(t != null){
				t.removeHex();
			} else {
				System.err.println("No hex at this location");
			}
		}
		
	}
	
	public Tile getTile(int row, int column){
		for(Tile t: tiles){
			if((t.row == row) & (t.column == column)){
				return t;
			}
		}
		return null;
	}
	
	public boolean hasHex(int row, int column){
		boolean answer = false;
		int pos = row * 12;
		pos = column + pos;
		if (tiles.get(pos).hasHex()){
			answer = true;
		}
		return answer;
	}
	
}
