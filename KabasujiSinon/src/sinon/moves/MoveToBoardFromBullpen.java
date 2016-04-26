package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.Level;

import java.awt.Point;

import sinon.models.Board;
import sinon.models.BullPen;

/**
 * Move class for when moving hexomino to the board from the bullpen.
 * @author kartik
 *
 */
public class MoveToBoardFromBullpen extends BoardMove{

	/**
	 * This is the destination anchor-row for the hexomino.
	 * TODO We might not need this field eventually.
	 */
	int destAnchorRow;
	
	/**
	 * This the destination anchor-column for the hexomino.
	 * TODO We might not need this field eventually.
	 */
	int destAnchorColumn;
	
	public MoveToBoardFromBullpen (Level level, int destAnchorRow, int destAnchorColumn) {
		
		this.level = level;
		this.hex = level.selectedHexomino.get();
		this.hex = level.selectedHexomino.get();
		this.destAnchorRow = destAnchorRow;
		this.destAnchorColumn = destAnchorColumn;
	
	}
	
	@Override
	public boolean doMove() {
		
		if(!this.valid()) { return false; }
			
		Hexomino hex = level.selectedHexomino.get();	
		level.getBullpen().removeHexomino(hex);
		level.getBoard().addHexomino(new Point(destAnchorRow, destAnchorColumn), hex);
		return true;
		
	}

	@Override
	public boolean undo() {
		
		return false;
	}

	@Override
	public boolean valid() {
		
		if(level.hasSelected()) {
			Hexomino hex = level.selectedHexomino.get();
			return level.getBoard().canAddHexomino((new Point(destAnchorRow, destAnchorColumn)), hex);
		} else {
			return false;
		}
		
	}

}
