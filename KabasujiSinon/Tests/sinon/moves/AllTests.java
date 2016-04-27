package sinon.moves;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBankToBullpen.class, TestMoveToBullpenFromBoard.class,
        TestMoveToBoardFromBullpen.class })
public class AllTests {

}
