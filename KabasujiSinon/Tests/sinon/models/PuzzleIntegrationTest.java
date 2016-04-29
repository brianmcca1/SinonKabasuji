package sinon.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuzzleIntegrationTest {

	PuzzleLevel level;
	int movesLeft;
	private ModelIntegrationTest m;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void setUp() {
		movesLeft = 8;
		m = new ModelIntegrationTest();
		level = new PuzzleLevel(m.getBoard(), m.getBullPen(), movesLeft);
		m.initializeMoves(level);
	}
	
	@Test
	public void testRun() {
		assertTrue(m.move1.doMove());
		
	}
}
