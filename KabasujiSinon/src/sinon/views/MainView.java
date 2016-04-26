package sinon.views;

import java.awt.Color;
import java.util.Objects;
import java.util.Optional;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sinon.models.Level;

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
	 * @param hasReleaseView
	 *            True if the MainView should have a ReleaseView showing.
	 */
	public MainView(Level level, InfoPanel infoPanel, boolean hasReleaseView) {
		if (hasReleaseView) {
			releaseButtonView = Optional.of(new ReleaseInfoView());
		} else {
			releaseButtonView = Optional.of(null);
		}
		this.level = Objects.requireNonNull(level);
		this.infoPanel = Objects.requireNonNull(infoPanel);
		this.bullpenView = new BullpenView(level.getBullpen());
		initializeViews();
	}

	public void logicForPanel() {
		this.infoPanel = infoPanel;

		/*
		 * if(this.kabasuji.getLevel().getLevelData().getLevelType().equals(types
		 * .PUZZLE)){ levelTypeInfoView = new PuzzleInfoView(true); } else{
		 * if(this
		 * .kabasuji.getLevel().getLevelData().getLevelType().equals(types
		 * .LIGHTNING)){ levelTypeInfoView = new LightningInfoView(true); }
		 * else{
		 * if(this.kabasuji.getLevel().getLevelData().getLevelType().equals
		 * (types.RELEASE)){ levelTypeInfoView = new ReleaseInfoView(); } }}
		 */
	}

	/** Initializes all of the components that make up this GUI. */
	void initializeViews() {
		this.setLayout(null);
		initGameAreaPanel();
		initLevelPanel();
		initBoardView();
		initReleaseButtonView();
		this.add(this.infoPanel);
		infoPanel.setBounds(LEVEL_PANEL_WIDTH, 0, 150, MAIN_PANEL_HEIGHT);
	}

	private void initReleaseButtonView() {
		if (releaseButtonView.isPresent())
			gameAreaPanel.add(releaseButtonView.get());
		/*
		 * This code was removed when merging branches. Doesn't seem useful.
		 * this.add(this.infoPanel); infoPanel.setBounds(LEVEL_PANEL_WIDTH, 0,
		 * 150, MAIN_PANEL_HEIGHT);
		 */
	}

	/**
	 * Creates the JPanel for the board and adds it to the
	 * {@link #gameAreaPanel}
	 */
	private void initBoardView() {
		BoardView newBoardView = new BoardView(level.getBoard());
		this.boardView = newBoardView;
		gameAreaPanel.add(newBoardView.boardPanel);
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

	/**
	 * Returns the info panel associated with this main view.
	 * 
	 * Typically you will have to cast this InfoPanel into whatever class you
	 * know it actually is. IE in the builder, cast this into a BankView.
	 * 
	 * @return InfoPanel of this MainView.
	 */
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
