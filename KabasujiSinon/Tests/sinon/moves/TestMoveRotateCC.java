package sinon.moves;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sinon.models.Hexomino;
import sinon.models.LightningLevel;
import sinon.models.NumberSetFactory;

public class TestMoveRotateCC {

    @Test
    public void test() {
        Hexomino hex = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2,
                0, 3, 0, 4, 0, 5, 0));
        RotateHexominoClockwiseMove fhm = new RotateHexominoClockwiseMove(hex);
        assertTrue(fhm.doMove());
        assertTrue(fhm.undo());
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Hexomino hex = null;
        RotateHexominoClockwiseMove fhm = new RotateHexominoClockwiseMove(hex);
        assertFalse(fhm.doMove());
        assertFalse(fhm.undo());
    }

    @Test
    public void testDuplicatesInBullpen() {
        LightningLevel level = LightningLevel.getExampleLevel();
        level.getBullpen().addHexomino(Hexomino.getExampleHexomino());
        RotateHexominoClockwiseMove m = new RotateHexominoClockwiseMove(
                level.getBullpen().getPieces().get(0));
        assertTrue(m.doMove());

        // Now the 0th hexomino has been rotated clockwise, we must verify that
        // the second hasn't rotated.
        Hexomino h0 = level.getBullpen().getPieces().get(0);
        Hexomino h1 = level.getBullpen().getPieces().get(1);

        assertFalse("Numbersets should be different",
                h0.getNormalizedPoints().equals(h1.getNormalizedPoints()));
    }

}
