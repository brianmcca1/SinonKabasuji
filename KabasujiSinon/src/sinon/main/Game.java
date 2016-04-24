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

	/** Game's knowledge of the level. */
    Level level;
	/** Builder's knowledge of the mainView */
    MainView mainView;

    public Game() {
        super();

        startSplash("Kabasuji", new LevelSelectView(this));
        level = new Level(5, new Board(), new BullPen(new LinkedList<Hexomino>()));
    }



    public void initializeMainControllers() {
        GameInfoView sidePanel = (GameInfoView) mainView.getInfoPanel();
        sidePanel.getExitButton().addActionListener(new sinon.controllers.ExitGameController(this, mainView));
        mainView.getBullpenView().addMouseListener(new BullpenController(this.level.getBullpen(), mainView.getBullpenView(), this.level));
    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Game game = new Game();
    }
    
    public void setMainView(MainView m){ this.mainView = m;}
    
    public Level getLevel(){ return this.level;}
    
    public MainView getMainView(){ return this.mainView;}
}    
