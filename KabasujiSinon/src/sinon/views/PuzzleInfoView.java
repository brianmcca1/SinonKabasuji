package sinon.views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sinon.controllers.FileHandler;
import sinon.main.Game;
import sinon.models.PuzzleLevel;
import sinon.views.game.LevelSelectView;

/**
 * The InfoView for a puzzle level
 * 
 * @author Brian
 */
public class PuzzleInfoView extends LevelTypeInfoView implements Observer {

	private static final long serialVersionUID = -6047685525063166167L;
	/** Label containing "Moves:". */
	public JLabel infoLabel;
	/** Text Field for entering/displaying moves left. */
	public JTextField movesLeftField;
	/** The PuzzleLevel associated with this view. */
	public PuzzleLevel puzzleLevel;
	/** Top level Game. */
	public Game game;
	/** Fix for a problem with updateMovesMade being called 4 times. */
	private boolean wasCalled;

	/**
	 * Used by Builder only.
	 * 
	 * @param editable
	 *            If this text field should be editable or not.
	 * @param puzzleLevel
	 *            Current puzzle level in the builder.
	 */
	public PuzzleInfoView(boolean editable, PuzzleLevel puzzleLevel) {
		super(puzzleLevel);
		this.puzzleLevel = puzzleLevel;
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Moves:");
		this.movesLeftField = new JTextField();

		if (!editable)
			this.movesLeftField.setEditable(false);
		else
			this.movesLeftField.setEditable(true);

		this.movesLeftField.setText(Integer.toString(puzzleLevel.getMaxMoves()));
		this.add(infoLabel);
		this.add(movesLeftField);

		this.level.registerObserver(this);
	}

	/**
	 * Used by Game only.
	 * 
	 * @param g
	 *            Game object.
	 * @param numMoves
	 *            Number of moves this level stars with
	 * @param puzzleLevel
	 *            current PuzzleLevel
	 */
	public PuzzleInfoView(Game g, int numMoves, PuzzleLevel puzzleLevel) {
		super(puzzleLevel);
		this.puzzleLevel = puzzleLevel;
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Moves:");
		this.movesLeftField = new JTextField();

		this.movesLeftField.setEditable(false);
		this.movesLeftField.setText(Integer.toString(numMoves));

		this.add(infoLabel);
		this.add(movesLeftField);

		this.game = g;

		this.level.registerObserver(this);
		wasCalled = false;
	}

	/**
	 * @return The number of moves in the movesLeftField.
	 */
	@Override
	public int getValue() {
		if (this.movesLeftField.getText().compareTo("") == 0) {
			return 1;
		}

		return Integer.parseInt(this.movesLeftField.getText());
	}

	/**
	 * Update the view to show how many moves the player can make
	 */
	public void updateMovesMade() {
		if (this.game != null) {
			this.movesLeftField.setText(((Integer) puzzleLevel.getMovesLeft()).toString());

			if (wasCalled)
				return;
			if (this.puzzleLevel.getMovesLeft() <= 0) {
				wasCalled = true;
				FileHandler.setStarsOnExit(this.game.getLevel());
				this.game.loadAllLevels();
				this.game.determineUnlocking();
				this.game.levelSelectView = new LevelSelectView(this.game);
				this.game.startNextPanel(this.game.getMainView(), this.game.levelSelectView);
			}
		}
	}

	@Override
	public void updated() {
		updateMovesMade();
		this.repaint();
		this.revalidate();
	}

}
