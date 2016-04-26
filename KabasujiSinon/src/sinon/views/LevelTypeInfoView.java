package sinon.views;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LevelTypeInfoView extends JPanel{

	private static final long serialVersionUID = -733050402665097319L;

	public LevelTypeInfoView(){
		this.setBounds(450, 26, 130, 300);
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.setBackground(Color.LIGHT_GRAY);
	}
	
}
