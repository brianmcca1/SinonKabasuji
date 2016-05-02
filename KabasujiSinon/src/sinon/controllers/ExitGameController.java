package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Game;
import sinon.models.data.LevelType.Types;
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
		handleExit();
	}
	
	public void handleExit(){
		this.game.determineCurrentGameLevelFile();

		FileHandler.setStarsOnExit(this.game.getLevel());

		Types currentLevelType = this.game.getLevel().getLevelData().getLevelType();
		switch(currentLevelType){
			case PUZZLE:
				break;
			case LIGHTNING:
				LightningTimerController.timer.stop();
				break;
			case RELEASE:
				break;
		}
		
		game.loadAllLevels();
		game.determineUnlocking();
		game.startNextPanel(this.game.getMainView(), new LevelSelectView(this.game));
	}

}
