package sinon.views;

import java.awt.Color;

import javax.swing.JButton;

public class LevelSelectButtonView {
	
	JButton selectbtn;
	
	public LevelSelectButtonView() {
		
	}
	
	public JButton initialize(String num) {
		selectbtn = new JButton(num);
		selectbtn.setBackground(new Color(0, 0, 255));
		selectbtn.setForeground(new Color(127, 255, 0));
		return selectbtn;
	}
}
