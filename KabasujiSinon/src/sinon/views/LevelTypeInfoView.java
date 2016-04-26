package sinon.views;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LevelTypeInfoView extends JPanel{

	public LevelTypeInfoView(){
		this.setBounds(450, 26, 130, 300);
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.setBackground(Color.LIGHT_GRAY);
	}
	
	public int getValue(){
		return -999;
	}
	
}
