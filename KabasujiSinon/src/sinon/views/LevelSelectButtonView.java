package sinon.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * A Panel for each button that contains the number, image, and the button 
 * for the level select screen
 * @author kartik
 *
 */
public class LevelSelectButtonView extends JPanel {
	
	JButton selectbtn;
	JPanel imagePanel;
	public int levelNum;
	
	/**
	 * Create the panel, takes the number of the level as an argument
	 */
	public LevelSelectButtonView(int num) {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(Color.RED));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		add(panel);
		
		JButton selectbtn = makeButton(Integer.toString(num));
		add(selectbtn);
		

	}
	
	/**Initializes the LevelSelectButtonView and adds a button to it. 
	 * Sets attributes like background and foreground
	 * 
	 * @param num The number of the level 
	 * @return Returns the button that is created
	 */
	public JButton makeButton(String num) {
		selectbtn = new JButton(num);
		selectbtn.setBackground(new Color(0, 0, 255));
		selectbtn.setForeground(new Color(127, 255, 0));
		this.levelNum = Integer.parseInt(num);
		return selectbtn;
	}
}
