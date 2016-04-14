package sinon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * GameView is a GUI that shows the GridView, it shows the Optional
 * ReleaseButtonView, the BullpenView, and the InfoPanel on the right. InfoPanel
 * is an interface/abstract class which encapsulates different things depending
 * on whether you're in the builder or player mode.
 */
public class MainView extends JPanel {
    /**
     * levelPanel is a high level container, which has the Bullpen & the
     * GridView & the optional ReleaseButtonView, and is on the left side of the
     * screen.
     */
    private JPanel levelPanel;
    private JPanel bullpenView;
    /**
     * The high level container which has the GridView and the Optional
     * ReleaseButtonView
     */
    private JPanel gameAreaPanel;
    /**
     * The 3 by 6 grid of buttons representing the release tiles. Is used in
     * different ways in the builder and in game play.
     */
    private Optional<ReleaseButtonView> releaseButtonView;

    public MainView(InfoPanel infoPanel) {
        releaseButtonView = Optional.of(new ReleaseButtonView());
        initializeViews();
        initializeControllers();
        setInfoPanel(infoPanel);
    }

    private void initializeViews() {
        // Initialize the high level things that have to happen first
        initDimensions();
        initLevelPanel();
        initGameAreaPanel();

        // Initialize the other stuff
        initBullpenView();
        initBoard();
        initReleaseButtonView();

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

    private void initGameAreaPanel() {
        gameAreaPanel = new JPanel();
        gameAreaPanel.setPreferredSize(new Dimension(10, 300));
        levelPanel.add(gameAreaPanel, BorderLayout.CENTER);
        gameAreaPanel.setLayout(null);
    }

    /** Initializes the bullpen (and scrollbar) and adds it to the level view */
    private void initBullpenView() {

        levelPanel.add(new BullpenView(), BorderLayout.NORTH);
    }

    /** Initializes the {@link #levelPanel} */
    private void initLevelPanel() {
        levelPanel = new JPanel();
        levelPanel.setPreferredSize(new Dimension(605, 10));
        levelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.add(levelPanel, BorderLayout.WEST);
        levelPanel.setLayout(new BorderLayout(0, 0));
    }

    private void initDimensions() {
        this.setMinimumSize(new Dimension(800, 600));
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout(0, 0));
    }

    private void initializeControllers() {
        // TODO Auto-generated method stub

    }

    private void setInfoPanel(InfoPanel infoPanel) {
        this.add(infoPanel, BorderLayout.EAST);
    }

    private void addExampleHexominos() {
        JButton exampleBullpenHexominoButton = new JButton("");
        exampleBullpenHexominoButton.setBounds(22, 6, 150, 149);
        bullpenView.add(exampleBullpenHexominoButton);
    }
}
