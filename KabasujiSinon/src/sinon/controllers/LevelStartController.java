package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Game;
import sinon.models.data.LevelType.types;
import sinon.views.LevelTypeInfoView;
import sinon.views.LightningInfoView;
import sinon.views.MainView;
import sinon.views.PuzzleInfoView;
import sinon.views.ReleaseInfoView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectButtonView;
import sinon.views.game.LevelSelectView;

/**
 * This controller responds to actions with a LevelSelectButtonView and will
 * removes the LevelSelectView from the frame and adds MainView to the frame.
 */
public class LevelStartController implements ActionListener{

	/** LevelSelectView to be removed from the frame. */
    LevelSelectView levelSelectView;
    /** The level number that this button corresponds to (0-14). */
    int levelNum;
    /** Top level Game object. */
    Game game;

    /**
     * @param g
     * 		Top level Game/Builder object
     * @param view
     * 		LevelSelectView to be removed from the frame
     */
    public LevelStartController(Game g, LevelSelectView v, int num) {
        this.levelSelectView = v;
        this.levelNum = num;
        this.game = g;
    }

	@Override
	/**
	 * Response to a LevelSelectButtonView being clicked
	 * Calls on Game to start the MainView
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("STARTING LEVEL #" + (levelNum + 1));
		this.game.setLevel(this.game.allLevels[this.levelNum]);
		
		LevelTypeInfoView lvlTypeInfoView = null;
		
        if(this.game.getLevel().getLevelData().getLevelType().equals(types.PUZZLE)){
        	lvlTypeInfoView = new PuzzleInfoView(false);
    	}
    	else{
    		if(this.game.getLevel().getLevelData().getLevelType().equals(types.LIGHTNING)){
    			lvlTypeInfoView = new LightningInfoView(false);
    		}
    		else{
    			if(this.game.getLevel().getLevelData().getLevelType().equals(types.RELEASE)){
    				lvlTypeInfoView = new ReleaseInfoView();
    			}
    		}
    	}
		
		this.game.allLevels[0].getLevelData().getLevelType();
		this.game.initializeMainView(this.levelSelectView, lvlTypeInfoView);
		
		
	}
	
}
