package sinon.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sinon.moves.MoveToBoardFromBullpen;

public class PuzzleIntegrationTest {

	PuzzleLevel level;
	int movesLeft;
	private ModelIntegrationTest m;
	MoveToBoardFromBullpen move1;
	MoveToBoardFromBullpen move2;
	MoveToBoardFromBullpen move3;
	MoveToBoardFromBullpen move4;
	MoveToBoardFromBullpen move5;
	
	@Before
	public void setUp() {
		movesLeft = 8;
		m = new ModelIntegrationTest();
		level = new PuzzleLevel(m.getBoard(), m.getBullpen(), movesLeft);
		initializeMoves(level);
	}
	
	void initializeMoves(Level level) {
		// Move Hexomino 1 to (1, 0)
		this.move1 = new MoveToBoardFromBullpen(level, 2, 2);
		// Move Hexomino 2 to (5, 1)
		this.move2 = new MoveToBoardFromBullpen(level, 5, 1);
		// Move Hexomino 3 to (7, 0)
		this.move3 = new MoveToBoardFromBullpen(level, 7, 0);
		// Move Hexomino 4 to (3, 1)
		this.move4 = new MoveToBoardFromBullpen(level, 3, 1);
		// Move Hexomino 5 to (2, 0)
		this.move5 = new MoveToBoardFromBullpen(level, 2, 0);
	}
	
	@Test
	public void testRun() {
		level.select(m.hex3);
		assertTrue(move3.valid());
	}
}
