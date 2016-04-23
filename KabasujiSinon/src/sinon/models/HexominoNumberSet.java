package sinon.models;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import sinon.models.data.HexominoCode;

/**
 * A HexominoNumberSet represents the six coordinate pairs that make up any
 * Hexomino.
 * 
 * TODO this class really needs a builder object I'm realizing. There are too
 * many constructors and too much validation code not to have it. The quicker we
 * refactor this to have one going the fewer problems we'll have later...
 * 
 * @author Josh Desmond
 * @author Brian McCarthy
 */
public class HexominoNumberSet {

    private static final int SIZE = 6;
    /** List of six points representing a Hexomino. */
    List<Point> points;

    /**
     * Convenience constructor. Try to avoid using this except for testing. I
     * think this will eventually be moved to the factory class.
     */
    public HexominoNumberSet(int a, int a1, int b, int b1, int c, int c1, int d,
            int d1, int e, int e1, int f, int f1) {
        points = new LinkedList<Point>();
        points.add(new Point(a, a1));
        points.add(new Point(b, b1));
        points.add(new Point(c, c1));
        points.add(new Point(d, d1));
        points.add(new Point(e, e1));
        points.add(new Point(f, f1));

        if (!validatePoints(points)) {
            throw new IllegalArgumentException(
                    String.format("Illegal pointsList inputted, %s", points));
        }
    }

    /**
     * Main Constructor for creating a HexominoNumberSet
     * 
     * @param points
     *            Set of six points which specifies the shape and position of a
     *            Hexomino. The set must contain exactly six elements, and one
     *            element must be (0,0).
     */
    public HexominoNumberSet(List<Point> points) {
        if (!validatePoints(points)) {
            throw new IllegalArgumentException(
                    String.format("Illegal pointsList inputted, %s ", points));
        }

        this.points = points;
    }

    /**
     * Creates a HexominoNumberSet from a HexominoCode.
     * 
     * @param code
     *            The immutable data object representing a HexominoNumberSet.
     */
    public HexominoNumberSet(HexominoCode code) {
        if (code == null)
            throw new IllegalArgumentException("HexominoCode can't be null");

        this.points = code.getPoints();
    }

    public void flipHorizontally() {
        for (Point p : points) {
            p.x = p.x * -1;
        }

    }

    public void flipVertically() {
        for (Point p : points) {
            p.y = p.y * -1;
        }
    }

    /**
     * Validates the state of any set of points.
     * 
     * @return True if the set of points given is in a legal state for a
     *         HexominoNumberSet.
     */
    private static boolean validatePoints(List<Point> points) {
        if (points == null) {
            return false;
        }
        if (points.size() != SIZE) {
            return false;
        }
        return true;
    }

    public void rotateC() {
        for (Point p : points) {
            int newX;
            int newY;

            // Perform rotation, Matrix is
            // [0 1]
            // [-1 0]
            newX = p.y;
            newY = p.x * -1;

            // set new location
            p.move(newX, newY);
        }
    }

    public void rotateCC() {
        rotateC();
        rotateC();
        rotateC();
    }

    /**
     * Returns the translated set of points, such that every point is positive,
     * and within the bounds of a 6x6 grid.
     * 
     * @return Returns a set of points that describes the Hexomino
     */
    public List<Point> getNormalizedPoints() {
        int mostNegativeX = 0, mostNegativeY = 0,
                mostPositiveX = Integer.MIN_VALUE,
                mostPositiveY = Integer.MIN_VALUE;

        // FIXME Creates a copy of points since we'll be modifying it.
        List<Point> copy = points;

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

        for (Point p : copy) {
            p.translate(addX, addY);
        }

        return copy;
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

    /*
     * (non-Javadoc)
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
        } else {

            for (Point p : other.points) {

                List<Point> translatedPoints = new LinkedList<Point>();
                // TODO use collections.copy
                // Translate all point in the hex to change which square is the
                // anchor
                for (Point p2 : other.points) {
                    translatedPoints.add(new Point(p2.x - p.x, p2.y - p.y));
                }
                HexominoNumberSet translatedOther = new HexominoNumberSet(
                        translatedPoints);

                for (int i = 0; i < 4; i++) {
                    if (points.equals(translatedOther.points)) {
                        return true;
                    } else {
                        // Check current rotation with just Horizontal flip
                        translatedOther.flipHorizontally();
                        if (points.equals(translatedOther.points)) {
                            return true;
                        } else {
                            // Check current rotation with Horizontal + Vertical
                            // flip
                            translatedOther.flipVertically();
                            if (points.equals(translatedOther.points)) {
                                return true;
                            } else {
                                // Check current rotation with just vertical
                                // flip
                                translatedOther.flipHorizontally(); // Undo's
                                                                    // previous
                                                                    // Horizontal
                                                                    // flip
                                if (points.equals(translatedOther.points)) {
                                    return true;
                                }
                            }
                        }

                    }
                    // First, undo the vertical flip
                    translatedOther.flipVertically();
                    // This rotation is not equal in any way, so try the next
                    // one
                    translatedOther.rotateC();
                }

            }
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HexominoNumberSet [points=" + points + "]";
    }

    /**
     * Generates a string from
     * 
     * @param points2
     * @return
     */
    public static String stringOf(List<Point> points2) {
        // TODO Auto-generated method stub
        return null;
    }

}
