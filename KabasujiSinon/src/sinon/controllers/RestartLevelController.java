package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sinon.main.Game;
import sinon.views.MainView;

/**
 * This is the controller responsible for restarting the level.
 */
public class RestartLevelController implements ActionListener {

	/** Top level game object to manipulate. */
	Game game;
	/** This is the current panel that we are trying to exit from. */
	JPanel mainView;

	/**
	 * Controller for restarting the level
	 * 
	 * @param g
	 *            The game object
	 * @param mv
	 *            The MainView object
	 */
	public RestartLevelController(Game g, MainView mv) {
		this.game = g;
		this.mainView = mv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
