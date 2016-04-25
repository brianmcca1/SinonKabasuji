package sinon.models;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import sinon.models.data.HexominoCode;

/**
 * Instantiates HexominoNumberSets.
 * 
 * 
 * All versions of the constructor eventually point to {@link #getByList(List)}.
 * For validation, this class relies on
 * {@link HexominoNumberSet#validatePoints(List)}. This should be the only class
 * creating HexominoNumberSets.
 * 
 * 
 * @author Josh Desmond
 */
public class NumberSetFactory {

	/**
	 * Creates a HexominoNumberSet with the given points
	 * 
	 * @param a
	 *            Point1.x
	 * @param a1
	 *            Point1.y
	 * @param b
	 *            Point2.x
	 * @param b1
	 *            Point2.y
	 * @return New HexominoNumberSet
	 */
	public static HexominoNumberSet getByNumbers(int a, int a1, int b, int b1,
			int c, int c1, int d, int d1, int e, int e1, int f, int f1) {
		List<Point> points = new LinkedList<Point>();
		points.add(new Point(a, a1));
		points.add(new Point(b, b1));
		points.add(new Point(c, c1));
		points.add(new Point(d, d1));
		points.add(new Point(e, e1));
		points.add(new Point(f, f1));

		return getByList(points);
	}

	/**
	 * Main Constructor for creating a HexominoNumberSet.
	 * 
	 * Be careful, as this method will use the given list for the
	 * HexominoNumberSet. This means you should never modify the list, nor the
	 * points in the list, after giving it to this constructor. Doing so may
	 * cause weird behavior.
	 * 
	 * @param points
	 *            Set of six points which specifies the shape and position of a
	 *            Hexomino. The set must contain exactly six elements, and one
	 *            element must be (0,0).
	 */
	public static HexominoNumberSet getByList(List<Point> points) {
		if (points == null)
			throw new IllegalArgumentException("Points can't be null");

		HexominoNumberSet.sortPoints(points);

		List<Point> newPoints = new LinkedList<Point>();
		for (Point p : points) {
			newPoints.add(new Point(p));
		}

		return new HexominoNumberSet(points);
	}

	/**
	 * Creates a HexominoNumberSet from a HexominoCode.
	 * 
	 * @param code
	 *            The immutable data object representing a HexominoNumberSet.
	 */
	public static HexominoNumberSet getByCode(HexominoCode code) {
		if (code == null)
			throw new IllegalArgumentException("HexominoCode can't be null");

		return getByList(code.getPoints());
	}

}
