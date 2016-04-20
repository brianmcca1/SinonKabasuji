package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * This class is the panel that contains the eighteen release buttons. This will
 * be used for both the Builder and the Game Views. To change the size, change
 * the constant field {@link #BOUNDS}.
 * 
 * @author Josh Desmond
 */
@SuppressWarnings("serial")
public class ReleaseButtonView extends JPanel {

	/** The dimensions of the rectangle */
	private static final Rectangle BOUNDS = new Rectangle(500, 26, 130, 200);
	/** The number of buttons in the grid of buttons */
	private static final int NUMBER_OF_BUTTONS = 18;
	/** The list of 15 buttons */
	List<JButton> buttons = new ArrayList<JButton>(NUMBER_OF_BUTTONS);

	/**
	 * Create the panel.
	 */
	public ReleaseButtonView() {
		setBounds(BOUNDS);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(6, 3, 2, 2));
		addButtons();
	}

	/**
	 * Initializes fifteen buttons, adds them to this panel, and adds them to
	 * the field {@link #buttons}.
	 */
	private void addButtons() {
		for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
			JButton nextButton = new JButton("#");
			this.add(nextButton);
			this.buttons.add(nextButton);
		}
	}
}
