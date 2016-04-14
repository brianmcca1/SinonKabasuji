package sinon.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Optional;

public abstract class AbsPiece {
	Point[] squares = new Point[6];
	Optional<Integer> anchorRow;
	Optional<Integer> anchorColumn;
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public AbsPiece(Point[] otherSquares){
		this.squares = otherSquares;
	
	}
	
	abstract void addToTile(Tile t);
}
