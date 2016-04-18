package sinon.models;

import java.awt.Point;
import java.util.Arrays;

public class Hexomino extends AbsPiece {

	/**
	 * Is a convenience constructor for quickly building a Hexomino.
	 * 
	 * @param a
	 *            The x component of the first coordinate point
	 * @param a1
	 *            the y component of the first coordinate point
	 * @return Hexomino with the given points from the given coordinate.
	 */
	public static Hexomino buildHexomino(int a, int a1, int b, int b1, int c,
			int c1, int d, int d1, int e, int e1, int f, int f1) {
		Point[] points = new Point[6];
		points[0] = new Point(a, a1);
		points[1] = new Point(b, b1);
		points[2] = new Point(c, c1);
		points[3] = new Point(d, d1);
		points[4] = new Point(e, e1);
		points[5] = new Point(f, f1);
		return new Hexomino(points);
	}

	public Hexomino(Point[] squares) {
		super(squares);
	}

	@Override
	void addToTile(Tile t) {
		t.addHexomino(this);
	}

	// Flip the hexomino over the Y axis
	public void flipHorizontally() {
		for (int i = 0; i < 6; i++) {
			int temp = squares[i].x;
			temp = temp * (-1);
			squares[i].x = temp;
		}
	}

	// Flip the hexomino over the X axis
	public void flipVertically() {
		for (int i = 0; i < 6; i++) {
			int temp = squares[i].y;
			temp = temp * (-1);
			squares[i].y = temp;
		}
	}

	// Rotate this hexomino 90 degrees clockwise
	public void rotateC() {
		for (int i = 0; i < 6; i++) {
			int x = squares[i].x;
			int y = squares[i].y;
			int newX;
			int newY;

			// Perform rotation, Matrix is
			// [0 1]
			// [-1 0]
			newX = y;
			newY = -x;

			// set new location
			squares[i].move(newX, newY);

		}
	}

	// Rotate this hexomino 90 degrees counter-clockwise
	public void rotateCC() {
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

	@Override
	public String toString() {
		return "Hexonimo [otherSquares=" + Arrays.toString(squares);
	}

}
