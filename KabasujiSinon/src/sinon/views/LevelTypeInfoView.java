package sinon.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sinon.models.Level;

/**
 * This is the panel which displays extra info about the progress of a game, or
 * the editable fields for level specific properties.
 * 
 * @see LightningInfoView
 * @see PuzzleInfoView
 * @see ReleaseInfoView For example, the time left in a lightning level
 */
@SuppressWarnings("serial")
public abstract class LevelTypeInfoView extends JPanel {
	// TODO, shouldn't this be abstract?
	Level level;

	public LevelTypeInfoView() {

		this.setBounds(450, 26, 130, 300);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBackground(Color.LIGHT_GRAY);
	}

	public abstract int getValue();

}
