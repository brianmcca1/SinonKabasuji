package sinon.views;

import java.awt.Color;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sinon.main.Kabasuji;

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

    /** Overall Game/Builder object. */
    Kabasuji kabasuji;
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

    /**
     * @param k
     *            Top level Game/Builder object.
     * @param infoPanel
     *            The InfoPanel to be displayed.
     */
    public MainView(Kabasuji k, InfoPanel infoPanel) {
        releaseButtonView = Optional.of(new ReleaseInfoView());
        this.infoPanel = infoPanel;
        this.kabasuji = k;
        this.kabasuji.bullpenView = new BullpenView(this.kabasuji);
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
        initGameInfoButtons();

        this.add(this.infoPanel);
        infoPanel.setBounds(LEVEL_PANEL_WIDTH, 0, 150, MAIN_PANEL_HEIGHT);
    }

    /**
     * Get all the buttons from the infoView (all return null if in Builder
     * mode).
     */
    @Deprecated
    private void initGameInfoButtons() {
        JButton exitBtn = infoPanel.getExitButton();
        JButton restartBtn = infoPanel.getRestartButton();
        JButton nextLevelBtn = infoPanel.getNextLevelButton();

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
        BoardView tempBoard = new BoardView(this.kabasuji,
                this.kabasuji.getLevel().getBoard());
        this.kabasuji.boardView = tempBoard;
        this.kabasuji.registerBoardViewControllers();
        gameAreaPanel.add(tempBoard.boardPanel);
    }

    /** Initializes the {@link #gameAreaPanel} */
    private void initGameAreaPanel() {
        gameAreaPanel = new JPanel();
        gameAreaPanel.setLayout(null);
    }

    /** Initializes the {@link #levelPanel} */
    private void initLevelPanel() {
        levelPanel = new LevelPanel(this.kabasuji.bullpenView, gameAreaPanel);
        levelPanel.setBorder(new LineBorder(new Color(255, 0, 0)));
        levelPanel.setBounds(0, 0, LEVEL_PANEL_WIDTH, MAIN_PANEL_HEIGHT);
        this.add(levelPanel);
    }

    public BullpenView getBullpenView() {
        return this.kabasuji.bullpenView;
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    public LevelPanel getLevelPanel() {
        return levelPanel;
    }

}
