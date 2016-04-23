package sinon.views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.BullpenController;
import sinon.controllers.HexominoBullpenController;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;

@SuppressWarnings("serial")
public class BullpenView extends JScrollPane {

    private JPanel bullpenPanel;

    /** This is the bullpen that is associated with the view */
    BullPen bullpen;

    public BullpenView() {
        this.bullpenPanel = new JPanel();
        bullpenPanel.setBackground(Color.gray);
        bullpenPanel.setLayout(new BoxLayout(bullpenPanel, BoxLayout.X_AXIS));
        bullpenPanel.addMouseListener(
                new BullpenController(MainView.kabasuji, this)); // register
                                                                 // BullpenController
                                                                 // to bullpen

        populateBullpen();

        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.add(scrollBar);
        this.setViewportView(bullpenPanel);
    }

    /**
     * Creates a HexominoBullpenView and registers a HexominoBullpenController
     * to it.
     */
    private void populateBullpen() {

        // temp work/
    	
        Hexomino hex = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0,
                2, 0, 3, 0, 4, 0, 5));
        HexominoBullpenView hexView = new HexominoBullpenView(hex);
        this.bullpenPanel.add(hexView);
        hexView.addMouseListener(
                new HexominoBullpenController(MainView.kabasuji, hexView));
		
    	
        
//         We will actually need this block uncommented when we get the entities
//         working. 
//         for(Hexomino hex : bullpen.getPieces()) {
//        	 HexominoBullpenView hbpView = new HexominoBullpenView(hex); 
//        	 hbpView.setBackground(Color.red);
//        	 this.bullpenPanel.add(hbpView); hbpView.addMouseListener(new HexominoBullpenController(MainView.kabasuji, hbpView)); 
//         }
         
    }
}
