package sinon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import sinon.models.Hexomino;

/** GUI element representing one of the Hexominos in the Bullpen. */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel implements Observer{

    /** The hexomino model object associated with this view */
    Hexomino hex;

    public HexominoBullpenView(Hexomino h) {
        this.hex = h;
        this.setLayout(new GridLayout(6, 6));
        this.setMinimumSize(new Dimension(150, 150));
        this.setMaximumSize(new Dimension(150, 150));
        this.setHexominoOnGrid();
        hex.registerObserver(this);
        
    }

    /** @return Hexomino model associated with this view. */
    public Hexomino getHexomino() {
        return this.hex;
    }

    public HexominoBullpenView setHexominoOnGrid() {
        List<Point> normalizedPoints = this.hex.getNormalizedPoints();

        Integer indexForHexJPanel;
        ArrayList<Integer> indexList = new ArrayList<Integer>();

        for (Point p : normalizedPoints) {
            indexForHexJPanel = (p.x * 6) + p.y;
            indexList.add(indexForHexJPanel);
        }

        JPanel tempHexPanel;
        for (int i = 0; i < 36; i++) {
            tempHexPanel = new JPanel();
            tempHexPanel.setMaximumSize(new Dimension(10, 10));
            tempHexPanel.setMinimumSize(new Dimension(10, 10));
            tempHexPanel.setPreferredSize(new Dimension(10, 10));
            this.setBorder(new EmptyBorder(10, 0, 10, 0));
            if (indexList.contains(i)) {

                tempHexPanel.setBackground(hex.getColor());
                tempHexPanel.setBorder(
                        BorderFactory.createLineBorder(Color.lightGray));
                this.add(tempHexPanel);
            } else {
                this.add(tempHexPanel);
            }
        }
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return this;
    }

	@Override
	public void updated() {
		this.removeAll();
		this.setHexominoOnGrid();
	}

}
