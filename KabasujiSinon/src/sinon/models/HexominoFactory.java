package sinon.models;

import java.awt.Point;

public class HexominoFactory {

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



}
