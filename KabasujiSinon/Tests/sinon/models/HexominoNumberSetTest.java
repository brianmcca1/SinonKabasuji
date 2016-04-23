package sinon.models;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import sinon.models.HexominoNumberSet;
import sinon.models.NumberSetFactory;
import sinon.models.data.HexominoCode;

public class HexominoNumberSetTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullSet() {
        List<Point> points = null;

        @SuppressWarnings("unused")
        HexominoNumberSet set = NumberSetFactory.getByList(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullCode() {
        HexominoCode c = null;
        @SuppressWarnings("unused")
        HexominoNumberSet set = NumberSetFactory.getByCode(c);
    }

    @Test
    public void testCreateLegalNumberSet() {
        List<Point> points = getLegalNumberSet();

        @SuppressWarnings("unused")
        HexominoNumberSet set = NumberSetFactory.getByList(points);
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
        HexominoNumberSet set = NumberSetFactory.getByList(points);
    }

    @Test
    public void testGetNormalizedSet() {

        HexominoNumberSet set = NumberSetFactory.getByNumbers(-3, 0, -2, 0, -1,
                0, 0, 0, 1, 0, 2, 0);

        List<Point> newPoints = set.getNormalizedPoints();

        List<Point> points = new LinkedList<Point>();
        for (int i = 0; i < 6; i++) {
            points.add(new Point(i, 0));
        }

        assertEquals(newPoints, points);
    }

    @Test
    public void testGetNormalizedSetIsACopy() {
        HexominoNumberSet setOne = NumberSetFactory.getByNumbers(-3, 0, -2, 0,
                -1, 0, 0, 0, 1, 0, 2, 0);
        HexominoNumberSet setTwo = NumberSetFactory.getByNumbers(-3, 0, -2, 0,
                -1, 0, 0, 0, 1, 0, 2, 0);

        List<Point> newPoints = setOne.getNormalizedPoints();
        newPoints.get(0).translate(5, 3);

        assertEquals("getNormalizedPoints is leaking fields", setOne, setTwo);
    }
}