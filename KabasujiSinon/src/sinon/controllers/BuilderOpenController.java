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

public class BuilderOpenController implements ActionListener{
	
	/** Overall Builder object*/
	private Builder builder;
	
	final JFileChooser fc = new JFileChooser();
	
	public BuilderOpenController(Builder b){
		this.builder = b;
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
            
            if(successful) System.out.println("DESERIALIZER SUCCESSFULLY CREATED LEVELDATA FROM FILE");
            else System.out.println("DESERIALIZER FAILED");
        }
	}
}
