package sinon.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PuzzleInfoView extends LevelTypeInfoView {
	
	private static final long serialVersionUID = -6047685525063166167L;
    public JLabel infoLabel;
    public JTextField movesLeftField;
    
    public PuzzleInfoView(boolean editable) {
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
    
	public int getValue(){
		if(this.movesLeftField.getText().compareTo("") == 0){
			return 1;
		}
		
		return (int)Integer.parseInt(this.movesLeftField.getText());
	}
}
