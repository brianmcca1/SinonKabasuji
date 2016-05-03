package sinon.controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import sinon.models.Level;

/**
 * This is the controller in charge of undoing moves in the builder.
 * @author kartik
 *
 */
public class BuilderUndoController implements ActionListener {

	private Level level;

	public BuilderUndoController(Level level) {
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.undo();
	}

}
