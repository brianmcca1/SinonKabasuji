package sinon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Set;
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
        
        //file the entire grid with blank JPanels
        JPanel tempPanel;
        for(int i = 0; i < 6; i++){
        	for(int j = 0; j < 6; j++){
        		tempPanel = new JPanel();
        		tempPanel.setBackground(Color.white);
        		this.hexominoPanel.add(tempPanel);
        	}
        }
    }
    
    /** @return Hexomino model associated with this view.*/
    public Hexomino getHexomino() {
    	return this.hex;
    }
    

    public HexominoBullpenView setHexominoOnGrid(){
    	//Get the translated points from kartiks algorithm
    	Set<Point> normalizedPoints = this.hex.getNormalizedPoints();

    	JPanel tempHexPanel;
    	int indexForHexJPanel;
    	for(Point p: normalizedPoints){
    		tempHexPanel = new JPanel();
    		tempHexPanel.setBackground(Color.black);
    		indexForHexJPanel = (p.y*6) + p.x;
    		this.hexominoPanel.add(tempHexPanel, indexForHexJPanel);
    	}
    	
    	return this;
    }
}
