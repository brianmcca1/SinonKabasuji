package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LightningLevelProperty;
import sinon.models.data.PuzzleLevelProperty;
import sinon.models.data.LevelType.types;
import sinon.serial.Serializer;

public class BuilderSaveController implements ActionListener{

	private Builder builder;
	
	public BuilderSaveController(Builder b){
		this.builder = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING SAVE CONTROLLER");
		if(this.builder.getCurrentFile() != null){
			
            //CREATE THE LEVELS BULLPENDATA AND SET IT
            BullPenData levelBullpenData = new BullPenData(this.builder.getLevel().getBullpen());
            this.builder.getLevel().getLevelData().setBullpenData(levelBullpenData);
            
            //CREATE THE LEVELS BOARDDATA AND SET IT
            BoardData levelBoardData = new BoardData(this.builder.getLevel().getBoard());
            this.builder.getLevel().getLevelData().setBoardData(levelBoardData);
            
            //GET THIS LEVEL'S propertyValue
            types thisLevelsType = this.builder.getLevel().getLevelData().getLevelType();
            int propertyValue = this.builder.getMainView().getLevelTypeInfoView().getValue();
            
            //SET LevelProperty BASED ON LEVEL TYPE AND WHAT WAS ENTERED INTO THE VIEW
            if(thisLevelsType.equals(types.PUZZLE)){
            	this.builder.getLevel().getLevelData().setLevelProperty(new PuzzleLevelProperty(propertyValue));
            }
            else{
            	if(thisLevelsType.equals(types.LIGHTNING)){
            		this.builder.getLevel().getLevelData().setLevelProperty(new LightningLevelProperty(propertyValue));
            	}
            }
            
            System.out.println("*************SAVE CONTROLLER*****************");
            System.out.println(this.builder.getLevel().getLevelData().toString());
            System.out.println("*********************************************");

			
			Serializer serializer = new Serializer(this.builder.getCurrentFile(), this.builder.getLevel().getLevelData());
			serializer.serializeFile();
		}
	}
	
	
	
	
}
