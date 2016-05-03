package sinon.controllers;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;

import org.junit.Test;

import sinon.main.Game;
import sinon.models.data.LevelType.Types;
import sinon.views.game.LevelSelectView;

public class TestStart {

	@Test
	public void test() {

		Game game = new Game();

		LevelSelectView levelSelectView = new LevelSelectView(game);
		LevelStartController startLevel1 = new LevelStartController(game, levelSelectView, 0);
		ActionEvent e = new ActionEvent(startLevel1, 0, "Test");
		startLevel1.actionPerformed(e);
		assertEquals(game.getCurrentLevelNumber(), 0);
		assertEquals(game.getLevel().getLevelData().getLevelType(), Types.PUZZLE);
	}

}
