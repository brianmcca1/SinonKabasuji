package sinon.controllers;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JPanel;

import org.junit.Test;

import sinon.main.Builder;
import sinon.models.Level;
import sinon.views.builder.BuilderMenuBar;

public class TestOpen {

	@Test
	public void testOpen() {
		// TODO: How to automate navigating the JFileChooser?
		Builder builder = new Builder();
		BuilderMenuBar builderMenuBar = new BuilderMenuBar(builder, new JPanel());
		BuilderOpenController controller = new BuilderOpenController(builder,
				new BuilderMenuBar(builder, new JPanel()));
		ActionEvent e = new ActionEvent(builderMenuBar, 0, "Test");
		FileHandler.setCurrentFile(new File("/level1.dat"));
		controller.actionPerformed(e);

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
