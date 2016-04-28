package sinon.models;

import static org.junit.Assert.fail;

import org.junit.Test;

import sinon.moves.MoveToBoardFromBullpen;

public class ModelIntegrationTest {

	Hexomino hex1;
	Hexomino hex2;
	Hexomino hex3;
	Hexomino hex4;
	Hexomino hex5;
	Hexomino hex6;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void constructHexominos() {
		HexominoNumberSet hexset1 = NumberSetFactory.getByNumbers(0, 0, 1, 0, 0, 1, 1, 1, -1, 1, 0, 2);
		hex1 = new Hexomino(hexset1);
		hex2 = new Hexomino(hexset1);
		hex3 = new Hexomino(hexset1);
		hex1.flipVertically();
		hex2.rotateC();

		hex4 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 1, 1, 1, 2));
		hex4.flipVertically();

		hex5 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 2, 1, 3, 0, 4, 0));
		hex6 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
	}

	public void initializeMoves(Level level) {
		// Move Hexomino 1 to (1, 0)
		MoveToBoardFromBullpen move1 = new MoveToBoardFromBullpen(level, 1, 0);
		// Move Hexomino 2 to (5, 1)
		MoveToBoardFromBullpen move2 = new MoveToBoardFromBullpen(level, 5, 1);
		// Move Hexomino 3 to (7, 0)
		MoveToBoardFromBullpen move3 = new MoveToBoardFromBullpen(level, 7, 0);
		// Move Hexomino 4 to (3, 1)
		MoveToBoardFromBullpen move4 = new MoveToBoardFromBullpen(level, 3, 1);
		// Move Hexomino 5 to (2, 0)
		MoveToBoardFromBullpen move5 = new MoveToBoardFromBullpen(level, 2, 0);
	}

}
