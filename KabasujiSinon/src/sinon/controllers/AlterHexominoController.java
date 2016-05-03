package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.HexominoBullpenView;

/**
 * Super class for all bullpen hexomino controllers.
 * 
 * Anything that sub classes this should specify the class type of the move that
 * their controller is going to create.
 * 
 * @author Josh Desmond
 */
public abstract class AlterHexominoController implements ActionListener {

	/** This is the hexomino view that is being flipped. */
	HexominoBullpenView hexView;
	
	/** This is the level for the move to be pushed to. */
	Level level;
	
	/** Hexomino being edited. */
	protected Hexomino hexomino;

	/**
	 * Creates a new Flip Hexomino Controller.
	 * 
	 * @param level Level to alter the hexomino of.
	 * @param hexomino
	 *            Hexomino view to be registered.
	 */
	public AlterHexominoController(Level level, HexominoBullpenView hexomino) {
		Objects.requireNonNull(hexomino);
		Objects.requireNonNull(level);
		this.hexView = hexomino;
		this.hexomino = new Hexomino(hexomino.getHexomino().getHexominoNumberSet());
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handleAction();
	}

	/**
	 * This should create the move.
	 */
	protected abstract void handleAction();
}
