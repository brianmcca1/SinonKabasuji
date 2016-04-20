package sinon.views.game;

import java.awt.Dimension;

import javax.swing.JButton;

import sinon.controllers.ExitGameController;
import sinon.main.Game;
import sinon.views.InfoPanel;
import sinon.views.MainView;

@SuppressWarnings("serial")
public class GameInfoView extends InfoPanel {
	
	/** Top level game object to manipulate.*/
	Game game;
	
	/** Button objects that appear on the panel.*/
	JButton exitButton;
	JButton restartButton;
	JButton nextLevelButton;

	/**	
	 * @param g
	 * 		The top level Game object.
	 */
	public GameInfoView(Game g) {
		super();

		this.game = g;
		
		JButton btnRestart = new JButton("Restart level\r\n");
		btnRestart.setPreferredSize(new Dimension(120, 30));
		this.add(btnRestart);
		this.restartButton = btnRestart;

		JButton btnNextLevel = new JButton("Next Level\r\n");
		btnNextLevel.setPreferredSize(new Dimension(120, 30));
		this.add(btnNextLevel);
		this.nextLevelButton = btnNextLevel;
		
		JButton btnExit = new JButton("Exit Level\r\n");
		btnExit.setPreferredSize(new Dimension(120, 30));
		this.add(btnExit);
		this.exitButton = btnExit;
	}
	
	@Override
	/**@return Returns the JButton object for the exit button.*/
	public JButton getExitButton(){ return this.exitButton;}
	
	@Override
	/**@return Returns the JButton object for the restart button.*/
	public JButton getRestartButton(){ return this.restartButton;}
	
	@Override
	/**@return Returns the JButton object for the next level button.*/
	public JButton getNextLevelButton(){ return this.nextLevelButton;}
}
