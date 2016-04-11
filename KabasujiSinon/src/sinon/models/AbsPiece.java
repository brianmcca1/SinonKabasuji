package sinon.models;

import java.awt.Point;

public abstract class AbsPiece {
	Point[] otherSquares = new Point[6];
	int anchorRow;
	int anchorColumn;
	
	public AbsPiece(Point[] otherSquares, int anchorRow, int anchorColumn){
		this.otherSquares = otherSquares;
		this.anchorRow = anchorRow;
		this.anchorColumn = anchorColumn;
	}
	
}
