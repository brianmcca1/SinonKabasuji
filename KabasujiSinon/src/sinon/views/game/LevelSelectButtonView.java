package sinon.views.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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

	/** Button to select the level. */
	JButton selectbtn;
	/** JPanel for the stars earned. */
	JPanel imagePanel;
	/** level number tied to this button. */
	public int levelNum;
	/** StarView that shows the earned stars for this level. */
	StarView starView;
	/** The level that this button interacts with. */
	public Level level;
	
	
	/**
	 * @param num level number tied to this button.
	 * @param level The level that this button interacts with.
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
		imagePanel.setBorder(BorderFactory.createBevelBorder(1));
		this.add(imagePanel);
		JButton selectbtn = makeButton(Integer.toString(num));
		
		if(this.level.getLevelData().getUnlocked() == false){
			this.selectbtn.setEnabled(false);
			this.selectbtn.setBackground(new Color(0, 0, 0));
		}
		else{
			this.selectbtn.setEnabled(true);
			selectbtn.setBackground(new Color(0, 100, 255));
		}
		
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
		selectbtn.setForeground(new Color(255, 255, 255));
		this.levelNum = Integer.parseInt(num);
		return selectbtn;
	}
}
