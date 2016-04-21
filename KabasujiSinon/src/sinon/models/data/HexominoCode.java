package sinon.models.data;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A HexominoCode is the ArrayList of six points that represents a
 * HexominoNumberSet
 */
public final class HexominoCode implements Serializable {
    private static final long serialVersionUID = 145174839722692695L;

    /** ArrayList of six points representing a HexominoNumberSet */
    ArrayList<Point> points;

    public HexominoCode() {

    }
}
