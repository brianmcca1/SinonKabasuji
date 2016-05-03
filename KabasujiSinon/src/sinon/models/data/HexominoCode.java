package sinon.models.data;

import java.awt.Point;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;

/**
 * A HexominoCode is the ArrayList of six points that represents a
 * HexominoNumberSet. To instantiate a HexominoNumberSet using a HexominoCode,
 * use a NumberSetFactory.
 * 
 * @see NumberSetFactory
 */
public final class HexominoCode implements Serializable {
	private static final long serialVersionUID = -6191095303124737939L;

	/** Array of six points representing a HexominoNumberSet */
	Point[] points;

	/**
	 * Constructs a empty hexomino code.
	 */
	public HexominoCode() {
		points = new Point[6];
	}
	
	/**
	 * Constructs a new hexomino code with the give points.
	 * @param points the points to be added.
	 */
	public HexominoCode(List<Point> points) {
		
		this.points = new Point[6];
		int i = 0;
		for(Point p : points) {
			this.points[i] = p;
			i++;
		}
		
	}

	/** Creates a HexominoCode from a given Hexomino 
	 * @param hexomino Hexomino to turn into a HexominoCode.
	 */
	public HexominoCode(Hexomino hexomino) {
		if (hexomino == null)
			throw new IllegalArgumentException("Hexomino can't be null");

		List<Point> givenPoints = hexomino.getNormalizedPoints();
		if (givenPoints.size() != 6) {
			throw new IllegalArgumentException(String.format(
					"Hexomino didn't have six points %s", hexomino.toString()));
		}

		points = new Point[6];
		int i = 0;

		for (Point p : givenPoints) {
			points[i] = p;
			i++;
		}
	}

	/**
	 * Returns the list of points representing a HexominoNumberSet
	 * 
	 * @return The list of points.
	 */
	public List<Point> getPoints() {
		return Arrays.asList(points);
	}

	@Override
	public String toString() {
		return Arrays.deepToString(points);
	}
}
