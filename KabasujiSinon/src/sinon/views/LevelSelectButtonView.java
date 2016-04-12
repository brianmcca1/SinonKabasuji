package sinon.views;

import java.awt.Color;

import javax.swing.JButton;

public class LevelSelectButtonView {
	
	JButton selectbtn;
	public int levelNum;
	
	public LevelSelectButtonView() {

	}
	
	/**Initializes the LevelSelectButtonView and adds a button to it. 
	 * Sets attributes like background and foreground
	 * 
	 * @param num The number of the level 
	 * @return Returns the button that is created
	 */
	public JButton initialize(String num) {
		selectbtn = new JButton(num);
		selectbtn.setBackground(new Color(0, 0, 255));
		selectbtn.setForeground(new Color(127, 255, 0));
		this.levelNum = Integer.parseInt(num);
		return selectbtn;
	}
}
