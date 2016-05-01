package sinon.views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sinon.models.PuzzleLevel;

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

	public PuzzleInfoView(int numMoves, PuzzleLevel level) {
		setLayout(new GridLayout(1, 1));
		this.infoLabel = new JLabel("Moves:");
		this.movesLeftField = new JTextField();

		this.movesLeftField.setEditable(false);
		this.movesLeftField.setText(Integer.toString(numMoves));

		this.add(infoLabel);
		this.add(movesLeftField);
		
		this.level = level;
		this.level.registerObserver(this);
	}

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
		System.out.println("UPDATING MOVES MADE");
		this.movesLeftField.setText(((Integer) level.getMovesLeft()).toString());
	}

	@Override
	public void updated() {
		this.repaint();
		this.revalidate();
	}

}
