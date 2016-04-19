package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Game;
import sinon.views.MainView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectButtonView;
import sinon.views.game.LevelSelectView;

public class LevelStartController implements ActionListener{

	/**LevelSelectView to be removed from the frame */
    LevelSelectView view;
    Game game;

    /**
     * @param g
     * 		Top level Game/Builder object
     * @param view
     * 		LevelSelectView to be removed from the frame
     */
    public LevelStartController(Game g, LevelSelectView view) {
        this.view = view;
        this.game = g;
    }

	@Override
	/**
	 * Response to a LevelSelectButtonView being clicked
	 * Will instantiate the MainView if it doesn't already exist, otherwise it will use the existing MainView
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("STARTING LEVEL . . .");
		if(MainView.mainView == null){
			game.startNextPanel(view, new MainView(game, new GameInfoView(game)));
		}
		else{
			game.startNextPanel(view, MainView.mainView);
		}
	}
}
