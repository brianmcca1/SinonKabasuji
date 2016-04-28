package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import sinon.main.Builder;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.types;
import sinon.models.data.LightningLevelProperty;
import sinon.models.data.PuzzleLevelProperty;
import sinon.views.builder.BuilderMenuBar;

/**
 * This class responds to the "Save As" option in the Builder and opens a Save As menu, and saves
 * the currently built Level to a chosen file.
 * @author Kyle
 */
public class BuilderSaveAsController implements ActionListener{

	/** Overall Builder object*/
	private Builder builder;
	
	final JFileChooser fc = new JFileChooser();
	
	private BuilderMenuBar builderMenuBar;
	
	public BuilderSaveAsController(Builder b, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}
	
	/**
	 * Responds to a click on the "Save As" JMenuItem.
	 * Will then open a JFileChooser and allow the user to select a file to save this level to
	 * When "Save" is clicked on the JFileChooser, it will attempt to serialize a LevelData to the
	 * selected file/filename in the selected directory with the level currently built in the builder.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING SAVE AS CONTROLLER");
        int returnVal = fc.showSaveDialog(this.builder);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	
            File file = fc.getSelectedFile();
            FileHandler.currentFile = file;
            
            //GET THIS LEVEL'S propertyValue
            types thisLevelsType = this.builder.getLevel().getLevelData().getLevelType();
            int propertyValue = this.builder.getMainView().getLevelTypeInfoView().getValue();
            LevelProperty levelProp = null;
            
            switch(thisLevelsType){
	            case PUZZLE:
	            	levelProp = new PuzzleLevelProperty(propertyValue);
	            	this.builder.getLevel().getLevelData().setLevelProperty(new PuzzleLevelProperty(propertyValue));
	            	break;
	            case LIGHTNING:
	            	levelProp = new LightningLevelProperty(propertyValue);
	            	this.builder.getLevel().getLevelData().setLevelProperty(new LightningLevelProperty(propertyValue));
	            	break;
	            case RELEASE:
	            	break;
            }
            
            FileHandler.builderSaveLevelToFile(file, this.builder.getLevel(), levelProp);
            
            this.builderMenuBar.mntmSave.setEnabled(true);
        }
	}
}
     
/*
 * FIELDS TO SET FOR LEVEL
 * this.builder.getLevel()
 * 		int levelNum;								DONE
 * 		Board board;								DONE?
 * 			Map<Point, Tile> tilesViaPoints;		DONE?
 * 		BullPen bullpen;							DONE
 * 			List<Hexomino> pieces;					DONE
 *      int stars;									DONE
 *		int starRecord;								DONE
 * 		LevelData levelData;						DONE
 * 			types levelType;						DONE
 * 			int levelNum;							DONE
 * 			BoardData boardData;					DONE
 * 				boolean[][] playable;				DONE
 * 			BullPenData bullpenData;				DONE
 * 				ArrayList<HexominoCode> hexominos;  DONE
 *     		int starRecord;							DONE (THIS IS SET BY THE GAME TO SAVE THE EARNED STARS)
 * 			LevelProperty levelProperty;			DONE
 */