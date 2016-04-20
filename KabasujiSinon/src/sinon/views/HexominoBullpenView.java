package sinon.views;

import java.awt.Dimension;

import javax.swing.JPanel;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/** GUI element representing one of the Hexominos in the Bullpen */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel {
	
	/** The hexomino model object associated with this view */
	Hexomino hex;
	
	/** The bullpen model object associated with this view */
	BullPen bullpen;
	
    // TODO This 120 constant should be updated with a reference to the height
    // of a hexomino.
    private static final Dimension SIZE = new Dimension(120, 120);

    public HexominoBullpenView(Hexomino hex, BullPen bp) {
        super();
        this.setMinimumSize(SIZE);
        this.setMaximumSize(SIZE);
        this.setPreferredSize(SIZE);
        this.hex = hex;
        this.bullpen = bp;
    }
    
    /** temporary constructor */
    public HexominoBullpenView() {
    	super();
        this.setMinimumSize(SIZE);
        this.setMaximumSize(SIZE);
        this.setPreferredSize(SIZE);
    }
    
    /**
     * Getter that returns the hexomino associated with this view element
     * @return hexomino 
     */
    public Hexomino getHexomino() {
    	return hex;
    }
    
    /**
     * Getter that returns the bullpen associated with this view element
     * @return bullpen
     */
    public BullPen getBullPen() {
    	return bullpen;
    }
}
