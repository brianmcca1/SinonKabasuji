package sinon.views.game;

import javax.swing.JButton;

import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class GameInfoView extends InfoPanel {

	public GameInfoView() {
		super();

		JButton btnRestart = new JButton("Restart\r\n");
		btnRestart.setBounds(45, 20, 100, 50);
		this.add(btnRestart);

		JButton btnExit = new JButton("Exit\r\n");
		btnExit.setBounds(45, 100, 100, 50);
		this.add(btnExit);

		JButton button_2 = new JButton("Next Level\r\n");
		button_2.setBounds(45, 180, 100, 50);
		this.add(button_2);
	}
}
