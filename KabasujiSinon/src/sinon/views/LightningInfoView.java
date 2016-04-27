package sinon.views;

import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sinon.models.LightningLevel;

public class LightningInfoView extends LevelTypeInfoView {

	private static final long serialVersionUID = 6687905039046766060L;
    public JLabel infoLabel;
    public JTextField timeLeftField;
    public LightningLevel level;

    public LightningInfoView(boolean editable, LightningLevel level) {
    	this.level = level;
        setLayout(new GridLayout(1, 1));
        this.infoLabel = new JLabel("Time:");
        this.timeLeftField = new JTextField();
        
        if(!editable)
        	this.timeLeftField.setEditable(false);
        else
        	this.timeLeftField.setEditable(true);
        
        this.timeLeftField.setText(Integer.toString(level.getMaxTime()));
        this.add(infoLabel);
        this.add(timeLeftField);
    }
    
	public int getValue(){
		if(this.timeLeftField.getText().compareTo("") == 0){
			return 1;
		}
		return (int)Integer.parseInt(this.timeLeftField.getText());
	}
	
	public void updateTimeLeft(){
		this.timeLeftField.setText(((Integer) level.getTimeLeft()).toString());
	}
	
	
}
