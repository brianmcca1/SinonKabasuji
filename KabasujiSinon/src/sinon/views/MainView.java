package sinon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Optional;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * GameView is the GUI that shows the main screen of both gameplay and level
 * editing.
 * 
 * Shows GridView, the Optional ReleaseButtonView, the BullpenView, and the
 * InfoPanel.
 * 
 * @see InfoPanel
 */
@SuppressWarnings("serial")
public class MainView extends JPanel {

	/**
	 * levelPanel is a high level container, which has the Bullpen & the
	 * GridView & the optional ReleaseButtonView, and is on the left side of the
	 * screen.
	 */
	private JPanel levelPanel;
	/**
	 * The high level container which has the GridView and the Optional
	 * ReleaseButtonView
	 */
	private JPanel gameAreaPanel;
	private JPanel bullpenView;
	/** Will only exist in Builder Mode and Release game play */
	private Optional<ReleaseButtonView> releaseButtonView;
	private InfoPanel infoPanel;

	/**
	 * 
	 * @param infoPanel
	 *            The infoPanel to be displayed.
	 */
	public MainView(InfoPanel infoPanel) {
		releaseButtonView = Optional.of(new ReleaseButtonView());
		this.infoPanel = infoPanel;
		initializeViews();
	}

	/** Initializes all of the components that make up this GUI */
	private void initializeViews() {
		// Initialize the high level things that have to happen first
		this.setLayout(new BorderLayout(0, 0));
		initGameAreaPanel();
		initLevelPanel();

		// Initialize the other stuff
		initBullpenView();
		initBoard();
		initReleaseButtonView();
		// Adds info panel to the right
		this.add(this.infoPanel, BorderLayout.EAST);
	}

	private void initReleaseButtonView() {
		if (releaseButtonView.isPresent())
			gameAreaPanel.add(releaseButtonView.get());
	}

	/**
	 * Creates the JPanel for the board and adds it to the
	 * {@link #gameAreaPanel}
	 */
	private void initBoard() {
		JPanel tempBoard = new JPanel();
		tempBoard.setBounds(141, 26, 300, 298);
		tempBoard.setBackground(Color.BLACK);
		gameAreaPanel.add(tempBoard);
	}

	/** Initializes the {@link #gameAreaPanel} */
	private void initGameAreaPanel() {
		gameAreaPanel = new JPanel();
		gameAreaPanel.setPreferredSize(new Dimension(10, 300));
		gameAreaPanel.setLayout(null);
	}

	/**
	 * Initializes the bullpen (and scrollbar) and adds it to the
	 * {@link #levelPanel}
	 */
	private void initBullpenView() {
		levelPanel.add(new BullpenView());
	}

	/** Initializes the {@link #levelPanel} */
	private void initLevelPanel() {
		levelPanel = new LevelPanel(new BullpenView(), gameAreaPanel);
		levelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(levelPanel, BorderLayout.WEST);
	}
}
