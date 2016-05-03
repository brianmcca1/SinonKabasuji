package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.models.Level;

/**
 * This is the controller that is responsible for redoing moves in the builder.
 *
 */
public class BuilderRedoController implements ActionListener {

	/** The level object associated with the redo.  */
	private Level level;

	/**
	 * Controller for redoing moves in the builder.
	 * 
	 * @param level
	 *            The level moves are being redone in.
	 */
	public BuilderRedoController(Level level) {
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.redo();
	}

}
