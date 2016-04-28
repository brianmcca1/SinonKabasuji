package sinon.views;

import java.awt.Color;
import java.util.Objects;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sinon.models.Level;

/**
 * Highest level view class responsible for displaying a level.
 * 
 * This class controls the entirety of the Builder/Game Views; Shows GridView,
 * the Optional ReleaseButtonView, the BullpenView, and the InfoPanel.
 * 
 * @see InfoPanel
 */
@SuppressWarnings("serial")
public class MainView extends JPanel {
	static final int LEVEL_PANEL_WIDTH = 640;
	static final int MAIN_PANEL_HEIGHT = 545;

	/**
	 * levelPanel contains: Bullpen, GridView, optional ReleaseButtonView, and
	 * is on the left side of the screen.
	 */
	public LevelPanel levelPanel;
	/** Contains GridView and the Optional ReleaseButtonView. */
	public JPanel gameAreaPanel; // FIXME If this is only asthetic, get rid of
	// it.
	/** Only exists in Builder Mode and Release game play. */
	// Optional<ReleaseInfoView> releaseButtonView;
	public LevelTypeInfoView levelTypeInfoView;
	/** BankView/GameInfoView. */
	InfoPanel infoPanel;
	/** The level associated with this MainView. */
	Level level;
	BullpenView bullpenView;
	private BoardView boardView;

	/**
	 * @param k
	 *            Top level Game/Builder object.
	 * @param infoPanel
	 *            The InfoPanel to be displayed.
	 */
	public MainView(Level level, InfoPanel infoPanel,
			LevelTypeInfoView lvlTypeInfoView) {
		this.infoPanel = Objects.requireNonNull(infoPanel);
		this.levelTypeInfoView = Objects.requireNonNull(lvlTypeInfoView);
		this.level = Objects.requireNonNull(level);
		this.bullpenView = new BullpenView(level.getBullpen());
		initializeViews();
	}

	/** Initializes all of the components that make up this GUI. */
	public void initializeViews() {
		this.setLayout(null);

		initGameAreaPanel();
		initLevelPanel();
		initBoard();

		this.add(this.infoPanel);
		infoPanel.setBounds(LEVEL_PANEL_WIDTH, 0, 150, MAIN_PANEL_HEIGHT);
	}

	/**
	 * Creates the JPanel for the board and adds it to the
	 * {@link #gameAreaPanel}
	 */
	private void initBoard() {
		boardView = new BoardView(level.getBoard());
		gameAreaPanel.add(boardView.boardPanel);
	}

	/** Initializes the {@link #gameAreaPanel} */
	private void initGameAreaPanel() {
		gameAreaPanel = new JPanel();
		gameAreaPanel.setLayout(null);
		gameAreaPanel.add(this.levelTypeInfoView);
	}

	/** Initializes the {@link #levelPanel} */
	private void initLevelPanel() {
		levelPanel = new LevelPanel(this.bullpenView, gameAreaPanel);
		levelPanel.setBorder(new LineBorder(new Color(255, 0, 0)));
		levelPanel.setBounds(0, 0, LEVEL_PANEL_WIDTH, MAIN_PANEL_HEIGHT);
		this.add(levelPanel);
	}

	public BullpenView getBullpenView() {
		return this.bullpenView;
	}

	/** @return This MainView's InfoPanel. */
	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	/** @return This MainView's LevelPanel. */
	public LevelPanel getLevelPanel() {
		return levelPanel;
	}

	/** @return This MainView's LevelTypeInfoView. */
	public LevelTypeInfoView getLevelTypeInfoView() {
		return this.levelTypeInfoView;
	}

	public BoardView getBoardView() {
		return this.boardView;
	}

}
