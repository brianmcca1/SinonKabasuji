package sinon.views;

//<<<<<<< HEAD
//public class BullpenView {

//=======
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

/**
 * TODO
 * 
 * @author Josh Desmond
 */
public class BullpenView extends JPanel {

    /**
     * TODO
     */
    public BullpenView() {

        this.setPreferredSize(new Dimension(10, 180));
        this.setLayout(null);
        // Now add the scrollbar
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(0, 163, 603, 17);
        this.add(scrollBar);
        // addExampleHexominos();
    }
//>>>>>>> master
}
