package sinon.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuzzleIntegrationTest {

	PuzzleLevel level;
	int movesLeft;
	private ModelIntegrationTest m;
	
	@Before
	public void setUp() {
		movesLeft = 8;
		m = new ModelIntegrationTest();
		level = new PuzzleLevel(m.getBoard(), m.getBullPen(), movesLeft);
		m.initializeMoves(level);
		
		assertTrue(m.hex3 != null);
	}
	
	@Test
	public void testRun() {
		level.select(m.hex3);
		assertTrue(m.move3.valid());
		
	}
}
