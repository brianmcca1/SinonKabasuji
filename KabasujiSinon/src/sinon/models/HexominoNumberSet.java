package sinon.models;

import java.awt.Point;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A HexominoNumberSet represents the six coordinate pairs that make up any
 * Hexomino.
 * 
 * @author Josh Desmond
 * @author Brian McCarthy
 */
public class HexominoNumberSet {

	private static final int SIZE = 6;
	/** List of six points representing a Hexomino. */
	List<Point> points;
	/**
	 * Comparator used to sort the points.
	 * 
	 * The order of points is based on first the x coordinate, then the y
	 * coordinate.
	 */
	private static final Comparator<Point> COMP = new Comparator<Point>() {

		@Override
		public int compare(Point p1, Point p2) {
			if (p1.x != p2.x) {
				return p1.x - p2.x;
			}

			assert p1.x == p2.x;
			return p1.y - p2.y;
		}
	};

	/**
	 * Main Constructor for creating a HexominoNumberSet.
	 * 
	 * @param points
	 *            Set of six points which specifies the shape and position of a
	 *            Hexomino. The set must contain exactly six elements, and one
	 *            element must be (0,0).
	 */
	protected HexominoNumberSet(List<Point> points) {
		points.sort(COMP);

		if (!validatePoints(points)) {
			throw new IllegalArgumentException(String.format("Illegal pointsList inputted, %s ", points));
		}

		this.points = points;
	}

	/**
	 * @return The list of points that make up the NumberSet.
	 */
	public List<Point> getPoints() {
		return this.points;
	}

	/**
	 * Flip the HexominoNumberSet horizontally.
	 * 
	 * This means the Y values of every point in the HexominoNumberSet will be
	 * negated.
	 * 
	 */
	void flipHorizontally() {
		for (Point p : points) {
			p.y = p.y * -1;
		}

		resortPoints();
	}

	/**
	 * Re-sort the points in the HexominoNumberSet.
	 */
	private void resortPoints() {
		points.sort(COMP);

	}

	/**
	 * Flip the HexominoNumberSet vertically.
	 * 
	 * This means the X values of every point in the HexominoNumberSet will be
	 * negated.
	 */
	void flipVertically() {
		for (Point p : points) {
			p.x = p.x * -1;
		}

		resortPoints();
	}

	/**
	 * Rotate the HexominoNumberSet clockwise.
	 */
	void rotateC() {
		for (Point p : points) {
			// [0 1] - Rotation matrix is:
			// [-1 0]
			p.setLocation(p.y, -1 * p.x);
		}
		resortPoints();
	}

	/**
	 * Rotate the HexominoNumberSet CounterClockwise.
	 * 
	 * This is equivalent to 3 clockwise rotations.
	 */
	void rotateCC() {
		rotateC();
		rotateC();
		rotateC();
		resortPoints();
	}

	/**
	 * Returns an unmodifiable translated set of points.
	 * 
	 * This means that that every point is positive, and within the bounds of a
	 * 6x6 grid. Points are in the order specified by Point. The unmodifiable
	 * list means that any attempt to alter the list will throw an error.
	 * 
	 * @return Returns a set of points that describes the Hexomino.
	 */
	public List<Point> getNormalizedPoints() {
		resortPoints();
		int mostNegativeX = 0, mostNegativeY = 0, mostPositiveX = Integer.MIN_VALUE, mostPositiveY = Integer.MIN_VALUE;

		List<Point> copy = this.points;

		for (Point p : copy) {
			if (p.x < mostNegativeX) {
				mostNegativeX = p.x;
			} else if (p.x > mostPositiveX) {
				mostPositiveX = p.x;
			}

			if (p.y < mostNegativeY) {
				mostNegativeY = p.y;
			} else if (p.y > mostPositiveY) {
				mostPositiveY = p.y;
			}
		}

		int addX = -mostNegativeX, addY = -mostNegativeY;
		if (mostPositiveX > 5) {
			addX = 5 - mostPositiveX;
		}
		if (mostPositiveY > 5) {
			addY = 5 - mostNegativeY;
		}

		List<Point> returnList = new LinkedList<Point>();

		for (Point p : copy) {
			returnList.add(new Point(p.x + addX, p.y + addY));
		}

		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		return result;
	}

	/**
	 * Two HexominoNumberSets are equal if they both describe the same Hexomino
	 * with the same orientation. The relative position of the coordinates,
	 * however, does not matter.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HexominoNumberSet other = (HexominoNumberSet) obj;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (points.equals(other.points)) {
			return true;
		} else if (other.getNormalizedPoints().equals(this.getNormalizedPoints())) {
			return true;
		}
		return false;
	}

	/**
	 * Validates the state of any set of points. Points are legal if they are
	 * all connected, if they contain (0,0), and have six unique points.
	 * 
	 * @return True if the set of points given is in a legal state for a
	 *         HexominoNumberSet.
	 */
	static boolean validatePoints(List<? extends Point> list) {
		if (list == null) {
			return false;
		} else if (list.size() != SIZE) {
			return false;
		} else if (!validateConnected(list)) {
			return false;
			// } else if (!list.contains(new Point(0, 0))) {
			// return false;
		} else if (!validateUniquePoints(list)) {
			return false;
		}
		return true;
	}

	/**
	 * Validates that the list of points has no duplicates.
	 * 
	 * @param list
	 *            List of points to test.
	 * @return True if the list has no duplicates.
	 */
	private static boolean validateUniquePoints(List<? extends Point> list) {
		assert list != null;

		for (Point p : list) {
			if (Collections.frequency(list, p) != 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Determines if a set of points is connected.
	 * 
	 * @param list
	 *            The set of points to test.
	 * @return True if the points are connected.
	 */
	private static boolean validateConnected(List<? extends Point> list) {
		assert list != null;

		// For each point, check that at least one of the four points around it
		// are also in the list.
		for (Point p : list) {
			Point[] surroundingPoints = new Point[4];
			surroundingPoints[0] = new Point(p.x + 1, p.y);
			surroundingPoints[1] = new Point(p.x - 1, p.y);
			surroundingPoints[2] = new Point(p.x, p.y + 1);
			surroundingPoints[3] = new Point(p.x, p.y - 1);

			boolean hasFoundNeighbor = false;
			for (Point neighbor : surroundingPoints) {
				if (list.contains(neighbor)) {
					hasFoundNeighbor = true;
					break;
				}
			}

			if (hasFoundNeighbor == false) {
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{");
		for (Point p : this.points) {
			str.append(String.format(", (%s, %s)", p.x, p.y));
		}
		str.deleteCharAt(1);
		str.deleteCharAt(2); // remove extra space at beginning
		str.append("}");

		return str.toString();
	}

	/**
	 * Sorts the given list of points using this class's Point Comparator.
	 * 
	 * @param pointsToSort
	 *            List of points to be sorted.
	 */
	public static void sortPoints(List<Point> pointsToSort) {
		Objects.requireNonNull(pointsToSort).sort(COMP);
	}
}
