package sinon.models;

import java.awt.Point;
import java.util.Arrays;

public abstract class AbsPiece {

	Point[] squares = new Point[6];

	public AbsPiece(Point[] otherSquares) {
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
		AbsPiece other = (AbsPiece) obj;
		if (!Arrays.equals(squares, other.squares))
			return false;
		return true;
	}

	abstract void addToTile(Tile t);
}
