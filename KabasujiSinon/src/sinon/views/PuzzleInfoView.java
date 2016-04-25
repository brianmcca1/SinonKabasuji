package sinon.views;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

// FIXME make this subclass GameInfoView.
public class PuzzleInfoView extends JPanel implements LevelTypeInfoView {

    /** The dimensions of the rectangle */
    private static final Rectangle BOUNDS = new Rectangle(450, 26, 100, 100);
    public JLabel infoLabel;
    public JLabel movesLeftLabel;

    public PuzzleInfoView() {
        setBounds(BOUNDS);
        setLayout(new GridLayout(1, 1));
        this.infoLabel = new JLabel("Moves:");
        this.movesLeftLabel = new JLabel();
        this.add(infoLabel);
        this.add(movesLeftLabel);
    }
}
