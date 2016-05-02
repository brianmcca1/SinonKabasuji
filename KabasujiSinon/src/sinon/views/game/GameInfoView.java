package sinon.views.game;

import java.awt.Dimension;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JPanel;

import sinon.controllers.FileHandler;
import sinon.models.Level;
import sinon.views.InfoPanel;
import sinon.views.Observer;

/**
 * The JPanel that appears on the right side only in Game mode.
 */
@SuppressWarnings("serial")
public class GameInfoView extends InfoPanel implements Observer {

	/** Top level game object to manipulate. */
	Level level;
	/** Button to exit the level. */
	JButton exitButton;
	/** This level's StarView to represent the earned stars. */
	StarView starView;

	/**
	 * @param l
	 *            The top level Game object.
	 */
	public GameInfoView(Level l) {
		super();

		this.level = Objects.requireNonNull(l);

		JButton btnExit = new JButton("Exit Level\r\n");
		btnExit.setPreferredSize(new Dimension(120, 30));
		this.add(btnExit);
		this.exitButton = btnExit;

		this.level.registerObserver(this);

		this.addNewStarView(new StarView("/images/0star.png", this.level));
	}

	/** @return Returns the JButton object for the exit button. */
	public JButton getExitButton() {
		return this.exitButton;
	}

	/** @return Returns the StarView object. */
	public JPanel getStarView() {
		return this.starView;
	}

	/**
	 * Removes the current StarView and then adds the new StarView and redraws
	 * this.
	 * 
	 * @param sv
	 *            New StarView to replace old StarView
	 */
	private void addNewStarView(StarView sv) {
		if (this.starView != null) {
			this.remove(starView);
		}
		this.starView = sv;
		this.add(this.starView);
		this.starView.starLabel.repaint();
		this.starView.starLabel.revalidate();
		this.repaint();
		this.revalidate();
	}

	/**
	 * Creates a new StarView to represent the number of stars this level has currently earned.
	 * @param starsEarned The number of stars this level has currently earned.
	 */
	public void setStars(int starsEarned) {
		StarView sv = new StarView(FileHandler.determineFileStringForStars(starsEarned), this.level);
		this.addNewStarView(sv);
	}

	@Override
	public void updated() {
		this.setStars(this.level.countStars());
	}
}
