package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import sinon.models.ReleaseNumber;

/**
 * This class is the panel that contains the eighteen release buttons.
 * 
 * This will be used for both the Builder and the Game Views.
 * 
 * @author Josh Desmond
 */
public class ReleaseInfoView extends LevelTypeInfoView implements Observer {

	private static final long serialVersionUID = -7158712755823785281L;
	/** The list of 15 buttons */
	List<JButton> buttons = new ArrayList<JButton>(18);

	public ReleaseInfoView() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(6, 3, 2, 2));
		addButtons();
	}

	public ReleaseInfoView(ArrayList<ReleaseNumber> releaseNumbers) {
		// setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(6, 3, 2, 2));
		addButtons();
	}

	/**
	 * Initializes fifteen buttons, adds them to this panel, and adds them to
	 * the field {@link #buttons}.
	 */
	private void addButtons() {
		for (int j = 0; j < 3; j++) {
			for (int i = 1; i <= 6; i++) {
				JButton nextButton = new JButton(Integer.toString(i));

				if (j == 0)
					nextButton.setForeground(Color.red);
				if (j == 1)
					nextButton.setForeground(Color.green);
				if (j == 2)
					nextButton.setForeground(Color.ORANGE);

				this.add(nextButton);
				this.buttons.add(nextButton);
			}
		}
	}

	// TODO: complete this
	public ArrayList<ReleaseNumber> getReleaseSets() {
		return null;
	}

	@Override
	public int getValue() {
		return -999;
	}

	@Override
	public void updated() {
		// TODO Auto-generated method stub

	}

	public Iterable<JButton> getAllButtons() {

		return buttons;
	}
}
