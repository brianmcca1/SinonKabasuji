package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Optional;

import org.junit.Test;

public class TestTile {

	@Test
	public void testAddNormal() {
		Point p = new Point(0, 0);
		Tile t1 = new Tile(p, true);
		Hexomino hex = Hexomino.getExampleHexomino();
		Hexomino hex2 = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);
		assertEquals(t1.canAddHex(hex2), true);

		t1.addHexomino(hex2);

		assertEquals(t1.getHexomino(), Optional.of(hex2));

		assertEquals(t1.getLocation(), new Point(0, 0));

		assertEquals(t1.canAddHex(hex), false);

		assertEquals(t1.hasHex(), true);

		assertTrue(t1.removeHex());

		assertEquals(t1.hasHex(), false);

	}

	@Test
	public void testGetEmpty() {
		Point p = new Point(0, 0);
		Tile t1 = new Tile(p, true);

		Optional<Hexomino> hex = Optional.empty();

		hex = t1.getHexomino();

		assertEquals(hex.isPresent(), false);
	}

	@Test
	public void testRemoveHex() {
		Point p = new Point(0, 0);
		Tile t1 = new Tile(p, true);

		Hexomino hex = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);

		t1.addHexomino(hex);

		assertTrue(t1.removeHex());

		Optional<Hexomino> emptyHex = Optional.empty();
		emptyHex = t1.getHexomino();
		assertEquals(emptyHex.isPresent(), false);
	}

	@Test
	public void testRemoveEmpty() {
		Point p = new Point(0, 0);
		Tile t1 = new Tile(p, true);

		assertFalse(t1.removeHex());
	}

	@Test(expected = RuntimeException.class)
	public void testAddFull() {
		Tile t1 = new Tile(new Point(0, 0), true);

		Hexomino hex = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);

		t1.addHexomino(hex);

		t1.addHexomino(hex);
	}

	@Test(expected = RuntimeException.class)
	public void addUnplayable() {
		Tile t1 = new Tile(new Point(0, 0), false);
		Hexomino hex = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);
		assertEquals(t1.canAddHex(hex), false);

		t1.addHexomino(hex);

	}

	@Test
	public void setPlayable() {
		Tile t1 = new Tile(new Point(0, 0), false);
		Hexomino hex = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);
		assertFalse(t1.canAddHex(hex));

		t1.setPlayable(true);

		t1.addHexomino(hex);
		assertEquals(t1.getHexomino().get(), hex);
	}

}
