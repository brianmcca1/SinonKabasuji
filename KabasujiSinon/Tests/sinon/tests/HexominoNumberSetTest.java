package sinon.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import sinon.models.HexominoNumberSet;

public class HexominoNumberSetTest {

    @Test
    public void test() {
        fail("Not yet implemented");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullSet() {
        HexominoNumberSet set = new HexominoNumberSet(null);
    }

}
