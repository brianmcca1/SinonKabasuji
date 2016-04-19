package sinon.models;

import java.awt.Point;
import java.util.Arrays;

public abstract class AbstractHexomino {

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
	public AbstractHexomino(int a, int a1, int b, int b1, int c, int c1, int d,
			int d1, int e, int e1, int f, int f1) {
		Point[] squares = new Point[6];
		squares[0] = new Point(a, a1);
		squares[1] = new Point(b, b1);
		squares[2] = new Point(c, c1);
		squares[3] = new Point(d, d1);
		squares[4] = new Point(e, e1);
		squares[5] = new Point(f, f1);
	}

	public AbstractHexomino(Point[] otherSquares) {
		this.squares = otherSquares;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(squares);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractHexomino other = (AbstractHexomino) obj;
		if (!Arrays.equals(squares, other.squares))
			return false;
		return true;
	}

	abstract void addToTile(Tile t);
}
