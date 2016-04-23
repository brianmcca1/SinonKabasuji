package sinon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sinon.models.Hexomino;

/** GUI element representing one of the Hexominos in the Bullpen. */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JPanel {

    /** The hexomino model object associated with this view */
    Hexomino hex;

    public HexominoBullpenView(Hexomino h) {
        this.hex = h;
        this.setLayout(new GridLayout(6, 6));

        this.setHexominoOnGrid();
    }

    /** @return Hexomino model associated with this view. */
    public Hexomino getHexomino() {
        // I need it for getting the hexomino to the hexomino bank controller
        // and
        // adding it to the bullpen when clicked in the bank.
        return this.hex;
    }

    public HexominoBullpenView setHexominoOnGrid() {
        List<Point> normalizedPoints = this.hex.getNormalizedPoints();

        Integer indexForHexJPanel;
        ArrayList<Integer> indexList = new ArrayList<Integer>();

        for (Point p : normalizedPoints) {
            indexForHexJPanel = (p.y * 6) + p.x;
            indexList.add(indexForHexJPanel);
        }

        JPanel tempHexPanel;
        for (int i = 0; i < 36; i++) {
            tempHexPanel = new JPanel();
            tempHexPanel.setPreferredSize(new Dimension(15, 15));
            this.setBorder(new EmptyBorder(10, 0, 10, 0));
            if (indexList.contains(i)) {
                tempHexPanel.setBackground(Color.blue);
                tempHexPanel.setBorder(
                        BorderFactory.createLineBorder(Color.lightGray));
                this.add(tempHexPanel);
            } else {
                this.add(tempHexPanel);
            }

        }

        return this;
    }

    

    

}
