package sinon.main;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import sinon.controllers.BuilderTileController;
import sinon.controllers.BullpenController;
import sinon.controllers.GameTileController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.data.LevelData;
import sinon.models.data.LevelType.types;
import sinon.serial.Deserializer;
import sinon.views.LevelTypeInfoView;
import sinon.views.MainView;
import sinon.views.TileView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectView;

@SuppressWarnings("serial")
public class Game extends Kabasuji {
	
    /** Holds all the levels for the game. */
	public Level[] allLevels = new Level[15];

    public Game() {
        super();

        startSplash("Kabasuji", new LevelSelectView(this));

        
        //OPEN ALL 15 LEVELS AND STORE THEM IN THE ARRAY
        File levelOneFile = new File("level1.dat");
        Deserializer deserializer = new Deserializer(levelOneFile);
        LevelData levelOneData = deserializer.deserializeFile();

        Level levelOne = new Level(levelOneData.getLevelType(), new Board(levelOneData.getBoardData()), new BullPen(levelOneData.getBullpenData())); 
        levelOne.setLevelData(levelOneData);
        
        allLevels[0] = levelOne;
        this.setCurrentLevelNumber(0);
        
        System.out.println("LEVELONE READ INTO GAME");
    }
    
    /**
     * Called by the LevelStartController to open the MainView.
     * @param levelSelectView LevelSelectView to remove from the frame.
     */
    public void initializeMainView(LevelSelectView levelSelectView, LevelTypeInfoView lvlTypeInfoView){
		if(this.mainView != null){
			this.remove(this.mainView);
			this.revalidate();
		}
		this.setMainView(new MainView(this, new GameInfoView(this.getLevel()), lvlTypeInfoView));
		this.startNextPanel(levelSelectView, this.getMainView());
    }

    public void initializeMainControllers() {
		if(this.mainView != null){
			this.remove(this.mainView);
			this.revalidate();
		}
        GameInfoView sidePanel = (GameInfoView) mainView.getInfoPanel();
        sidePanel.getExitButton().addActionListener(new sinon.controllers.ExitGameController(this, mainView));
        mainView.getBullpenView().addMouseListener(new BullpenController(this.currentLevel.getBullpen(), mainView.getBullpenView(), this.currentLevel));
    }
    
    /** Registers the GameTileControllers to each TileView in the Game's BoardView. */
    public void registerBoardViewControllers(){
    	//apply GameTileControllers here
    	ArrayList<TileView> tileViews = (ArrayList<TileView>)this.boardView.getTileViews();
		
		for(int i = 0; i < tileViews.size(); i++){
			tileViews.get(i).addMouseListener(new GameTileController(this, this.currentLevel, tileViews.get(i)));
		}
    }
    
    /** @return Level object from the specified index in the allLevels array. */
    public Level getLevel(int index){
    	return this.allLevels[index];
    }
    
    
    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Game game = new Game();
    }


}    
