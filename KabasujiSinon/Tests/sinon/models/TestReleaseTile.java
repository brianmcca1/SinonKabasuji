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
		assertFalse(releaseNumber.getCollected());

		ReleaseTile releaseTile = new ReleaseTile(new Point(0, 0), true);
		assertTrue(releaseTile.addReleaseNumber(releaseNumber));
		assertEquals(releaseNumber.getLocation().get(), new Point(0, 0));
		assertEquals(releaseTile.getReleaseNumber().get(), releaseNumber);

		assertFalse(releaseTile.addReleaseNumber(releaseNumber));

		assertTrue(releaseTile.removeReleaseNumber());
		assertEquals(releaseNumber.getLocation(), Optional.empty());
		assertFalse(releaseTile.hasReleaseNumber());
	}

}
