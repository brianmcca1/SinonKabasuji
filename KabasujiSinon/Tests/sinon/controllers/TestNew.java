package sinon.controllers;

import static org.junit.Assert.fail;
import java.awt.event.ActionEvent;
import org.junit.Test;

import sinon.main.Builder;
import sinon.views.builder.BuilderMenuBar;

public class TestNew {

	@Test
	public void testNewPuzzle() {
		Builder builder = new Builder();
		BuilderMenuBar builderMenuBar = new BuilderMenuBar(builder);
		BuilderNewPuzzleLevelController puzzleController = new BuilderNewPuzzleLevelController(builder, builderMenuBar);
		ActionEvent e = new ActionEvent(builderMenuBar, 0, "Test");
		puzzleController.actionPerformed(e);

		fail("Not yet implemented");
	}

}
