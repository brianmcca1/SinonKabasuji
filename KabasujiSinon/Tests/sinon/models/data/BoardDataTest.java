package sinon.models.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Board;

/**
 * @author Josh Desmond
 *
 */
public class BoardDataTest {

	/** This board has unplayable tiles at (1,2), (2,3), and (6,8) */
	Board board;

	@Before
	public void setUp() {
		board = new Board();
		board.getTile(1, 2).setPlayable(false);
		board.getTile(2, 3).setPlayable(false);
		board.getTile(6, 8).setPlayable(false);

	}

	@Test
	public void testCreateBoardData() {
		BoardData data = new BoardData(board);
		boolean[][] booleanArray = data.getPlayableArray();

		assertFalse(booleanArray[1][2]);
		assertFalse(booleanArray[2][3]);
		assertFalse(booleanArray[6][8]);
		assertTrue(booleanArray[2][1]);
		assertTrue(booleanArray[0][1]);
		assertTrue(booleanArray[6][7]);
		assertTrue(booleanArray[11][11]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNullBoard() {
		Board nullBoard = null;
		@SuppressWarnings("unused")
		BoardData data = new BoardData(nullBoard);
	}

	@Test
	public void testEquals() {
		BoardData data1 = new BoardData(board);
		BoardData data2 = new BoardData(board);

		// Test equality.
		assertEquals(data1, data2);
		assertEquals(data1.hashCode(), data2.hashCode());

		// Test inequality.
		data1.playable[5][5] = false;
		assertNotEquals(data1, data2);
	}

	@Test
	public void testSerialize() throws IOException {
		BoardData data = new BoardData(board);
		new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(data);

		// TODO test serializability;
		// fail("test isn't finished yet");
	}

}
