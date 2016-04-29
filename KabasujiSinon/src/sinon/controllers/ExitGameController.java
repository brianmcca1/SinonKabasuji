package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import sinon.main.Game;
import sinon.models.ReleaseNumber;
import sinon.models.data.BoardData;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.Types;
import sinon.serial.Serializer;
import sinon.views.ReleaseInfoView;
import sinon.views.game.LevelSelectView;

/**
 * This controller responds to actions with the exit button in the MainView.
 */
public class ExitGameController implements ActionListener {

	/** Top level game object to manipulate. */
	Game game;

	/**
	 * @param game
	 *            Top level Game/Builder object.
	 */
	public ExitGameController(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("EXITING LEVEL #" + (this.game.getCurrentLevelNumber() + 1));

		this.game.determineCurrentGameLevelFile();

		// TODO set the max stars and whatever else is relevant to the game

		Serializer serializer = new Serializer(FileHandler.currentFile, this.game.getLevel().getLevelData());
		serializer.serializeFile();

		System.out.println("*************EXIT CONTROLLER*****************");
		System.out.println(this.game.getLevel().getLevelData().toString());
		System.out.println("*********************************************");

		game.loadAllLevels();
		game.startNextPanel(this.game.getMainView(), new LevelSelectView(this.game));
	}

}
