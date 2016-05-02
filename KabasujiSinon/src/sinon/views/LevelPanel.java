package sinon.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

/** This is the left part of the screen that is common to both
 * builder and game. It is used to render the bullpenView and the 
 * boardView. 
 * 
 * @author kartik
 *
 */
public class LevelPanel extends JPanel {

	private static final long serialVersionUID = -4267458674387942331L;

	/**
     * Create the panel.
     * @param gameAreaPanel
     * @param bullpenView
     */
    public LevelPanel(BullpenView bullpenView, JPanel gameAreaPanel) {
        setPreferredSize(new Dimension(645, MainView.MAIN_PANEL_HEIGHT));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 645 };
        gridBagLayout.rowHeights = new int[] { 150, 450 };
        gridBagLayout.columnWeights = new double[] { 1.0 };
        gridBagLayout.rowWeights = new double[] { 1.0, 1.0 };
        setLayout(gridBagLayout);

        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.anchor = GridBagConstraints.NORTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        add(bullpenView.scrollPanel, gbc_scrollPane);

        JPanel panel = gameAreaPanel;
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 1;
        add(panel, gbc_panel);

    }

}
