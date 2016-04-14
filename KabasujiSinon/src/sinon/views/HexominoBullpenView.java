package sinon.views;

import java.awt.Dimension;

import javax.swing.JPanel;

/** GUI element representing one of the Hexominos in the Bullpen */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel {

    // TODO This 120 constant should be updated with a reference to the height
    // of a hexomino.
    private static final Dimension SIZE = new Dimension(120, 120);

    public HexominoBullpenView() {
        super();
        this.setMinimumSize(SIZE);
        this.setMaximumSize(SIZE);
        this.setPreferredSize(SIZE);
    }
}
