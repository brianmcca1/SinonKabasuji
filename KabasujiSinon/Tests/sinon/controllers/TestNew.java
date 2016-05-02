package sinon.controllers;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;

import org.junit.Test;

import sinon.main.Builder;
import sinon.models.data.LevelType.Types;
import sinon.views.builder.BuilderMenuBar;

public class TestNew {

	@Test
	public void testNewPuzzle() {
		Builder builder = new Builder();
		BuilderMenuBar builderMenuBar = new BuilderMenuBar(builder);
		BuilderNewPuzzleLevelController puzzleController = new BuilderNewPuzzleLevelController(builder, builderMenuBar);
		ActionEvent e = new ActionEvent(builderMenuBar, 0, "Test");
		puzzleController.actionPerformed(e);

		assertEquals(builder.getLevel().getBullpen().hexominoCount(), 0);

		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.PUZZLE);

	}

	@Test
	public void testNewLightning() {
		Builder builder = new Builder();
		BuilderMenuBar builderMenuBar = new BuilderMenuBar(builder);
		BuilderNewLightningLevelController lightningController = new BuilderNewLightningLevelController(builder,
				builderMenuBar);
		ActionEvent e = new ActionEvent(builderMenuBar, 0, "Test");
		lightningController.actionPerformed(e);

		assertEquals(builder.getLevel().getBullpen().hexominoCount(), 0);

		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.LIGHTNING);
	}

	@Test
	public void testNewRelease() {
		Builder builder = new Builder();
		BuilderMenuBar builderMenuBar = new BuilderMenuBar(builder);
		BuilderNewReleaseLevelController releaseController = new BuilderNewReleaseLevelController(builder,
				builderMenuBar);
		ActionEvent e = new ActionEvent(builderMenuBar, 0, "Test");
		releaseController.actionPerformed(e);

		assertEquals(builder.getLevel().getBullpen().hexominoCount(), 0);

		assertEquals(builder.getLevel().getLevelData().getLevelType(), Types.RELEASE);
	}

}
