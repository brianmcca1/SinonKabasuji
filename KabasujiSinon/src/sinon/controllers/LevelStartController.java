package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Game;
import sinon.views.MainView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectButtonView;
import sinon.views.game.LevelSelectView;

/**
 * This controller responds to actions with a LevelSelectButtonView and will
 * removes the LevelSelectView from the frame and adds MainView to the frame.
 */
public class LevelStartController implements ActionListener{

	/** LevelSelectView to be removed from the frame. */
    LevelSelectView levelSelectView;
    /** Level number (1-15). */
    int levelNum;
    /** Top level Game object. */
    Game game;

    /**
     * @param g
     * 		Top level Game/Builder object
     * @param view
     * 		LevelSelectView to be removed from the frame
     */
    public LevelStartController(Game g, LevelSelectView v, int num) {
        this.levelSelectView = v;
        this.levelNum = num;
        this.game = g;
    }

	@Override
	/**
	 * Response to a LevelSelectButtonView being clicked
	 * Calls on Game to start the MainView
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("STARTING LEVEL #" + levelNum + ". . .");
		this.game.initializeMainView(this.levelSelectView);
	}
}
