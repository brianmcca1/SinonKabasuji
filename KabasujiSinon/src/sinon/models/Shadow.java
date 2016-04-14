package sinon.models;
import java.awt.Point;


public class Shadow extends AbsPiece{
	
	public Shadow(Point[] otherSquares, int anchorRow, int anchorColumn){
		super(otherSquares, anchorRow, anchorColumn);	
	}

	@Override
	public void addToTile(Tile t) {

		t.addShadow(this);
	}
}
