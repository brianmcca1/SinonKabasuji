package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;
import java.util.Optional;

import org.junit.Test;

public class TestReleaseTile {

	@Test
	public void testAddAndRemove() {
		ReleaseNumber releaseNumber = new ReleaseNumber(Color.BLUE, 1);
		assertFalse(releaseNumber.isCollected());

		assertEquals(releaseNumber.getColor(), Color.BLUE);
		ReleaseTile releaseTile = new ReleaseTile(new Point(0, 0), true);
		assertTrue(releaseTile.addReleaseNumber(releaseNumber));
		assertEquals(releaseNumber.getLocation().get(), new Point(0, 0));
		assertEquals(releaseTile.getReleaseNumber().get(), releaseNumber);

		assertFalse(releaseTile.addReleaseNumber(releaseNumber));

		assertTrue(releaseTile.removeReleaseNumber());
		assertEquals(releaseNumber.getLocation(), Optional.empty());
		assertFalse(releaseTile.hasReleaseNumber());

		assertFalse(releaseTile.removeReleaseNumber());
	}

	@Test
	public void testCollected() {
		ReleaseNumber releaseNumber = new ReleaseNumber(Color.BLUE, 1);
		ReleaseTile releaseTile = new ReleaseTile(new Point(0, 0), true);

		assertTrue(releaseTile.addReleaseNumber(releaseNumber));

		assertFalse(releaseNumber.isCollected());
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
		releaseTile.addHexomino(hex);
		assertTrue(releaseNumber.isCollected());
	}

}
