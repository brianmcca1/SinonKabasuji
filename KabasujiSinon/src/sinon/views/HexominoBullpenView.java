package sinon.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import sinon.models.BullPen;
import sinon.models.Hexomino;

/** GUI element representing one of the Hexominos in the Bullpen */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel {
	
	JPanel hexominoPanel;
	/** The hexomino model object associated with this view */
	Hexomino hex;
	
    public HexominoBullpenView(Hexomino hex) {
        this.hex = hex;
        this.hexominoPanel = new JPanel();
        this.hexominoPanel.setLayout(new GridLayout(6,6));
    }
    
    /** @return Hexomino model associated with this view.*/
    public Hexomino getHexomino() {
    	return hex;
    }
    
    
}

//remove all JPanels from grid .removeAll()
//add new JPanels to grid .add(JPanel)
//add new JPanels with colors corresponding to new coordinates for hexomino .add(comp, index)
