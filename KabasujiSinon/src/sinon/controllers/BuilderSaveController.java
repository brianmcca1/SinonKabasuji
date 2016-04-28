package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelProperty;
import sinon.models.data.LightningLevelProperty;
import sinon.models.data.PuzzleLevelProperty;
import sinon.models.data.LevelType.Types;
import sinon.serial.Serializer;

public class BuilderSaveController implements ActionListener{

	private Builder builder;
	
	public BuilderSaveController(Builder b){
		this.builder = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING SAVE CONTROLLER");
		
		if(FileHandler.currentFile != null){
			
            //GET THIS LEVEL'S propertyValue
            Types thisLevelsType = this.builder.getLevel().getLevelData().getLevelType();
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
            
            FileHandler.builderSaveLevelToFile(FileHandler.currentFile, this.builder.getLevel(), levelProp);
		}
	}
	
	
	
	
}
