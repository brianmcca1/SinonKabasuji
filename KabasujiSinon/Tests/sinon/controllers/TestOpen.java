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
		// FIXME: Code not being reached?
		// When I run coverage on the whole KabasujiSinon project, all of the
		// asserts are not reached. But when I run coverage on this specific
		// file, it all gets covered. -Brian
		Builder builder = new Builder();
		BuilderOpenController controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertTrue(controller.openFile(new File("level1.dat")));
		controller = new BuilderOpenController(builder, new BuilderMenuBar(builder));
		assertFalse(controller.openFile(new File("level1.dat")));
		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.PUZZLE);
		System.out.println("Test completion being reached");

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
