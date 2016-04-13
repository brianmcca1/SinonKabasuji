package sinon.models;

import java.awt.Point;
import java.util.ArrayList;

public abstract class AbsPiece {
	Point[] otherSquares = new Point[6];
	int anchorRow;
	int anchorColumn;
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public AbsPiece(Point[] otherSquares, int anchorRow, int anchorColumn){
		this.otherSquares = otherSquares;
		this.anchorRow = anchorRow;
		this.anchorColumn = anchorColumn;
	}
	
	public abstract void addToTile(Tile t);
}
