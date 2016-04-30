package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.models.Level;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller that is responsible for redoing moves in 
 * the builder.
 *
 */
public class BuilderRedoController implements ActionListener {

	private Level level;
	
	public BuilderRedoController(Level level){
		this.level = level;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		level.redo();		
	}

}
