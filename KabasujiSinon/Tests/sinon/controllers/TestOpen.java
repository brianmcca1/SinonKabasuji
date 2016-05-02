package sinon.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import sinon.main.Builder;
import sinon.models.Level;
import sinon.views.builder.BuilderMenuBar;

public class TestOpen {

	@Test
	public void testOpen() {
		// TODO: How to automate navigating the JFileChooser?
		Builder builder = new Builder();
		BuilderOpenController controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertTrue(controller.openFile(new File("level1.dat")));
		assertFalse(controller.openFile(new File("level1.dat")));

	}

	@Test
	public void testLoadAll() {
		Level[] levels = new Level[15];
		levels = FileHandler.loadAllLevels();
		assertEquals(levels[0].countStars(), 0);
		for (int i = 0; i < 15; i++) {
			FileHandler.determineCurrentGameLevelFile(i);
		}

	}

}
