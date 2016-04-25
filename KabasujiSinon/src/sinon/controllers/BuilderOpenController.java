package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.HexominoBankData;
import sinon.models.data.LevelData;
import sinon.models.data.LevelType;
import sinon.serial.Deserializer;
import sinon.views.MainView;
import sinon.views.builder.BankView;
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
           
            //CREATE levelFromFile FROM levelData HERE
            //THEN SET levelFromFile TO BUILDER
            //THEN this.builder.initializeMainView();
            
            //Level levelFromFile= new Level(5, new Board(), new BullPen(new LinkedList<Hexomino>())); //test level
            
            //this.builder.setLevel(levelFromFile);
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
        this.builder.initializeMainView();

	}
}
