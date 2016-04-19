package sinon.views;

import java.awt.Color;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import sinon.controllers.ExitGameController;
import sinon.controllers.NextLevelController;
import sinon.controllers.RestartLevelController;
import sinon.main.Game;
import sinon.main.Kabasuji;

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
    static final int LEVEL_PANEL_WIDTH = 640;
    static final int MAIN_PANEL_HEIGHT = 545;
    
    /**Allows global access to top level MainView object.*/
    public static MainView mainView;
    /**Top level Game/Builder object.*/
    Kabasuji kabasuji;
    /**levelPanel contains: Bullpen, GridView, optional ReleaseButtonView, and is on the left side of the screen.*/
    private LevelPanel levelPanel;
    /**Contains GridView and the Optional ReleaseButtonView.*/
    private JPanel gameAreaPanel;
    private JPanel bullpenView;
    /**Only exists in Builder Mode and Release game play.*/
    private Optional<ReleaseButtonView> releaseButtonView;
    private InfoPanel infoPanel;


	/**
	 * @param k
	 * 			Top level Game/Builder object.
	 * @param infoPanel
	 * 			The InfoPanel to be displayed.
	 */
    public MainView(Kabasuji k, InfoPanel infoPanel) {
        releaseButtonView = Optional.of(new ReleaseButtonView());
        this.mainView = this;
        this.infoPanel = infoPanel; 
        this.kabasuji = k;
        initializeViews(); 
        
        //get all the buttons from the infoView (all return null if in the builder)
        JButton exitBtn = infoPanel.getExitButton();
        JButton restartBtn = infoPanel.getRestartButton();
        JButton nextLevelBtn = infoPanel.getNextLevelButton();
        if(exitBtn != null) exitBtn.addActionListener(new ExitGameController((Game) kabasuji, this)); 
        if(restartBtn != null) restartBtn.addActionListener(new RestartLevelController((Game) kabasuji, this));
        if(nextLevelBtn != null) nextLevelBtn.addActionListener(new NextLevelController((Game) kabasuji, this));
    }

    /** Initializes all of the components that make up this GUI.*/
    private void initializeViews() {
        this.setLayout(null);
        // Initialize the high level things that have to happen first
        // this.setLayout(new BorderLayout(0, 0));
        initGameAreaPanel();
        initLevelPanel();

        // Initialize the other stuff
        // initBullpenView();
        initBoard();
        initReleaseButtonView();
        // Adds info panel to the right
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
        JPanel tempBoard = new JPanel();
        tempBoard.setBounds(141, 26, 300, 298);
        tempBoard.setBackground(Color.BLACK);
        gameAreaPanel.add(tempBoard);
    }

    /** Initializes the {@link #gameAreaPanel} */
    private void initGameAreaPanel() {
        gameAreaPanel = new JPanel();
        // gameAreaPanel.setPreferredSize(new Dimension(10, 300));
        gameAreaPanel.setLayout(null);
    }

    /** Initializes the {@link #levelPanel} */
    private void initLevelPanel() {
        levelPanel = new LevelPanel(new BullpenView(), gameAreaPanel);
        levelPanel.setBorder(new LineBorder(new Color(255, 0, 0)));
        levelPanel.setBounds(0, 0, LEVEL_PANEL_WIDTH, MAIN_PANEL_HEIGHT);
        this.add(levelPanel);
    }
}
