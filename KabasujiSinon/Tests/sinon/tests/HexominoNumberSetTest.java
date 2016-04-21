package sinon.tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import sinon.models.HexominoNumberSet;

public class HexominoNumberSetTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullSet() {

        @SuppressWarnings("unused")
        HexominoNumberSet set = new HexominoNumberSet(null);
    }

    @Test
    public void testCreateLegalNumberSet() {
        List<Point> points = getLegalNumberSet();

        @SuppressWarnings("unused")
        HexominoNumberSet set = new HexominoNumberSet(points);
    }

    /**
     * Returns a straight line of six points. Is used to quickly get a legal
     * HexominoNumberSet
     */
    private List<Point> getLegalNumberSet() {
        List<Point> points = new LinkedList<Point>();
        for (int i = 0; i < 6; i++) {
            points.add(new Point(0, i));
        }

        return points;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyNumbers() {
        // Tests if you can create a HexominoNumberSet with too many numbers.
        List<Point> points = getLegalNumberSet();
        points.add(new Point(0, 6));

        @SuppressWarnings("unused")
        HexominoNumberSet set = new HexominoNumberSet(points);
    }

    @Test
    public void testGetNormalizedSet() {

        HexominoNumberSet set = new HexominoNumberSet(-3, 0, -2, 0, -1, 0, 0, 0,
                1, 0, 2, 0);

        List<Point> newPoints = set.getNormalizedPoints();

        List<Point> points = new LinkedList<Point>();
        for (int i = 0; i < 6; i++) {
            points.add(new Point(i, 0));
        }

        assertEquals(newPoints, points);
    }
}
