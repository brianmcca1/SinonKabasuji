package sinon.models;

import java.awt.Point;

public class Hexomino {

    HexominoNumberSet hexominoNumberSet;
    Point[] squares = new Point[6];
    public int anchorRow;
    public int anchorColumn;

    /**
     * Is a convenience constructor for quickly building a Hexomino.
     * 
     * @param a
     *            The x component of the first coordinate point
     * @param a1
     *            the y component of the first coordinate point
     */
    public Hexomino(int a, int a1, int b, int b1, int c, int c1, int d, int d1,
            int e, int e1, int f, int f1) {
        Point[] squares = new Point[6];
        squares[0] = new Point(a, a1);
        squares[1] = new Point(b, b1);
        squares[2] = new Point(c, c1);
        squares[3] = new Point(d, d1);
        squares[4] = new Point(e, e1);
        squares[5] = new Point(f, f1);
    }

    public Hexomino(Point[] otherSquares) {
        // TODO
        this.squares = otherSquares;
    }

    protected void addToTile(Tile t) {
        t.addHexomino(this);
    }

    public void flipHorizontally() {
        hexominoNumberSet.flipHorizontally();

    }

    public void flipVertically() {
        hexominoNumberSet.flipVertically();

    }

    public void rotateC() {
        hexominoNumberSet.rotateC();

    }

    public void rotateCC() {
        hexominoNumberSet.rotateCC();
        for (int i = 0; i < 6; i++) {
            int x = squares[i].x;
            int y = squares[i].y;
            int newX;
            int newY;

            // Perform rotation, Matrix is
            // [0 -1]
            // [1 0]
            newX = -y;
            newY = x;

            squares[i].move(newX, newY);
        }

    }
}
