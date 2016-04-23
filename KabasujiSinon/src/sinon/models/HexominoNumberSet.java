package sinon.models;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

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
     * Main Constructor for creating a HexominoNumberSet
     * 
     * @param points
     *            Set of six points which specifies the shape and position of a
     *            Hexomino. The set must contain exactly six elements, and one
     *            element must be (0,0).
     */
    protected HexominoNumberSet(List<Point> points) {
        if (!validatePoints(points)) {
            throw new IllegalArgumentException(
                    String.format("Illegal pointsList inputted, %s ", points));
        }

        this.points = points;
    }

    void flipHorizontally() {
        for (Point p : points) {
            p.x = p.x * -1;
        }
    }

    void flipVertically() {
        for (Point p : points) {
            p.y = p.y * -1;
        }
    }

    /**
     * Validates the state of any set of points. Points are legal if they are
     * all connected, if they contain (0,0), have six points.
     * 
     * @return True if the set of points given is in a legal state for a
     *         HexominoNumberSet.
     */
    static boolean validatePoints(List<Point> list) {
        if (list == null) {
            return false;
        } else if (list.size() != SIZE) {
            return false;
        } else if (!validateConnected(list)) {
            return false;
        } else if (!list.contains(new Point(0, 0))) {
            return false;
        }
        return true;
    }

    /**
     * Determines if a set of points is connected.
     * 
     * @param list
     *            The set of points to test
     * @return True if the points are connected.
     */
    private static boolean validateConnected(List<Point> list) {
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

    void rotateC() {
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

    void rotateCC() {
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
        StringBuilder str = new StringBuilder("{");
        for (Point p : this.points) {
            str.append(String.format(", (%s, %s)", p.x, p.y));
        }
        str.deleteCharAt(1);
        str.deleteCharAt(2); // remove extra space at beginning
        str.append("}");

        return str.toString();
    }
}
