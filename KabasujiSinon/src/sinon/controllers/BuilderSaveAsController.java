package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import sinon.main.Builder;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelProperty;
import sinon.models.data.PuzzleLevelProperty;
import sinon.serial.Serializer;
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
            this.builder.setCurrentFile(file);

            //CREATE THE LEVELS BULLPENDATA AND SET IT
            BullPenData levelBullpenData = new BullPenData(this.builder.getLevel().getBullpen());
            this.builder.getLevel().getLevelData().setBullpenData(levelBullpenData);
            
            //CREATE THE LEVELS BOARDDATA AND SET IT
            BoardData levelBoardData = new BoardData(this.builder.getLevel().getBoard());
            this.builder.getLevel().getLevelData().setBoardData(levelBoardData);
            
            
            
            this.builder.getLevel().getLevelData().setLevelProperty(new PuzzleLevelProperty(5)); //TODO get real LevelProperty from views
            
            //GET LevelTypeInfoView value that was set (number of moves, time left)
            
            //this.builder.getLevel().getLevelData().setLevelProperty(new );
            System.out.println("LEVEL PROPERTY VALUE: " + this.builder.getMainView().getLevelTypeInfoView().getValue());
            
            
            /*
             * FIELDS TO SET:
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
             *     		int starRecord;							THIS IS USED BY THE GAME TO SAVE THE EARNED STARS
             * 			LevelProperty levelProperty;
             */

            Serializer serializer = new Serializer(file, this.builder.getLevel().getLevelData());
            serializer.serializeFile();
            
            this.builderMenuBar.mntmSave.setEnabled(true);
        }
	}
}
