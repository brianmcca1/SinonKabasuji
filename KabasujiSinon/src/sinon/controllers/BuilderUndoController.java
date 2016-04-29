package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.models.Level;

public class BuilderUndoController implements ActionListener {

	private Level level;
	
	public BuilderUndoController(Level level){
		this.level = level;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Gotem");
		level.undo();
	}

}
