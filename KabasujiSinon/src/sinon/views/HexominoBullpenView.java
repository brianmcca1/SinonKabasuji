package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

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
        this.hexominoPanel.setLayout(new GridLayout(6, 6));
        this.setHexominoOnGrid();
    }

    /** @return Hexomino model associated with this view. */
    @Deprecated
    public Hexomino getHexomino() {
        // FIXME No. Why do you need this method? The only reason this class has
        // a hexomino is to draw it. Nothing else right?
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
            if (indexList.contains(i)) {
                tempHexPanel.setBackground(Color.blue);
                this.hexominoPanel.add(tempHexPanel);
            } else {
                this.hexominoPanel.add(tempHexPanel);
            }

        }

        return this;
    }

    public JPanel getHexominoPanel() {
        return this.hexominoPanel;
    }
}
