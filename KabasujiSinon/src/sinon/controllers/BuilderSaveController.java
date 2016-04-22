package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;

public class BuilderSaveController implements ActionListener{

	private Builder builder;
	
	public BuilderSaveController(Builder b){
		this.builder = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING SAVE CONTROLLER");
		if(this.builder.getCurrentFile() != null){
			//FILE EXISTS AND IS READY TO BE SAVED TO
			//SET ALL this.builder.getCurrentLevel() FIELDS HERE
			//NOW SERIALIZE THE LEVEL'S LEVELDATA TO this.builder.getCurrentFile()
		}
	}
	
	
	
	
}
