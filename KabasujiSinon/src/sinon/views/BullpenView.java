package sinon.views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.BullpenController;
import sinon.controllers.HexominoBullpenController;

/**
 * @author Josh Desmond
 */
@SuppressWarnings("serial")
public class BullpenView extends JScrollPane {

    private JPanel upperPanel;

    public BullpenView() {
        this.setBackground(Color.CYAN);

        this.upperPanel = new JPanel();
        upperPanel.setBackground(Color.gray);
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        upperPanel.addMouseListener(new BullpenController(MainView.kabasuji, this));
        
        examplePopulateBullpen();

        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.add(scrollBar);
        
        this.setViewportView(upperPanel);
    }

    private void examplePopulateBullpen() {
        HexominoBullpenView a = new HexominoBullpenView();
        a.setBackground(Color.red);
        this.upperPanel.add(a);
        a.addMouseListener(new HexominoBullpenController(MainView.kabasuji, a));
    }
}
