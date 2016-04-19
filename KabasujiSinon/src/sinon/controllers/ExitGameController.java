package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sinon.main.Game;
import sinon.views.MainView;
import sinon.views.game.LevelSelectView;

/** This is the controller that is responsible for controlling
 * the game exit from the Game. It starts up the Level Select Menu.
 * 
 */
public class ExitGameController implements ActionListener {
	
	/** Top level game object to manipulate.*/
    Game game;
    /** This is the current panel that we are trying to exit from.*/
    JPanel mainView;

    /**
     * @param game
     * 		Top level Game/Builder object.
     * @param mv
     * 		MainView that will be removed from the frame.
     */
    public ExitGameController(Game game, JPanel mv) {
        this.game = game;
        this.mainView = mv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("EXITING LEVEL . . .");
        game.startNextPanel(mainView, new LevelSelectView(game));
    }

}
