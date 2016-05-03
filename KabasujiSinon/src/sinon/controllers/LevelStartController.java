package sinon.controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import sinon.main.Game;
import sinon.models.LightningLevel;
import sinon.models.PuzzleLevel;
import sinon.models.data.LevelType.Types;
import sinon.views.LevelTypeInfoView;
import sinon.views.LightningInfoView;
import sinon.views.PuzzleInfoView;
import sinon.views.ReleaseInfoView;
import sinon.views.game.LevelSelectView;

/**
 * This controller responds to actions with a LevelSelectButtonView and will
 * removes the LevelSelectView from the frame and adds MainView to the frame.
 */
public class LevelStartController implements ActionListener {

	/** LevelSelectView to be removed from the frame. */
	LevelSelectView levelSelectView;
	/** The level number that this button corresponds to (0-14). */
	int levelNum;
	/** Top level Game object. */
	Game game;

	/**
	 * @param g
	 *            Top level Game/Builder object.
	 * @param v
	 *            LevelSelectView to be removed from the frame.
	 * @param num This level's number.
	 */
	public LevelStartController(Game g, LevelSelectView v, int num) {
		this.levelSelectView = v;
		this.levelNum = num;
		this.game = g;
	}

	@Override
	/**
	 * Response to a LevelSelectButtonView being clicked Calls on Game to start
	 * the MainView.
	 */
	public void actionPerformed(ActionEvent e) {
		if (this.game.getLevel(this.levelNum).getLevelData().getUnlocked() == false) {
			return;
		}

		this.game.setCurrentLevelNumber(this.levelNum);
		this.game.setLevel(this.game.getLevel(this.levelNum));

		FileHandler.determineCurrentGameLevelFile(this.game.getCurrentLevelNumber());

		LevelTypeInfoView lvlTypeInfoView = null;
		Types thisLevelsType = this.game.getLevel(this.levelNum).getLevelData().getLevelType();

		switch (thisLevelsType) {
		case PUZZLE:
			lvlTypeInfoView = new PuzzleInfoView(this.game,
					this.game.getLevel().getLevelData().getLevelProperty().getMaxMoves(),
					(PuzzleLevel) this.game.getLevel(levelNum));
			break;
		case LIGHTNING:
			lvlTypeInfoView = new LightningInfoView(this.game,
					this.game.getLevel().getLevelData().getLevelProperty().getMaxTime(),
					(LightningLevel) this.game.getLevel(this.levelNum));
			new LightningTimerController((LightningLevel) (this.game.getLevel()), (LightningInfoView) lvlTypeInfoView);
			break;
		case RELEASE:
			lvlTypeInfoView = new ReleaseInfoView(
					this.game.getLevel().getLevelData().getLevelProperty().getReleaseSet(), this.game.getLevel());
			break;
		}

		this.game.initializeMainView(this.levelSelectView, lvlTypeInfoView);
		this.game.initializeControllers();
	}

}
