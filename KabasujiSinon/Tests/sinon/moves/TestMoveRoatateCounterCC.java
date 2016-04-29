package sinon.moves;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;

public class TestMoveRoatateCounterCC {

	@Test
	public void test() {
		Hexomino hex = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		RotateHexominoCounterClockwiseMove fhm = new RotateHexominoCounterClockwiseMove(hex);
		assertTrue(fhm.doMove());
		assertTrue(fhm.undoMove());
	}

	@Test(expected = NullPointerException.class)
	public void testNull() {
		Hexomino hex = null;
		RotateHexominoCounterClockwiseMove fhm = new RotateHexominoCounterClockwiseMove(hex);
		assertFalse(fhm.doMove());
		assertFalse(fhm.undoMove());
	}
}
