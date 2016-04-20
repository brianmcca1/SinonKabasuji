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
import sinon.models.Level;

/**
 * This class controls the entirety of the Builder/Game Views;
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
    public static Kabasuji kabasuji;
    /**levelPanel contains: Bullpen, GridView, optional ReleaseButtonView, and is on the left side of the screen.*/
    private LevelPanel levelPanel;
    /**Contains GridView and the Optional ReleaseButtonView.*/
    private JPanel gameAreaPanel;
    private JPanel bullpenView;
    /**Only exists in Builder Mode and Release game play.*/
    private Optional<ReleaseButtonView> releaseButtonView;
    private InfoPanel infoPanel;
    public int levelNum;
    Level level;

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
    }
    
    /**
     * This function sets the currently opened level number.
     * @param num
     * 		Level number (1 to 15)
     */
    public void setLevelNum(int num){
    	this.levelNum = num;
    	System.out.println("MAINVIEW HAS RECOGNIZED LEVEL #" + this.levelNum);
    }

    /** Initializes all of the components that make up this GUI.*/
    private void initializeViews() {
        this.setLayout(null);

        initGameAreaPanel();
        initLevelPanel();
        //initBullpenView();
        initBoard();
        initReleaseButtonView();
        initGameInfoButtons();
        
        this.add(this.infoPanel);
        infoPanel.setBounds(LEVEL_PANEL_WIDTH, 0, 150, MAIN_PANEL_HEIGHT);
    }
    
    /** Get all the buttons from the infoView (all return null if in Builder mode).*/
    private void initGameInfoButtons(){
        JButton exitBtn = infoPanel.getExitButton();
        JButton restartBtn = infoPanel.getRestartButton();
        JButton nextLevelBtn = infoPanel.getNextLevelButton();
        if(exitBtn != null) exitBtn.addActionListener(new ExitGameController((Game) kabasuji, this)); 
        if(restartBtn != null) restartBtn.addActionListener(new RestartLevelController((Game) kabasuji, this));
        if(nextLevelBtn != null) nextLevelBtn.addActionListener(new NextLevelController((Game) kabasuji, this));
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
        BoardView tempBoard = new BoardView();
        gameAreaPanel.add(tempBoard.board);
    }

    /** Initializes the {@link #gameAreaPanel} */
    private void initGameAreaPanel() {
        gameAreaPanel = new JPanel();
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
