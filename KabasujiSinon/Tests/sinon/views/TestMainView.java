package sinon.views;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.HexominoNumberSet;
import sinon.models.NumberSetFactory;
import sinon.models.PuzzleLevel;

public class TestMainView {

    /**
     * Initialized during {@link #setUp()}. Bullpen contains the hexomino
     * {@link #hex}, and the board is all playable except tile (1,1)
     */
    PuzzleLevel level;
    /** Single hexomino that is in the bullpen of all levels. */
    Hexomino hex;

    @Before
    public void setUp() throws Exception {
        Board board = new Board();
        List<Hexomino> bullpenList = new ArrayList<Hexomino>();
        HexominoNumberSet exHexSet = NumberSetFactory.getByNumbers(0, 0, 0, 1,
                0, 2, 0, 3, 0, 4, 0, 5);
        Hexomino exHex = new Hexomino(exHexSet);
        bullpenList.add(exHex);
        BullPen bullpen = new BullPen(bullpenList);
        level = new PuzzleLevel(board, bullpen, 10);
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
