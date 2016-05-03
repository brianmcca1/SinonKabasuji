package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import sinon.main.Builder;
import sinon.models.Level;
import sinon.models.ReleaseLevel;
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
	ArrayList<JButton> buttons = new ArrayList<JButton>(18);

	Builder builder;

	/**
	 * Used when opening or making a level in the builder
	 * 
	 * @param level
	 */
	public ReleaseInfoView(Level level, Builder builder) {
		super(level);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(6, 3, 2, 2));
		addButtons();
		this.builder = builder;
		this.level.registerObserver(this);
		this.level.getBoard().registerObserver(this);
	}

	/**
	 * Used when starting a level in the game
	 * 
	 * @param releaseNumbers
	 * @param level
	 */
	public ReleaseInfoView(ArrayList<ReleaseNumber> releaseNumbers, Level level) {
		super(level);
		setLayout(new GridLayout(6, 3, 2, 2));
		addButtons();
		this.level.registerObserver(this);
		this.level.getBoard().registerObserver(this);
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
					nextButton.setForeground(Color.RED);

				if (j == 1)
					nextButton.setForeground(Color.GREEN);

				if (j == 2)
					nextButton.setForeground(Color.ORANGE);

				this.add(nextButton);
				this.buttons.add(nextButton);

			}
		}
	}

	public boolean makeCollected(ReleaseNumber releaseNumber) {
		if (builder == null) {
			return false;
		}
		JButton selected = getButton(releaseNumber);
		if (selected == null) {
			return false;

		}
		selected.setEnabled(false);
		return true;
	}

	public boolean select(ReleaseNumber releaseNumber) {
		JButton selected = getButton(releaseNumber);
		if (selected == null) {
			return false;
		}
		selected.setBackground(Color.CYAN);
		return true;
	}

	public boolean deselect(ReleaseNumber releaseNumber) {
		JButton selected = getButton(releaseNumber);
		if (selected == null) {
			return false;
		}
		selected.setBackground(UIManager.getColor("Panel.background"));
		return true;
	}

	public boolean deselect(JButton button) {
		button.setBackground(UIManager.getColor("Panel.background"));
		return true;
	}

	private JButton getButton(ReleaseNumber releaseNumber) {

		for (JButton j : this.buttons) {
			if (j.getText().equals(Integer.toString(releaseNumber.getNumber()))) {

				if (j.getForeground().equals(releaseNumber.getColor())) {

					return j;
				} else if (j.getForeground().equals(Color.ORANGE) && releaseNumber.getColor().equals(Color.YELLOW)) {
					return j;
				}
			}

		}

		return null;
	}

	@Override
	public int getValue() {
		return -999;
	}

	@Override
	public void updated() {
		ReleaseLevel releaseLevel = (ReleaseLevel) this.level;
		if (!releaseLevel.hasSelectedReleaseNumber()) {
			for (JButton j : this.buttons) {
				deselect(j);
			}
		} else {
			select(releaseLevel.getSelectedReleaseNumber());
		}

		ArrayList<ReleaseNumber> collectedReleaseNumbers = (ArrayList<ReleaseNumber>) releaseLevel
				.collectedReleaseNumbers();

		for (ReleaseNumber r : collectedReleaseNumbers) {
			makeCollected(r);
		}

	}

	public Iterable<JButton> getAllButtons() {

		return buttons;
	}
}
