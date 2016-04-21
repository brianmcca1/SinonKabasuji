package sinon.models.data;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A HexominoCode is the ArrayList of six points that represents a
 * HexominoNumberSet
 */
public final class HexominoCode implements Serializable {

    /** ArrayList of six points representing a HexominoNumberSet */
    ArrayList<Point> points;

    public HexominoCode() {

    }

    /**
     * Returns the list of points representing a HexominoNumberSet
     * 
     * @return The list of points.
     */
    public List<Point> getPoints() {
        return points;
    }
}