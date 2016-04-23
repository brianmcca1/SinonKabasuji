package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import sinon.main.Builder;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelData;
import sinon.models.data.LevelType;
import sinon.serial.Deserializer;
import sinon.views.builder.BuilderMenuBar;

public class BuilderOpenController implements ActionListener{
	
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

            //attempt to read LevelData from file
            LevelData levelData = new LevelData(LevelType.types.PUZZLE, new BoardData(), new BullPenData(), 1);
            
            //CREATE LEVEL FROM THE READ LEVELDATA HERE
            
            Deserializer deserializer = new Deserializer(file);
            boolean successful = deserializer.deserializeFile();
            
            this.builderMenuBar.mntmSave.setEnabled(true);
            this.builderMenuBar.mntmSaveAs.setEnabled(true);
            this.builderMenuBar.mntmUndo.setEnabled(true);
            this.builderMenuBar.mntmRedo.setEnabled(true);
            this.builderMenuBar.mntmClearBoard.setEnabled(true);
            if(successful) System.out.println("DESERIALIZER SUCCESSFULLY CREATED LEVELDATA FROM FILE");
            else System.out.println("DESERIALIZER FAILED");
        }
	}
}
