package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.LevelData;
import sinon.models.data.LevelType.types;
import sinon.serial.Deserializer;
import sinon.views.LevelTypeInfoView;
import sinon.views.LightningInfoView;
import sinon.views.PuzzleInfoView;
import sinon.views.ReleaseInfoView;
import sinon.views.builder.BuilderMenuBar;

public class BuilderOpenController extends BuilderNewLevelController implements ActionListener{
	
	/** Overall Builder object*/
	private Builder builder;
	
	final JFileChooser fc = new JFileChooser();
	
	private BuilderMenuBar builderMenuBar;
	
	public BuilderOpenController(Builder b, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING OPEN CONTROLLER");
        int returnVal = fc.showOpenDialog(this.builder);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	
            File file = fc.getSelectedFile();
            this.builder.setCurrentFile(file);
            
            Deserializer deserializer = new Deserializer(file); 
            LevelData levelData = deserializer.deserializeFile();
           
            System.out.println("******************");
            System.out.println(levelData.toString());
	    	System.out.println("******************");
	    	
	    	//CREATE levelFromFile FROM levelData HERE
	    	Level levelFromFile = new Level(levelData.getLevelType(), new Board(levelData.getBoardData()), new BullPen(levelData.getBullpenData()));
	    	this.builder.setLevel(levelFromFile);

	    	//FIND OUT WHICH LevelTypeInfoView TO GIVE TO MAINVIEW
			LevelTypeInfoView lvlTypeInfoView = null;
			types thisLevelsType = levelData.getLevelType();
			
	        if(thisLevelsType.equals(types.PUZZLE)){
	        	lvlTypeInfoView = new PuzzleInfoView(true);
	    	}
	    	else{
	    		if(thisLevelsType.equals(types.LIGHTNING)){
	    			lvlTypeInfoView = new LightningInfoView(true);
	    		}
	    		else{
	    			if(thisLevelsType.equals(types.RELEASE)){
	    				lvlTypeInfoView = new ReleaseInfoView();
	    			}
	    		}
	    	}
	    	
            this.builder.initializeMainView(lvlTypeInfoView);
            this.handleOpenLevel(this.builderMenuBar);
        }
	}
	
	/**
	 * Sets the file options and then initializes the MainView.
	 * @param bMenuBar BuilderMenuBar used to set the appropriate file options.
	 */
	public void handleOpenLevel(BuilderMenuBar bMenuBar){
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(true);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
        bMenuBar.mntmClearBoard.setEnabled(true);
        this.builderMenuBar.mntmSave.setEnabled(true);
        this.builder.initializeMainView(new PuzzleInfoView(true)); //FIXME read the type of level and make the correct LevelTypeInfoView
        this.builder.mainView.getBullpenView().redrawBullpenView();
	}
}
