package sinon.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
	@Override
	public String toString() {
		return "Board [tiles=" + tiles + ", hints=" + hints + "]";
	}

	//Tile[] tiles = new Tile[144];
	List<Tile> tiles;
	ArrayList<Hint> hints; 
	
	public Board(List<Tile> tiles){
		this.tiles = tiles;
		//this.hints = hints;
		
	}
	public void addPiece(AbsPiece piece, int anchorRow, int anchorColumn){
		
		for(int i = 0; i < 6; i++){
			int deltaX = piece.squares[i].x;
			int deltaY = piece.squares[i].y;
			
			int row = anchorRow + deltaX;
			int column = anchorColumn + deltaY;
			
			Tile t = this.getTile(row,  column);
			if(t.playable == true){
				piece.addToTile(t);
			} else {
				System.err.println("Piece is not playable at that location");
			}
			
			
		}
	} 
	
	public void removeHexomino(Hexomino hex){
		
		for(Tile t: tiles){
			if(t.getHexomino().isPresent()){
				if(t.getHexomino().get() == hex){
					t.removeHex();
				}
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
	
}
