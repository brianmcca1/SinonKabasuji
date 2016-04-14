package sinon.models;

import java.awt.Point;

public class Hint extends AbsPiece {

    public Hint(Point[] otherSquares, int anchorRow, int anchorColumn) {
        super(otherSquares);
    }

    @Override
    public void addToTile(Tile t) {
        t.addHint(this);
    }
}
