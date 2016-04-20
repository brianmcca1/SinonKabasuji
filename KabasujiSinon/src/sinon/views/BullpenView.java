package sinon.views;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import sinon.controllers.BullpenController;
import sinon.controllers.HexominoBullpenController;

@SuppressWarnings("serial")
public class BullpenView extends JScrollPane {

    private JPanel bullpenPanel;

    public BullpenView() {
        this.setBackground(Color.CYAN);

        this.bullpenPanel = new JPanel();
        bullpenPanel.setBackground(Color.gray);
        bullpenPanel.setLayout(new BoxLayout(bullpenPanel, BoxLayout.X_AXIS));
        
        bullpenPanel.addMouseListener(new BullpenController(MainView.kabasuji, this)); //register BullpenController to bullpen
        
        populateBullpen();

        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.add(scrollBar);
        
        this.setViewportView(bullpenPanel);
    }

    /** Creates a HexominoBullpenView and registers a HexominoBullpenController to it.*/
    private void populateBullpen() {
        HexominoBullpenView a = new HexominoBullpenView();
        a.setBackground(Color.red);
        this.bullpenPanel.add(a);
        a.addMouseListener(new HexominoBullpenController(MainView.kabasuji, a));
    }
}
