package sinon.views.game;

import javax.swing.JButton;

import sinon.controllers.ExitGameController;
import sinon.main.Game;
import sinon.views.InfoPanel;
import sinon.views.MainView;

@SuppressWarnings("serial")
public class GameInfoView extends InfoPanel {
	
	Game game;
	JButton exitButton;
	JButton restartButton;
	JButton nextLevelButton;

	/**	
	 * @param g
	 * 		The top level Game object
	 */
	public GameInfoView(Game g) {
		super();

		this.game = g;
		
		JButton btnRestart = new JButton("Restart\r\n");
		btnRestart.setBounds(45, 20, 100, 50);
		this.add(btnRestart);

		JButton btnExit = new JButton("Exit\r\n");
		btnExit.setBounds(45, 100, 100, 50);
		this.add(btnExit);
		this.exitButton = btnExit;

		JButton button_2 = new JButton("Next Level\r\n");
		button_2.setBounds(45, 180, 100, 50);
		this.add(button_2);
	}
	
	@Override
	/**
	 * @return Returns the JButton object for the exit button
	 */
	public JButton getExitButton(){
		return this.exitButton;
	}
	
	@Override
	/**
	 * @return Returns the JButton object for the restart button
	 */
	public JButton getRestartButton(){
		return this.restartButton;
	}
	
	@Override
	/**
	 * @return Returns the JButton object for the next level button
	 */
	public JButton getNextLevelButton(){
		return this.nextLevelButton;
	}
}
