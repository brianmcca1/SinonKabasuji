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
 * @see ReleaseInfoView
 */
@SuppressWarnings("serial")
public abstract class LevelTypeInfoView extends JPanel {
	Level level;

	/**
	 * Constructs a new level type info view wit the given level.
	 * @param level the level to be viewed.
	 */
	public LevelTypeInfoView(Level level) {

		this.level = level;
		this.setBounds(450, 26, 130, 300);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * gets the value of level type info.
	 * @return returns the value of this object.
	 */
	public abstract int getValue();

}
