package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class HexominoTest {

    @Before
    public void setUp() throws Exception {

    }

    /**
     * 
     * @return {[0,0],[0,1],[0,2],[0,3],[0,4],[1,4]}
     */
    private static Hexomino buildExampleHexomino() {
        return new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
    }

    @Test
    public void testHexNumSetConstructor() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(0, 2));
        points.add(new Point(0, 3));
        points.add(new Point(0, 4));
        points.add(new Point(1, 4));
        HexominoNumberSet hexominoNumberSet = new HexominoNumberSet(points);
        Hexomino constructedHex = new Hexomino(hexominoNumberSet);
        // Not really validating much, just making sure it runs kinda.
        assertTrue(constructedHex.hexominoNumberSet.equals(hexominoNumberSet));
    }

    @Test
    public void testFlipVertically() {
        Hexomino hex = buildExampleHexomino();
        hex.flipVertically();
        Hexomino expectedFlippedHex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4,
                -1, 4);
        assertEquals(expectedFlippedHex.getNormalizedPoints(),
                hex.getNormalizedPoints());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullConstructor() {

        Set<Point> points = null;
        @SuppressWarnings("unused")
        Hexomino hex = new Hexomino(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPointsSize() {
        Set<Point> points = new HashSet<Point>();
        for (int i = 0; i < 8; i++) {
            points.add(new Point(0, i));
            i++;
        }
        @SuppressWarnings("unused")
        Hexomino hex = new Hexomino(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPointsContent() {
        HashSet<Point> points = new HashSet<Point>();
        for (Point p : points) {
            p = new Point(1, 1);
            points.add(p);
        }
        @SuppressWarnings("unused")
        Hexomino hex = new Hexomino(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTile() {
        Hexomino hex = buildExampleHexomino();
        hex.addToTile(null);
    }

    @Test
    public void testAddToTile() {
        Hexomino hex = buildExampleHexomino();
        Tile t = new Tile(new Point(0, 0), true);
        assertTrue(hex.addToTile(t));
        assertTrue(t.hasHex());
    }

    @Test
    public void testGetHexNumSet() {
        Hexomino hex = buildExampleHexomino();
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(0, 2));
        points.add(new Point(0, 3));
        points.add(new Point(0, 4));
        points.add(new Point(1, 4));
        HexominoNumberSet hexominoNumberSet = new HexominoNumberSet(points);
        assertEquals(hex.getHexominoNumberSet(), hexominoNumberSet);
    }
}
