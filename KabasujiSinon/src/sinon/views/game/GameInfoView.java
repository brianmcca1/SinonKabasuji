package sinon.views.game;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import sinon.models.Level;
import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class GameInfoView extends InfoPanel {

    /** Top level game object to manipulate. */
    Level level;

    /** Button objects that appear on the panel. */
    JButton exitButton;
    JButton restartButton;
    JButton nextLevelButton;
    JPanel starView;

    /**
     * @param l
     *            The top level Game object.
     */
    public GameInfoView(Level l) {
        super();

        this.level = l;

        JButton btnRestart = new JButton("Restart level\r\n");
        btnRestart.setPreferredSize(new Dimension(120, 30));
        this.add(btnRestart);
        this.restartButton = btnRestart;

        JButton btnNextLevel = new JButton("Next Level\r\n");
        btnNextLevel.setPreferredSize(new Dimension(120, 30));
        this.add(btnNextLevel);
        this.nextLevelButton = btnNextLevel;

        JButton btnExit = new JButton("Exit Level\r\n");
        btnExit.setPreferredSize(new Dimension(120, 30));
        this.add(btnExit);
        this.exitButton = btnExit;
        
        this.starView = new StarView("/images/blank.png");
        this.add(this.starView);
    }

    /** @return Returns the JButton object for the exit button. */
    public JButton getExitButton() {
        return this.exitButton;
    }

    /** @return Returns the JButton object for the restart button. */
    public JButton getRestartButton() {
        return this.restartButton;
    }

    /** @return Returns the JButton object for the next level button. */
    public JButton getNextLevelButton() {
        return this.nextLevelButton;
    }
    
    /** @return Returns the StarView object. */
    public JPanel getStarView(){
    	return this.starView;
    }
}
