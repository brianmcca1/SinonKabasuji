package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Game;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LightningLevelProperty;
import sinon.models.data.PuzzleLevelProperty;
import sinon.serial.Serializer;
import sinon.models.data.LevelType.types;
import sinon.views.game.LevelSelectView;

/**
 * This controller responds to actions with the exit button in the MainView.
 */
public class ExitGameController implements ActionListener {
	
	/** Top level game object to manipulate.*/
    Game game;

    /**
     * @param game Top level Game/Builder object.
     */
    public ExitGameController(Game game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("EXITING LEVEL #" + (this.game.getCurrentLevelNumber() + 1));
    	
        //CREATE THE LEVELS BULLPENDATA AND SET IT
        BullPenData levelBullpenData = new BullPenData(this.game.getLevel().getBullpen());
        this.game.getLevel().getLevelData().setBullpenData(levelBullpenData);
        
        //CREATE THE LEVELS BOARDDATA AND SET IT
        BoardData levelBoardData = new BoardData(this.game.getLevel().getBoard());
        this.game.getLevel().getLevelData().setBoardData(levelBoardData);
        
        //GET THIS LEVEL'S propertyValue
        types thisLevelsType = this.game.getLevel().getLevelData().getLevelType();
        int propertyValue = this.game.getMainView().getLevelTypeInfoView().getValue();
        
        //SET LevelProperty BASED ON LEVEL TYPE AND WHAT WAS ENTERED INTO THE VIEW
        switch(thisLevelsType){
        	case PUZZLE:
        		this.game.getLevel().getLevelData().setLevelProperty(new PuzzleLevelProperty(propertyValue));
        		break;
        	case LIGHTNING:
        		this.game.getLevel().getLevelData().setLevelProperty(new LightningLevelProperty(propertyValue));
        		break;
        }
       
        this.game.determineCurrentGameLevelFile();
        Serializer serializer = new Serializer(this.game.getCurrentFile(), this.game.getLevel().getLevelData());
        serializer.serializeFile();
        
        System.out.println("*************EXIT CONTROLLER*****************");
        System.out.println(this.game.getLevel().getLevelData().toString());
        System.out.println("*********************************************");
    	
        game.startNextPanel(this.game.mainView, new LevelSelectView(this.game));
    }

}
