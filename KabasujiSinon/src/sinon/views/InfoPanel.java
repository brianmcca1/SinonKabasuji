package sinon.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * InfoPanel is an interface/abstract class which encapsulates different things
 * depending on whether you're in the builder or player mode.
 * 
 * @author Josh Desmond
 */
@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	/** Initializes the empty panel. */
	public InfoPanel() {
		this.setPreferredSize(new Dimension(180, 800));
		this.setMinimumSize(new Dimension(150, 800));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBackground(Color.green);
	}

}
