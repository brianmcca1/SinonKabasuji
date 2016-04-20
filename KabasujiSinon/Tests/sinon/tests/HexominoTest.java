package sinon.tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Hexomino;
import sinon.models.Hexomino;
import sinon.models.HexominoFactory;

public class HexominoTest {

    @Before
    public void setUp() throws Exception {

    }

    /**
     * 
     * @return {[0,0],[0,1],[0,2],[0,3],[0,4],[1,4]}
     */
    private static Hexomino buildExampleHexomino() {
        return new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1,
                4);
    }

    @Test
    public void testFlipHorizontally() {
        Hexomino hex = buildExampleHexomino();
        hex.flipHorizontally();
        Hexomino expectedFlippedHex = new Hexomino(0,
                0, 0, 1, 0, 2, 0, 3, 0, 4, -1, 4);
        assertEquals(expectedFlippedHex, hex);
    }

    @Test
    public void testFlipVertically() {
        Hexomino hex = buildExampleHexomino();
        hex.flipVertically();
        Hexomino expectedFlippedHex = new Hexomino(0,
                0, 0, -1, 0, -2, 0, -3, 0, -4, 1, -4);
        assertEquals(expectedFlippedHex, hex);
    }

    @Test
    public void testNormalEquality() {
        Hexomino hex1 = buildExampleHexomino();
        Hexomino hex2 = buildExampleHexomino();
        assertEquals(hex1, hex2);
    }

    @Test
    public void testUnorderedEquality() {
        Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2,
                0, 3, 0, 4, 0, 5);
        Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2,
                0, 3, 0, 5, 0, 4);
        assertEquals(hex1, hex2);
    }

    @Test
    public void testFlippingEquaility() {
        Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0,
                4, 0, 5);
        Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0,
                5, 0, 4);

        hex1.flipHorizontally();
        hex1.flipHorizontally();
        assertEquals(hex1, hex2);
        hex2.flipVertically();
        hex2.flipHorizontally();
        hex1.flipHorizontally();
        hex1.flipVertically();
        assertEquals(hex1, hex2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullConstructor() {
        @SuppressWarnings("unused")
        Hexomino hex = new Hexomino(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPointsSize() {
        HashSet<Point> points= new HashSet<Point>();
        int i = 0;
        for (Point p : points) {
            p = new Point(0, i);
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
        }
        @SuppressWarnings("unused")
        Hexomino hex = new Hexomino(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTile() {
        Hexomino hex = buildExampleHexomino();
        // FIXME this class needs to be in a different package I think?
        // I can't call hex.add(null), because add is package private.
        // That's the right visibility this test package just needs to be
        // renamed I think...
    }

}
