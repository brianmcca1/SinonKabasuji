package sinon.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import sinon.moves.MoveToBoardFromBullpen;

@Deprecated // DON'T WORRY ABOUT THIS CLASS FOR A LITTLE BIT. LETS BUILD THE
            // BOARD AND SETUP THE BULLPEN VIA THE BUILDER APPLICATION AYE?
public class PuzzleIntegrationTest {
    PuzzleLevel level;
    int movesLeft;
    private ModelIntegrationTest m;

    @Before
    public void setUp() {
        movesLeft = 8;
        m = new ModelIntegrationTest();
        level = new PuzzleLevel(m.getBoard(), m.getBullpen(), movesLeft);
    }

    @Test
    public void testRun() {
        System.out.println(m.hex1);
        doMove(1, m.hex1);
        System.out.println(m.hex2);
        doMove(2, m.hex2);

        System.out.println(m.hex1.getNormalizedPoints());
        System.out.println(m.hex2.getNormalizedPoints());
        assertTrue(m.hex1.hexominoNumberSet.equals(m.hex2));

        for (Tile t : level.getBoard().getTiles()) {
            // System.out.println(t);
        }
        doMove(3, m.hex3);
    }

    private void doMove(int i, Hexomino hex) {
        int movesRemainingPre = level.getMovesLeft();
        level.select(hex);
        MoveToBoardFromBullpen move = m.getMove(level, i);
        assertEquals(level.getSelectedHexomino().get(), hex);
        assertTrue(move.valid());
        assertTrue(move.doMove());
        assertEquals(movesRemainingPre, 1 + level.getMovesLeft());
        Point pos = new Point(move.getDestRow(), move.getDestColumn());
        Tile t = level.getBoard().getTile(pos);
        if (hex.getHexominoNumberSet().getPoints().contains(new Point(0, 0))) {
            assertTrue(t.getHexomino().get().equals(hex));
        }
    }
}
