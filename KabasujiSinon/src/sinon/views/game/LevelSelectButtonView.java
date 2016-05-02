package sinon.views.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import sinon.controllers.FileHandler;
import sinon.models.Level;

/**
 * A Panel for each button that contains the number, image, and the button for
 * the level select screen
 * 
 * @author kartik
 */
@SuppressWarnings("serial")
public class LevelSelectButtonView extends JPanel {

	JButton selectbtn;
	JPanel imagePanel;
	public int levelNum;
	StarView starView;
	public Level level;
	
	
	/**
	 * Create the panel, takes the number of the level as an argument
	 */
	public LevelSelectButtonView(int num, Level level) {
		setLayout(new GridLayout(2, 1, 0, 0));

		JPanel imagePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) imagePanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		this.add(imagePanel);
		
		int starRecord = level.getLevelData().getStarRecord();
		String starImageFilePath = FileHandler.determineFileStringForStars(starRecord);
		this.level = level;
		this.starView = new StarView(starImageFilePath, this.level);
		imagePanel.add(starView);
		
		this.add(imagePanel);
		JButton selectbtn = makeButton(Integer.toString(num));
		
		if(this.level.getLevelData().getUnlocked() == false)
			this.selectbtn.setEnabled(false);
		else
			this.selectbtn.setEnabled(true);
		
		add(selectbtn);
	}

	/**
	 * Initializes the LevelSelectButtonView and adds a button to it. Sets
	 * attributes like background and foreground
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
