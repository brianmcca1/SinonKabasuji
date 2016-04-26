package sinon.views.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sinon.controllers.LevelStartController;
import sinon.main.Game;

@SuppressWarnings("serial")
public class LevelSelectView extends JPanel {
	
    /** These are the buttons on the level select screen */
    LevelSelectButtonView[] buttonPanels = new LevelSelectButtonView[15];
    /** Overall Game. */
    Game game;

    /**
     * Create the application.
     */
    public LevelSelectView(Game g) {
        this.game = g;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setBackground(new Color(135, 206, 235));
        this.setBounds(0, 0, 800, 600);
        this.setLayout(null);

        // initialize the panel
        JPanel internalPanelOne = new JPanel();
        internalPanelOne.setBackground(new Color(135, 206, 235));
        internalPanelOne.setBounds(150, 175, 500, 325);
        this.add(internalPanelOne);
        internalPanelOne.setLayout(new GridLayout(3, 5, 30, 20));

        // initialize all the button views on the screen
        for (int i = 0; i < 15; i++) {
            buttonPanels[i] = new LevelSelectButtonView(i + 1);
            internalPanelOne.add(buttonPanels[i]);
        }

        for (int i = 0; i < 15; i++) {
            buttonPanels[i].selectbtn.addActionListener(new LevelStartController(game, this, i));
        }

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(135, 206, 235));
        titlePanel.setBounds(140, 63, 518, 45);
        this.add(titlePanel);

        JLabel lblLevelSelect = new JLabel("KABASUJI | LEVEL SELECT\n");
        lblLevelSelect.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
        lblLevelSelect.setForeground(new Color(0, 0, 128));
        titlePanel.add(lblLevelSelect);
    }

    public LevelSelectButtonView getButton(int index) {
        return this.buttonPanels[index];
    }
}
