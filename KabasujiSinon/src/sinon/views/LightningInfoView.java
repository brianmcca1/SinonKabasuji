package sinon.views;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LightningInfoView extends JPanel implements LevelTypeInfoView {

    /** The dimensions of the rectangle */
    private static final Rectangle BOUNDS = new Rectangle(450, 26, 100, 100);
    public JLabel infoLabel;
    public JTextField timeLeftField;

    public LightningInfoView(boolean editable) {
        setBounds(BOUNDS);
        setLayout(new GridLayout(1, 1));
        this.infoLabel = new JLabel("Time:");
        this.timeLeftField = new JTextField();
        
        if(!editable)
        	this.timeLeftField.setEditable(false);
        else
        	this.timeLeftField.setEditable(true);
        
        this.add(infoLabel);
        this.add(timeLeftField);
    }
}
