package sinon.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import sinon.main.Builder;
import sinon.models.Level;
import sinon.models.data.LevelType.Types;
import sinon.views.builder.BuilderMenuBar;

public class TestOpen {

	@Test
	public void testOpen() {
		Builder builder = new Builder();
		BuilderOpenController controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertTrue(controller.openFile(new File("testpuzzle")));
		controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertFalse(controller.openFile(new File("testpuzzle")));
		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.PUZZLE);

		assertTrue(controller.openFile(new File("testlightning")));
		controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertFalse(controller.openFile(new File("testlightning")));
		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.LIGHTNING);

		assertTrue(controller.openFile(new File("testrelease")));
		controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertFalse(controller.openFile(new File("testrelease")));
		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.RELEASE);

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
