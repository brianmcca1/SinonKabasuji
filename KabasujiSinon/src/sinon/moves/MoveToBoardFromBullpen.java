package sinon.moves;

import java.awt.Point;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;

/**
 * Move class for when moving hexomino to the board from the bullpen.
 * 
 * @author kartik
 *
 */
public class MoveToBoardFromBullpen extends BoardMove {

	/** BullPen from where we are moving hexomino to the board. */
	BullPen bullpen;
	/** Hexomino that is being moved. */
	Hexomino hex;
	/** Board that the hexomino is being added to. */
	Board board;
	Level level;

	/**
	 * This is the destination anchor-row for the hexomino. TODO We might not
	 * need this field eventually.
	 */
	int destAnchorRow;

	/**
	 * This the destination anchor-column for the hexomino. TODO We might not
	 * need this field eventually.
	 */
	int destAnchorColumn;

	public MoveToBoardFromBullpen(Level level, Hexomino hex, int destAnchorRow,
			int destAnchorColumn) {
		this.level = level;
		this.bullpen = level.getBullpen();
		this.board = level.getBoard();
		this.hex = hex;
		this.destAnchorRow = destAnchorRow;
		this.destAnchorColumn = destAnchorColumn;

	}

	@Override
	public boolean doMove() {
		try {
			this.board.addHexomino(new Point(destAnchorRow, destAnchorColumn),
					hex);
			this.bullpen.removeHexomino(hex);
			level.update();
			return true;
		} catch (Exception exception) {
			// FIXME don't use errors this way. See: for why
			// http://stackoverflow.com/questions/77127/when-to-throw-an-exception
			System.out.println("Couldn't add hexomino here!");
			return false;
		}

	}

	@Override
	public boolean undo() {
		this.board.removeHexomino(hex);
		this.bullpen.removeHexomino(hex);
		level.update();
		return true;
	}

	@Override
	public boolean valid() {
		return false;
	}

}
