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
    	
       this.hexominoNumberSet = new HexominoNumberSet(a, a1, b, b1, c, c1, d, d1,
            e, e1, f, f1);
       
    }

    /**
     * TODO
     * 
     * @param hexominoNumberSet
     */
    public Hexomino(HexominoNumberSet hexominoNumberSet) {
        this.hexominoNumberSet = hexominoNumberSet;
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
