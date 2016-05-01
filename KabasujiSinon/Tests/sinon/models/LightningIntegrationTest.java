package sinon.models;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sinon.moves.MoveToBoardFromBullpen;

public class LightningIntegrationTest {

	LightningLevel exampleLevel;
	Board board;
	BullPen bullpen;

	@Before
	public void setup() {
		// Set up the board for the game.
		// It will be a 6x6 set of playable tiles in the top left.
		board = new Board();
		for (Tile t : board.getTiles()) {
			t.setPlayable(false);
		}
		for (int i = 0; i < 6; i++) {
			for (int z = 0; z < 6; z++) {
				board.getTile(i, z).setPlayable(true);
			}
		}

		// Set up the HexominoList for the bullpen.
		List<Hexomino> hexList = new LinkedList<Hexomino>();
		HexominoNumberSet sixByOne = NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
		for (int i = 0; i < 8; i++) {
			Hexomino hex = new Hexomino(sixByOne);
			hexList.add(hex);
		}

		bullpen = new BullPen(hexList);
		exampleLevel = new LightningLevel(board, bullpen, 30);
	}

	@Test
	public void testRunGame() {
		Hexomino hexToMove = bullpen.getPieces().get(0);
		exampleLevel.select(hexToMove);

		MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(exampleLevel, 0, 0);
		assertTrue(move.valid());
		int initBullpenSize = bullpen.getPieces().size();
		assertTrue(move.doMove());
		assertEquals(initBullpenSize, bullpen.getPieces().size());
		assertFalse(bullpen.getPieces().get(0).equals(board.getTile(0, 0).getHexomino().get()));
	}

}
