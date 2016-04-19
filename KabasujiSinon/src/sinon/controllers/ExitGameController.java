package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sinon.main.Game;
import sinon.views.game.LevelSelectView;

/** This is the controller that is responsible for controlling
 * the game exit from the Game. It starts up the Level Select Menu.
 * 
 */
public class ExitGameController implements ActionListener {
	/**
	 * The game that is being exited.
	 * This is used to feed the constructor 
	 * responsible for generating a new LevelSelectView
	 */
    Game game;
    
    /**
     * This is the current panel that we are trying to exit from
     */
    JPanel mainView;

    public ExitGameController(Game game, JPanel mainView) {
        this.game = game;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.startNextPanel(mainView, new LevelSelectView(game));
    }

}
