package sinon.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import sinon.models.HexominoTest;

@RunWith(Suite.class)
@SuiteClasses({ HexominoNumberSetTest.class, HexominoTest.class,
        TestTile.class })
public class AllTests {

}
