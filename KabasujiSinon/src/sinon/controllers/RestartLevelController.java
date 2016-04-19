package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import sinon.main.Game;
import sinon.views.MainView;

/**
 * GENERAL NOTE: THIS CLASS MIGHT NEED TO HAVE THE LEVEL MODEL AS A FIELD
 */

public class RestartLevelController implements ActionListener {

	/** Top level game object to manipulate.*/
	Game game;
    /** This is the current panel that we are trying to exit from.*/
	JPanel mainView;

	public RestartLevelController(Game g, MainView mv){
		this.game = g;
		this.mainView = mv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("(TEMP) RESETTING LEVEL. . .");
	}
}
