package sinon.views;

import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LightningInfoView extends LevelTypeInfoView {

	private static final long serialVersionUID = 6687905039046766060L;
    public JLabel infoLabel;
    public JTextField timeLeftField;

    public LightningInfoView(boolean editable) {
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
    
	public int getValue(){
		return (int)Integer.parseInt(this.timeLeftField.getText());
	}
}
