package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TestLightingLevel {

	@Test
	public void testHasWon() {
		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		bpList.add(hex1);
		bpList.add(hex2);

		LightningBoard b = new LightningBoard();
		BullPen bp = new BullPen(bpList);
		LightningLevel level = new LightningLevel(b, bp, 1);
		assertEquals(level.getTimeLeft(), 1);
		assertEquals(level.getMaxTime(), 1);
		assertFalse(level.hasWon());
		assertEquals(level.countStars(), 0);
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 11; j++) {
				LightningTile tile = (LightningTile) b.getTile(i, j);
				tile.addHexomino(hex1);
				assertTrue(tile.isLightninged());
			}
		}
		assertEquals(level.countStars(), 1);

		for (int i = 0; i < 6; i++) {
			b.getTile(i, 11).addHexomino(hex1);
		}

		assertEquals(level.countStars(), 2);

		for (int i = 6; i < 12; i++) {
			b.getTile(i, 11).addHexomino(hex1);
		}

		assertEquals(level.countStars(), 3);
		assertTrue(level.hasWon());

	}

}
