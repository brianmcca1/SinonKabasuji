package sinon.models;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sinon.moves.MoveToBoardFromBullpen;

/**
 * This class is the test for seeing if we have met the milestones for the
 * Builder by 4/27.
 * 
 */
public class PuzzleIntegrationTest {

    PuzzleLevel exampleLevel;
    Board board;
    BullPen bullpen;

    @Before
    public void setup() {
        // Set up the board for the game.
        // It will be a 6x6 set of playable tiles in the top left.
        board = new Board();
        for (Tile t : board.getTiles()) {
            t.setPlayable(false);
        }
        for (int i = 0; i < 6; i++) {
            for (int z = 0; z < 6; z++) {
                board.getTile(i, z).setPlayable(true);
            }
        }

        // Set up the HexominoList for the bullpen.
        List<Hexomino> hexList = new LinkedList<Hexomino>();
        HexominoNumberSet sixByOne = NumberSetFactory.getByNumbers(0, 0, 0, 1,
                0, 2, 0, 3, 0, 4, 0, 5);
        for (int i = 0; i < 8; i++) {
            Hexomino hex = new Hexomino(sixByOne);
            hexList.add(hex);
        }

        bullpen = new BullPen(hexList);
        exampleLevel = new PuzzleLevel(board, bullpen, 8);
    }

    @Test
    public void testRunGame() {
        Hexomino hexToMove = bullpen.getPieces().get(0);
        exampleLevel.select(hexToMove);

        MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(exampleLevel,
                0, 0);
        assertTrue(move.valid());
        move.doMove();
        assertTrue(bullpen.pieces.size() == 7);
        assertTrue(board.getTile(new Point(0, 0)).getHexomino().get()
                .equals(hexToMove));
        assertTrue(
                board.getHexominoLocation(hexToMove).equals(new Point(0, 0)));
        assertTrue(exampleLevel.getMoves() == 1);

    }

}
