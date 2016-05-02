package sinon.models;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import sinon.models.data.HexominoCode;

public class HexominoNumberSetTest {

    /**
     * 
     * @return {[0,0],[0,1],[0,2],[0,3],[0,4],[1,4]}
     */
    private static HexominoNumberSet buildExampleHexomino() {
        return NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1,
                4);
    }

    @Test
    public void testFlipHorizontally() {
        HexominoNumberSet hex = buildExampleHexomino();
        hex.flipHorizontally();
        HexominoNumberSet expectedFlippedHex = NumberSetFactory.getByNumbers(0,
                0, 0, -1, 0, -2, 0, -3, 0, -4, 1, -4);
        assertEquals(expectedFlippedHex, hex);
    }

    @Test
    public void testBothFlips() {
        HexominoNumberSet hex = buildExampleHexomino();
        hex.flipHorizontally();
        HexominoNumberSet expectedFlippedHex = NumberSetFactory.getByNumbers(0,
                0, 0, -1, 0, -2, 0, -3, 0, -4, 1, -4);
        assertEquals(expectedFlippedHex, hex);
    }

    @Test
    public void testRotateC() {
        HexominoNumberSet hex = buildExampleHexomino();
        hex.rotateC();
        HexominoNumberSet expectedRotatedHex = NumberSetFactory.getByNumbers(0,
                0, 1, 0, 2, 0, 3, 0, 4, 0, 4, -1);
        assertEquals(expectedRotatedHex, hex);
    }

    @Test
    public void testRotateCC() {
        HexominoNumberSet hex = buildExampleHexomino();
        hex.rotateCC();
        HexominoNumberSet expectedRotatedHex = NumberSetFactory.getByNumbers(0,
                0, -1, 0, -2, 0, -3, 0, -4, 0, -4, 1);
        assertEquals(expectedRotatedHex, hex);
    }

    @Test
    public void testFlippingEquailityWithOutOfOrderConstructor() {
        HexominoNumberSet hex1 = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                0, 3, 0, 4, 0, 5);
        HexominoNumberSet hex2 = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                0, 3, 0, 5, 0, 4);

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
    public void testHorizontalFlipEquality() {
        HexominoNumberSet hex1 = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                0, 3, 0, 4, 0, 5);
        HexominoNumberSet hex2 = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                0, 3, 0, 4, 0, 5);

        // FIXME move to numberset.
        hex1.flipHorizontally();
        hex2.flipHorizontally();

        assertEquals(
                "Hexominos should still be equal after both flipping horizontally",
                hex1, hex2);
    }

    @Test
    public void testUnorderedEquality() {
        HexominoNumberSet hex1 = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                0, 3, 0, 4, 0, 5);
        HexominoNumberSet hex2 = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2,
                0, 3, 0, 5, 0, 4);
        assertEquals(hex1, hex2);
    }

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

    @Test
    public void testRotateAndFlippingEquality() {
        // This test is here to check if this weird looking hexomino:
        // . x x
        // x x x
        // . x .
        // doesn't act weird when flipped + rotated.
        // IE, does it rotated clockwise = it flipped vertically

        HexominoNumberSet setOne = NumberSetFactory.getByNumbers(0, 0, 1, 0, -1,
                1, 0, 1, 1, 1, 0, 2);
        HexominoNumberSet setTwo = NumberSetFactory.getByNumbers(0, 0, 1, 0, -1,
                1, 0, 1, 1, 1, 0, 2);
        setOne.flipVertically();
        setTwo.rotateC();

        assertEquals(setOne, setTwo);
    }
}
