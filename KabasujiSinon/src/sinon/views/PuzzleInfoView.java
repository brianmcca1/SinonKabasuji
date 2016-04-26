package sinon.views;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PuzzleInfoView extends JPanel implements LevelTypeInfoView {

    /** The dimensions of the rectangle */
    private static final Rectangle BOUNDS = new Rectangle(450, 26, 100, 100);
    public JLabel infoLabel;
    public JTextField movesLeftField;

    public PuzzleInfoView(boolean editable) {
        setBounds(BOUNDS);
        setLayout(new GridLayout(1, 1));
        this.infoLabel = new JLabel("Moves:");
        this.movesLeftField = new JTextField();
        
        if(!editable)
        	this.movesLeftField.setEditable(false);
        else
        	this.movesLeftField.setEditable(true);
        
        this.add(infoLabel);
        this.add(movesLeftField);
    }
}
