package sinon.models;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import sinon.models.data.HexominoCode;

/**
 * Instantiates HexominoNumberSets.
 * 
 * 
 * All versions of the constructor eventually point to
 * {@link #getByComparableList(List)}. For validation, this class relies on
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
        List<ComparablePoint> points = new LinkedList<ComparablePoint>();
        points.add(new ComparablePoint(a, a1));
        points.add(new ComparablePoint(b, b1));
        points.add(new ComparablePoint(c, c1));
        points.add(new ComparablePoint(d, d1));
        points.add(new ComparablePoint(e, e1));
        points.add(new ComparablePoint(f, f1));

        return getByComparableList(points);
    }

    /**
     * Main Constructor for creating a HexominoNumberSet
     * 
     * @param points
     *            Set of six points which specifies the shape and position of a
     *            Hexomino. The set must contain exactly six elements, and one
     *            element must be (0,0).
     */
    public static HexominoNumberSet getByList(List<Point> points) {
        if (points == null)
            throw new IllegalArgumentException("Points can't be null");

        List<ComparablePoint> newPoints = new LinkedList<ComparablePoint>();
        for (Point p : points) {
            newPoints.add(new ComparablePoint(p));
        }

        return getByComparableList(newPoints);
    }

    public static HexominoNumberSet getByComparableList(
            List<ComparablePoint> points) {
        points.sort(null);
        HexominoNumberSet.validatePoints(points);
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
