package sinon.models;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sinon.models.data.LevelType.types;

/**
 * This class is the test for seeing if we have met the milestones for the
 * Builder by 4/27.
 * 
 */
public class PuzzleIntegrationTest {

    Level exampleLevel;
    Board board;
    BullPen bullpen;

    @Before
    public void setup() {
        board = new Board();
        List<Hexomino> hexList = new LinkedList<Hexomino>();
        // TODO add the eight hexominos to the bullpen.
        bullpen = new BullPen(hexList);
        exampleLevel = new Level(types.PUZZLE, board, bullpen);
    }

    @Test
    public void testRunBuilder() {

    }

}
