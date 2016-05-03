package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sinon.models.data.LevelData;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.serial.Deserializer;

public class PuzzleIntegrationTest {
	PuzzleLevel level;
	int movesLeft;

	@Before
	public void setUp() {
		movesLeft = 8;
		level = this.openLevel();
	}

	@Test
	public void testRun() {
		ArrayList<Hexomino> hexominos = (ArrayList<Hexomino>) this.level.getBullpen().getPieces();

		int i = 0;
		for (Hexomino hex : hexominos) {
			this.level.select(hex);
			MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(this.level, i, 0);
			assertTrue(this.level.hasSelected());
			assertTrue(move.valid());
			assertTrue(move.doMove());
			i++;
		}

		assertEquals(this.level.countStars(), 3);
	}

	private PuzzleLevel openLevel() {
		File levelFile = new File("testpuzzle");
		Deserializer deserializer = new Deserializer(levelFile);
		LevelData levelData = deserializer.deserializeFile();
		PuzzleLevel level = new PuzzleLevel(new Level(levelData));
		return level;
	}
}
