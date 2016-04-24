package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import sinon.main.Builder;
import sinon.models.BullPen;
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
	
	private JPanel blankPanel;
	
	final JFileChooser fc = new JFileChooser();
	
	private BuilderMenuBar builderMenuBar;
	
	public BuilderOpenController(Builder b, JPanel bPanel, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.blankPanel = bPanel;
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
            
            //read LevelData from file
            LevelData levelData = deserializer.deserializeFile();
           
            //CREATE ALEVEL FROM levelData HERE
            //SET ALEVEL TO BUILDER
            
            startLevel(this.blankPanel, this.builder, this.builderMenuBar);
            this.builderMenuBar.mntmSave.setEnabled(true);
        }
	}
	
	public void startLevel(JPanel blankPanel, Builder builder, BuilderMenuBar bMenuBar){
		builder.startNextPanel(blankPanel, new MainView(new BankView(new BullPen(HexominoBankData.getHexominos())),this.builder.getLevel()));
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(true);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
        bMenuBar.mntmClearBoard.setEnabled(true);
	}
}
