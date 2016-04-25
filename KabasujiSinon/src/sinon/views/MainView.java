package sinon.views;

import java.awt.Color;
import java.util.Optional;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.HexominoBankData;

/**
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
	LevelPanel levelPanel;
	/** Contains GridView and the Optional ReleaseButtonView. */
	JPanel gameAreaPanel; // FIXME If this is only asthetic, get rid of it.
	/** Only exists in Builder Mode and Release game play. */
	Optional<ReleaseInfoView> releaseButtonView;
	/** BankView/GameInfoView. */
	InfoPanel infoPanel;
	/** Knowledge of the BullpenView. */
	BullpenView bullpenView;
	/** Knowledge of the BoardView. */
	BoardView boardView;
	private Level level;

	/**
	 * @param k
	 *            Top level Game/Builder object.
	 * @param infoPanel
	 *            The InfoPanel to be displayed.
	 */
	public MainView(Level level, InfoPanel infoPanel) {
		releaseButtonView = Optional.of(new ReleaseInfoView());
		this.level = level;
		this.infoPanel = infoPanel;
		// TODO move below line to proper location.
		// FIXME this is a temp change for testing
		// this.bullpenView = new BullpenView(level.getBullpen());
		this.bullpenView = new BullpenView(new BullPen(HexominoBankData.getHexominos()));
		initializeViews();
	}

	/** Initializes all of the components that make up this GUI. */
	public void initializeViews() {
		this.setLayout(null);

		initGameAreaPanel();
		initLevelPanel();
		// initBullpenView();
		initBoard();
		initReleaseButtonView();

		this.add(this.infoPanel);
		infoPanel.setBounds(LEVEL_PANEL_WIDTH, 0, 150, MAIN_PANEL_HEIGHT);
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
		BoardView tempBoard = new BoardView(level.getBoard());
		this.boardView = tempBoard;
		gameAreaPanel.add(tempBoard.boardPanel);
	}

	/** Initializes the {@link #gameAreaPanel} */
	private void initGameAreaPanel() {
		gameAreaPanel = new JPanel();
		gameAreaPanel.setLayout(null);
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

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public LevelPanel getLevelPanel() {
		return levelPanel;
	}

	public BoardView getBoardView() {
		return boardView;
	}

}
