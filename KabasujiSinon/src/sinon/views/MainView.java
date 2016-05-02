package sinon.views;

import java.util.Objects;

import javax.swing.JPanel;

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
    private LevelPanel levelPanel;
    
    /** Contains GridView and the Optional ReleaseButtonView. */
    private JPanel gameAreaPanel;
    
    /** This is the field responsible for holding information specific to each type of level. */
    private LevelTypeInfoView levelTypeInfoView;
    
    /** BankView/GameInfoView. */
    InfoPanel infoPanel;
    
    /** The level associated with this MainView. */
    Level level;
    
    /** The bullpenView object that mainView uses to render the bullpen. */
    BullpenView bullpenView;
    
    /** The BoardView object that mainView uses to render the board. */
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
        this.bullpenView = new BullpenView(level);
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
        levelPanel.setBounds(0, 0, LEVEL_PANEL_WIDTH, MAIN_PANEL_HEIGHT);
        this.add(levelPanel);
    }

    /**
     * Gets the BullpenView of this MainView
     * 
     * @return The BullpenView object of this level.
     */
    public BullpenView getBullpenView() {
        return this.bullpenView;
    }

    /**
     * Returns the InfoPanel associated with this MainView.
     * 
     * Don't confuse this with {@link #getLevelTypeInfoView()}.
     * 
     * @return This MainView's InfoPanel.
     */
    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    /** @return This MainView's LevelPanel. */
    public LevelPanel getLevelPanel() {
        return levelPanel;
    }

    /**
     * Returns the LevelTypeInfoView associated with this MainView.
     * 
     * Don't confuse this with {@link #getInfoPanel()}.
     * 
     * @return This MainView's LevelTypeInfoView.
     */
    public LevelTypeInfoView getLevelTypeInfoView() {
        return this.levelTypeInfoView;
    }

    /**
     * Returns the boardView that exists in the mainView. 
     * @return This MainView's BoardView.
     */
    public BoardView getBoardView() {
        return this.boardView;
    }

}
