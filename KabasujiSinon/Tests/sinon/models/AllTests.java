package sinon.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HexominoNumberSetTest.class, HexominoTest.class, LightningIntegrationTest.class,
		SimplePuzzleIntegrationTest.class, TestBoard.class, TestBullpen.class, TestLevel.class, TestLightingLevel.class,
		TestTile.class })
public class AllTests {

}
