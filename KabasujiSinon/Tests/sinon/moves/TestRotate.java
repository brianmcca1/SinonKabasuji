package sinon.moves;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;

public class TestRotate {

	@Test
	public void test() {
		Hexomino hex = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		RotateHexominoClockwiseMove rotateClockwise = new RotateHexominoClockwiseMove(hex);
		RotateHexominoCounterClockwiseMove rotateCounterClockwise = new RotateHexominoCounterClockwiseMove(hex);

		assertTrue(rotateClockwise.doMove());
		assertTrue(rotateClockwise.undoMove());

		assertTrue(rotateCounterClockwise.doMove());
		assertTrue(rotateCounterClockwise.undoMove());
	}

	@Test(expected = NullPointerException.class)
	public void testNull() {
		Hexomino hex = null;
		RotateHexominoCounterClockwiseMove rotateCounterClockwise = new RotateHexominoCounterClockwiseMove(hex);

		rotateCounterClockwise.doMove();

	}

}
