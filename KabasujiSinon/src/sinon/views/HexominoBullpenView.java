package sinon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import sinon.models.Hexomino;

/**
 * View associated with each one of the hexominos in a bullpen. It has a
 * hexomino in order to render the hexomino accurately in both the bullpenView
 * and the bankView.
 * 
 * @author kartik
 *
 */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel implements Observer {

    /** The hexomino model object associated with this view */
    Hexomino hex;

    /**
     * Constructor for generating a HexominoBullpenView in the bullpen and the
     * bank.
     * 
     * @param h
     *            Hexomino that is associated with this view class.
     */
    public HexominoBullpenView(Hexomino h) {
        this.setBackground(UIManager.getColor("Panel.background"));
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

    /**
     * Function that is used to set a hexomino on a grid in the bullpen.
     * Hexominos are rendered in the bullpen in such a way that they are placed
     * as squares in a 6x6 grid. What happens when there are negative relative
     * positions? It gets the set of normalized points from the hexomino class
     * in order to position the squares accurately on the 6x6 GUI grid.
     * 
     * @return BullpenView that is created.
     */
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
            tempHexPanel.setBackground(UIManager.getColor("Panel.background"));
            tempHexPanel.setMaximumSize(new Dimension(10, 10));
            tempHexPanel.setMinimumSize(new Dimension(10, 10));
            tempHexPanel.setPreferredSize(new Dimension(10, 10));
            this.setBorder(new EmptyBorder(10, 0, 10, 0));
            if (indexList.contains(i)) {

                tempHexPanel.setBackground(hex.getColor());
                tempHexPanel
                        .setBorder(BorderFactory.createLineBorder(Color.GRAY));
                this.add(tempHexPanel);
            } else {
                this.add(tempHexPanel);
            }
        }
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return this;
    }

    /**
     * Sets the color of the background of the bullpenView to if hexomino is
     * selected.
     */
    public void select() {
        this.setBackground(Color.cyan);
    }

    /** Resets the color of the bullpenview when hexomino is deselected. */
    public void deselect() {
        this.setBackground(UIManager.getColor("Panel.background"));
    }

    @Override
    public void updated() {
        this.removeAll();
        this.setHexominoOnGrid();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hex == null) ? 0 : hex.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof HexominoBullpenView))
            return false;
        HexominoBullpenView other = (HexominoBullpenView) obj;
        if (hex == null) {
            if (other.hex != null)
                return false;
        } else if (!hex.equals(other.hex))
            return false;
        return true;
    }

}
