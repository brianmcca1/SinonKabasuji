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
 *
 */
public class PuzzleInfoView extends LevelTypeInfoView implements Observer{

	private static final long serialVersionUID = -6047685525063166167L;
	public JLabel infoLabel;
	public JTextField movesLeftField;
	public PuzzleLevel level;
	public Game game;

	/**
	 * Used by Builder only.
	 * @param editable If this text field should be editable or not.
	 * @param level Current level in the builder.
	 */
	public PuzzleInfoView(boolean editable, PuzzleLevel level) {
		this.level = level;
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Moves:");
		this.movesLeftField = new JTextField();

		if (!editable)
			this.movesLeftField.setEditable(false);
		else
			this.movesLeftField.setEditable(true);

		this.movesLeftField.setText(Integer.toString(level.getMaxMoves()));
		this.add(infoLabel);
		this.add(movesLeftField);
		
		this.level.registerObserver(this);
	}

	/**
	 * Used by Game only.
	 * @param g Game object.
	 * @param numMoves Number of moves this level stars with
	 * @param level current PuzzleLevel
	 */
	public PuzzleInfoView(Game g, int numMoves, PuzzleLevel level) {
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Moves:");
		this.movesLeftField = new JTextField();

		this.movesLeftField.setEditable(false);
		this.movesLeftField.setText(Integer.toString(numMoves));

		this.add(infoLabel);
		this.add(movesLeftField);
		
		this.level = level;
		this.level.registerObserver(this);
		
		this.game = g;
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
		if(this.game != null){
			this.movesLeftField.setText(((Integer) level.getMovesLeft()).toString());
		
			if(this.level.getMovesLeft() <= 0){
				FileHandler.setStarsOnExit(this.game.getLevel());
				this.game.determineUnlocking();
				this.game.loadAllLevels();
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
