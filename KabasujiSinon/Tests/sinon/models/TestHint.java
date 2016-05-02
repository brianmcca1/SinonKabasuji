package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class TestHint {
    /** Point (1,1) where the hexomino was added to the hint */
    Point anchor;
    /** Example hexomino which is created into the hint. */
    Hexomino hex;

    @Before
    public void setUp() throws Exception {
        hex = Hexomino.getExampleHexomino();
        anchor = new Point(1, 1);
    }

    @Test
    public void testCreateHint() {
        Hint h = new Hint(hex, anchor);
        assertTrue(h.anchorPos.equals(anchor));
    }

    @Test(expected = NullPointerException.class)
    public void testNullHexInput() {
        @SuppressWarnings("unused")
        Hint h = new Hint(null, anchor);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointInput() {
        @SuppressWarnings("unused")
        Hint h = new Hint(hex, null);
    }

    @Test
    public void testGetHexominoNumberSet() {
        Hint h = new Hint(hex, anchor);
        boolean validate = HexominoNumberSet
                .validatePoints(h.getHexominoNumberSet().points);
        assertTrue("Hint should have a valid set of points", validate);
    }

    @Test
    public void testGetAnchor() {
        Hint h = new Hint(hex, anchor);
        assertEquals(anchor, h.getAnchor());
    }

}
