package sinon.moves;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.ReleaseBoard;
import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.models.ReleaseTile;
import sinon.models.data.LevelType;

public class AddReleaseNumberMoveTest {

	@Test
	public void test(){
	ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
	Level test = new Level(LevelType.Types.RELEASE, new ReleaseBoard(), new BullPen(bpList));
	ReleaseLevel testLevel = new ReleaseLevel(test);
	ReleaseNumber releaseNumber = new ReleaseNumber(Color.BLACK, 0);
	testLevel.selectReleaseNumber(releaseNumber);
	AddReleaseNumberMove move = new AddReleaseNumberMove(
			testLevel, (ReleaseTile) testLevel.getBoard().getTile(new Point(0,0)));
	
	assertTrue(move.doMove());
	assertTrue(move.undo());
}
	
}
