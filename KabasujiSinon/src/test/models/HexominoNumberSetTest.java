package test.models;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

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
        Set<Point> points = getLegalNumberSet();

        @SuppressWarnings("unused")
        HexominoNumberSet set = new HexominoNumberSet(points);
    }

    /**
     * Returns a straight line of six points. Is used to quickly get a legal
     * HexominoNumberSet
     */
    private Set<Point> getLegalNumberSet() {
        Set<Point> points = new HashSet<Point>();
        for (int i = 0; i < 6; i++) {
            points.add(new Point(0, i));
        }

        return points;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyNumbers() {
        // Tests if you can create a HexominoNumberSet with too many numbers.
        Set<Point> points = getLegalNumberSet();
        points.add(new Point(0, 6));

        @SuppressWarnings("unused")
        HexominoNumberSet set = new HexominoNumberSet(points);
    }

    @Test
    public void testGetNormalizedSet() {

        HexominoNumberSet set = new HexominoNumberSet(-3, 0, -2, 0, -1, 0, 0, 0,
                1, 0, 2, 0);

        Set<Point> newPoints = set.getNormalizedPoints();

        Set<Point> points = new HashSet<Point>();
        for (int i = 0; i < 6; i++) {
            points.add(new Point(i, 0));
        }

        assertEquals(newPoints, points);
    }
}
