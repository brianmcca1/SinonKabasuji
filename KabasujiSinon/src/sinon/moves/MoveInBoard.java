package sinon.moves;

import java.awt.Point;

import sinon.models.Level;

/**
 * Move class for moving a hexomino from one position in the board to the next.
 * 
 * @author kartik
 *
 */
public class MoveInBoard extends BoardMove {

    /** The source anchor row from which the move was made. */
    int srcAnchorRow;
    
    /** The source anchor column from which the move was made. */
    int srcAnchorColumn;

    /** The destination anchor row to which the hexomino is being moved. */
    int destAnchorRow;
    
    /** The destination anchor column to which the hexomino is being moved. */
    int destAnchorColumn;

    public MoveInBoard(Level level, int srcAnchorRow, int srcAnchorColumn,
            int destAnchorRow, int destAnchorColumn) {
    	
        this.level = level;
        
        //if the level has a hexomino that's selected, then set the hexomino field. 
        this.hex = level.getSelectedHexomino();

        this.srcAnchorRow = srcAnchorRow;
        this.srcAnchorColumn = srcAnchorColumn;
        this.destAnchorRow = destAnchorRow;
        this.destAnchorColumn = destAnchorColumn;

    }

    @Override
    public boolean doMove() {
    	//if the move was not valid, return immediately
        if (!valid())
            return false;
        
        level.incrementMoves();
        
        //remove the hexomino from the board.
        level.getBoard().removeHexomino(hex.get());
        
        //add the same hexomino at the new position.
        level.getBoard().addHexomino(new Point(destAnchorRow, destAnchorColumn), hex.get());
        level.deselect();
        return true;
    }

    @Override
    public boolean undo() {
        level.getBoard().removeHexomino(hex.get());
        level.getBoard().addHexomino(new Point(srcAnchorRow, srcAnchorColumn),
                hex.get());
        return true;
    }

    @Override
    public boolean valid() {
    	//if the level doesn't have something selected,  then move is invalid.
        if (!level.hasSelected())
            return false;
        
        //check if we can add the hexomino at the new position.
        if (!level.getBoard().canAddHexomino(new Point(destAnchorRow, destAnchorColumn), hex.get()))
            return false;
        
        //if the board doesn't actually have the hexomino then return false.
        if (!level.getBoard().hasHex(hex.get()))
            return false;
        
        return true;
    }

}
