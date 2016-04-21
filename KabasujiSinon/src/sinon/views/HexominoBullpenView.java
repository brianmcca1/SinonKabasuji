package sinon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import sinon.models.BullPen;
import sinon.models.Hexomino;

/** GUI element representing one of the Hexominos in the Bullpen */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel {
	
	JPanel hexominoPanel;
	/** The hexomino model object associated with this view */
	Hexomino hex;
	
    public HexominoBullpenView(Hexomino h) {
        this.hex = h;
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
        
        this.setHexominoOnGrid();
    }
    
    /** @return Hexomino model associated with this view.*/
    public Hexomino getHexomino() {
    	return this.hex;
    }
    

    public HexominoBullpenView setHexominoOnGrid(){
    	System.out.println("SETTING HEXOMINO ON ITS GRID");
    	List<Point> normalizedPoints = this.hex.getNormalizedPoints();
    	
    	JPanel tempHexPanel;
    	int indexForHexJPanel;
    	boolean flipper = true;
    	for(Point p: normalizedPoints){
    		tempHexPanel = new JPanel();
    		
    		if(flipper)
    			tempHexPanel.setBackground(Color.black);
    		else
    			tempHexPanel.setBackground(Color.red);
    		
    		//tempHexPanel.setBounds(p.y, p.x, 25, 25);
    		System.out.println("NORM X: " + p.x + " NORM Y: " + p.y);
    		indexForHexJPanel = (p.x*6) + p.y;
    		this.hexominoPanel.add(tempHexPanel, indexForHexJPanel);
    		flipper = !flipper;
    	}
    	
    	return this;
    }
    
    public JPanel getHexominoPanel(){
    	return this.hexominoPanel;
    }
}
