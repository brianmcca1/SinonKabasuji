package sinon.moves;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBankToBullpen.class, TestMoveToBoardFromBullpen.class,
        TestMoveToBullpenFromBoard.class })

public class AllTests {

}
