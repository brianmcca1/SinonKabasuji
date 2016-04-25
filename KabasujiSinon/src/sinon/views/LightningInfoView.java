package sinon.views;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

// FIXME make this subclass GameInfoView. Also, we aren't at this point in
// development yet, stop adding classes if we don't need them yet.
public class LightningInfoView extends JPanel implements LevelTypeInfoView {

    /** The dimensions of the rectangle */
    private static final Rectangle BOUNDS = new Rectangle(450, 26, 100, 100);
    public JLabel infoLabel;
    public JLabel timeLeftLabel;

    public LightningInfoView() {
        setBounds(BOUNDS);
        setLayout(new GridLayout(1, 1));
        this.infoLabel = new JLabel("Time:");
        this.timeLeftLabel = new JLabel();
        this.add(infoLabel);
        this.add(timeLeftLabel);
    }
}
