package sinon.views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sinon.controllers.FileHandler;
import sinon.main.Game;
import sinon.models.LightningLevel;
import sinon.views.game.LevelSelectView;

/**
 * Class that encapsulates the specific graphic elements
 * that are exclusive to a lightning level like the timeLeft.
 * 
 * @author Brian
 *
 */
public class LightningInfoView extends LevelTypeInfoView {

	private static final long serialVersionUID = 6687905039046766060L;
	
	/** The label that describes the graphic. */
	public JLabel infoLabel;
	
	/** Text field for displaying/inputting the time left. */
	public JTextField timeLeftField;
	
	/** Lightning level object associated with this view. */
	public LightningLevel level;
	
	/** The game that is associated with this particular infoView. */
	public Game game;

	/** Constructor for lightning infoView. It has to take in a boolean
	 * indicating whether it is editable and a lightning level model object.
	 * @param editable
	 * @param level
	 */
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

	/** This is constructor used for instantiating the lightning info View
	 * in a game. 
	 * @param g The game that is associated with this particular infoView.
	 * @param time The time that is left in the level.
	 * @param lightningLevel The lightning level class.
	 */
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
			FileHandler.setStarsOnExit(this.game.getLevel());
			this.game.loadAllLevels();
			this.game.determineUnlocking();
			this.game.levelSelectView = new LevelSelectView(this.game);
			this.game.startNextPanel(this.game.getMainView(), this.game.levelSelectView);
		}
	}

}
