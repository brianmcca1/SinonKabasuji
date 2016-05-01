package sinon.views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sinon.main.Game;
import sinon.models.LightningLevel;
import sinon.views.game.LevelSelectView;

/**
 * The InfoView for a lightning level
 * 
 * @author Brian
 *
 */
public class LightningInfoView extends LevelTypeInfoView {

	private static final long serialVersionUID = 6687905039046766060L;
	public JLabel infoLabel;
	public JTextField timeLeftField;
	public LightningLevel level;
	public Game game;

	public LightningInfoView(boolean editable, LightningLevel level) {
		this.level = level;
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Time:");
		this.timeLeftField = new JTextField();

		if (!editable)
			this.timeLeftField.setEditable(false);
		else
			this.timeLeftField.setEditable(true);

		this.timeLeftField.setText(Integer.toString(level.getMaxTime()));
		this.add(infoLabel);
		this.add(timeLeftField);
	}

	public LightningInfoView(Game g, int time, LightningLevel lightningLevel) {
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Time:");
		this.timeLeftField = new JTextField();

		this.timeLeftField.setEditable(false);
		this.timeLeftField.setText(Integer.toString(time));

		this.level = lightningLevel;

		this.add(infoLabel);
		this.add(timeLeftField);
		
		this.game = g;
	}

	@Override
	public int getValue() {
		if (this.timeLeftField.getText().compareTo("") == 0) {
			return 1;
		}
		return Integer.parseInt(this.timeLeftField.getText());
	}

	/**
	 * Update the view to show how much time is left
	 */
	public void updateTimeLeft() {
		this.timeLeftField.setText(((Integer) level.getTimeLeft()).toString());
		
		if(this.level.getTimeLeft() <= 0){
			this.game.loadAllLevels();
			this.game.levelSelectView = new LevelSelectView(this.game);
			game.startNextPanel(this.game.getMainView(), this.game.levelSelectView);
		}
	}

}
