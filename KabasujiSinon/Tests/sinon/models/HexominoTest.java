package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        Hexomino hex = buildExampleHexomino();
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(0, 2));
        points.add(new Point(0, 3));
        points.add(new Point(0, 4));
        points.add(new Point(1, 4));
        HexominoNumberSet hexominoNumberSet = new HexominoNumberSet(points);
        Hexomino constructedHex = new Hexomino(hexominoNumberSet);
        assertEquals(hex, constructedHex);
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

    @Test
    public void testFlipHorizontally() {
        Hexomino hex = buildExampleHexomino();
        hex.flipHorizontally();
        Hexomino expectedFlippedHex = new Hexomino(0, 0, 0, -1, 0, -2, 0, -3, 0,
                -4, 1, -4);
        assertEquals(expectedFlippedHex, hex);
    }

    @Test
    public void testBothFlips() {
        Hexomino hex = buildExampleHexomino();
        hex.flipHorizontally();
        Hexomino expectedFlippedHex = new Hexomino(0, 0, 0, -1, 0, -2, 0, -3, 0,
                -4, 1, -4);
        assertEquals(expectedFlippedHex, hex);
    }

    @Test
    public void testRotateC() {
        Hexomino hex = buildExampleHexomino();
        hex.rotateC();
        Hexomino expectedRotatedHex = new Hexomino(0, 0, 1, 0, 2, 0, 3, 0, 4, 0,
                4, -1);
        assertEquals(expectedRotatedHex, hex);
    }

    @Test
    public void testRotateCC() {
        Hexomino hex = buildExampleHexomino();
        hex.rotateCC();
        Hexomino expectedRotatedHex = new Hexomino(0, 0, -1, 0, -2, 0, -3, 0,
                -4, 0, -4, 1);
        // FIXME move this to Hexomino Number Set
        assertEquals(expectedRotatedHex, hex);
    }

    @Test
    public void testNormalEquality() {
        Hexomino hex1 = buildExampleHexomino();
        Hexomino hex2 = buildExampleHexomino();
        assertFalse(hex1.equals(hex2));
    }

    @Test
    public void testUnorderedEquality() {
        Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
        Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 5, 0, 4);
        assertEquals(hex1, hex2);
    }

    @Test
    public void testFlippingEquailityWithOutOfOrderConstructor() {
        // FIXME move these tests over to number
        Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
        Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 5, 0, 4);

        assertEquals("Hexominos should be equal before flipping", hex1, hex2);
        hex1.flipHorizontally();
        hex1.flipHorizontally();
        assertEquals(
                "Hexominos should still be equal after flipping horizontally",
                hex1, hex2);
        hex2.flipVertically();
        hex2.flipHorizontally();
        hex1.flipHorizontally();
        hex1.flipVertically();
        assertEquals(
                "Hexominos should still be equal after flipping twice in different orders",
                hex1, hex2);
    }

    @Test
    public void testVerticleFlipEquality() {
        Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
        Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);

        hex1.flipVertically();
        hex2.flipVertically();

        boolean value = hex1.equals(hex2);

        // FIXME move to numberset test.
        System.out.println(value);
        assertEquals(
                "Hexominos should still be equal after both flipping vertically",
                hex1, hex2);
    }

    @Test
    public void testHorizontalFlipEquality() {
        Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
        Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);

        // FIXME move to numberset.
        hex1.flipHorizontally();
        hex2.flipHorizontally();

        assertEquals(
                "Hexominos should still be equal after both flipping horizontally",
                hex1, hex2);
    }

    @Test
    public void testDifferentAnchors() {
        // FIXME move to numberset test.
        Hexomino hex = buildExampleHexomino();
        Hexomino shiftedAnchor = new Hexomino(0, -1, 0, 0, 0, 1, 0, 2, 0, 3, 1,
                3);
        assertEquals(hex, shiftedAnchor);
        shiftedAnchor.rotateC();
        shiftedAnchor.flipHorizontally();
        hex.rotateC();
        hex.flipHorizontally();
        assertEquals(hex.getNormalizedPoints(),
                shiftedAnchor.getNormalizedPoints());
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
        assertFalse(hex.addToTile(t));
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

    @Test
    public void testMakingWackyHexomino() {
        HexominoNumberSet s = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                -1, 1, 1, 0, 1, 1);

        HexominoNumberSet sFlipped = NumberSetFactory.getByNumbers(0, 0, 0, 1,
                0, 2, -1, 1, 1, 1, 1, 2);
        // . x x
        // x x x
        // . x .
        Hexomino h = new Hexomino(s);
        h.flipVertically();
        Hexomino hFlipped = new Hexomino(sFlipped);

        assertEquals(h.getHexominoNumberSet().getNormalizedPoints(),
                (hFlipped.getHexominoNumberSet().getNormalizedPoints()));

    }

}
