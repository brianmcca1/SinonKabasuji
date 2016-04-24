package sinon.main;

import java.util.LinkedList;

import sinon.controllers.BullpenController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.MainView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectView;

@SuppressWarnings("serial")
public class Game extends Kabasuji {
	
    /** Holds all the levels for the game. */
	public Level[] allLevels = new Level[15];

    public Game() {
        super();

        startSplash("Kabasuji", new LevelSelectView(this));
        currentLevel = new Level(5, new Board(), new BullPen(new LinkedList<Hexomino>())); //test level
    }
    
    /**
     * Called by the LevelStartController to open the MainView.
     * @param levelSelectView LevelSelectView to remove from the frame.
     */
    public void initializeMainView(LevelSelectView levelSelectView){
		this.setMainView(new MainView(new GameInfoView(this.getLevel()), this.getLevel()));
		this.startNextPanel(levelSelectView, this.getMainView());
    }

    public void initializeMainControllers() {
        GameInfoView sidePanel = (GameInfoView) mainView.getInfoPanel();
        sidePanel.getExitButton().addActionListener(new sinon.controllers.ExitGameController(this, mainView));
        mainView.getBullpenView().addMouseListener(new BullpenController(this.currentLevel.getBullpen(), mainView.getBullpenView(), this.currentLevel));
    }
   
    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Game game = new Game();
    }

}    
