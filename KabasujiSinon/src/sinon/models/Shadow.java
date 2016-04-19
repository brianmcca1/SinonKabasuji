package sinon.models;

import java.awt.Point;

@Deprecated
public class Shadow extends Hexomino {

	public Shadow(Point[] otherSquares) {
		super(otherSquares);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addToTile(Tile t) {

		t.addShadow(this);
	}
}
