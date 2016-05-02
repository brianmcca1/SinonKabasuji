package sinon.views;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sinon.models.LightningLevel;

public class TestLightningInfoView {

    /** Pretty basic LightningLevel setup in the {@link #setUp()} method. */
    LightningLevel level;

    @Before
    public void setUp() throws Exception {
        level = LightningLevel.getExampleLevel();
    }

    @Test
    public void testCreateLightningInfoView() {
        LightningInfoView v = new LightningInfoView(false, level);
        assertNotNull(v.infoLabel);
        assertTrue(v.infoLabel.isVisible());
        assertTrue(v.level.equals(level));
        assertTrue(v.getComponents().length > 0);
    }

    @Test
    public void testEditable() {
        LightningInfoView vNonEdit = new LightningInfoView(false, level);
        assertTrue(vNonEdit.timeLeftField.isEditable() == false);
        LightningInfoView vEdit = new LightningInfoView(true, level);
        assertTrue(vEdit.timeLeftField.isEditable() == true);
    }

    @Test
    public void testRendersTime() {
        // Test that time is being rendered properly.
        LightningInfoView v = new LightningInfoView(false, level);
        level.update();
        assertTrue(v.timeLeftField.getText().contains("30"));
        level.tickTimeLeft();
        level.tickTimeLeft();
        v.updateTimeLeft();
        assertTrue(v.timeLeftField.getText().contains("28"));
    }

}
