package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import sinon.main.Game;
import sinon.views.MainView;

/**
 * This controller responds to actions with the next level button in the MainView.
 */
public class NextLevelController implements ActionListener{

	/** Top level game object to manipulate.*/
	Game game;
    /** This is the current panel that we are trying to exit from.*/
	JPanel mainView;

    /**
     * @param g
     * 		Top level Game/Builder object.
     * @param mv
     * 		MainView that will be removed from the frame.
     */
	public NextLevelController(Game g, MainView mv){
		this.game = g;
		this.mainView = mv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("(TEMP) ADVANCING TO NEXT LEVEL . . .");
	}

}
