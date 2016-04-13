package sinon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

/**
 * GameView is a GUI that shows the GridView, it shows the Optional
 * ReleaseButtonView, the BullpenView, and the InfoPanel on the right. InfoPanel
 * is an interface/abstract class which encapsulates different things depending
 * on whether you're in the builder or player mode.
 * 
 * 
 */
public class MainView extends JPanel {
    /**
     * levelView is a high level container, which has the Bullpen & the GridView
     * & the optional ReleaseButtonView
     */
    private JPanel levelView;
    private JPanel bullpenView;
    private JPanel boardView;
    private ActionListener realTempListener;

    public MainView(ActionListener realTempListener, InfoPanel infoPanel) {
        this.realTempListener = realTempListener;
        initialize();
        setInfoPanel(infoPanel);
    }

    private void initialize() {
        this.setMinimumSize(new Dimension(800, 600));
        this.setPreferredSize(new Dimension(800, 600));
        // this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout(0, 0));

        levelView = new JPanel();
        levelView.setPreferredSize(new Dimension(605, 10)); // TODO height
                                                            // should be 600 no?
        levelView.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.add(levelView, BorderLayout.WEST);
        levelView.setLayout(new BorderLayout(0, 0));

        bullpenView = new JPanel();
        bullpenView.setPreferredSize(new Dimension(10, 180));
        levelView.add(bullpenView, BorderLayout.NORTH);
        bullpenView.setLayout(null);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(0, 163, 603, 17);
        bullpenView.add(scrollBar);

        addExampleHexominos();

        boardView = new JPanel();
        boardView.setPreferredSize(new Dimension(10, 300));
        levelView.add(boardView, BorderLayout.CENTER);
        boardView.setLayout(null);

        JPanel tempBoard = new JPanel();
        tempBoard.setBounds(141, 26, 300, 298);
        tempBoard.setBackground(Color.BLACK);
        boardView.add(tempBoard);

        ReleaseButtonView releaseButtonView = new ReleaseButtonView();
        boardView.add(releaseButtonView);

    }

    private void setInfoPanel(InfoPanel infoPanel) {
        this.add(infoPanel, BorderLayout.EAST);
    }

    private void addExampleHexominos() {
        JButton exampleBullpenHexominoButton = new JButton("");
        exampleBullpenHexominoButton.setBounds(22, 6, 150, 149);
        bullpenView.add(exampleBullpenHexominoButton);
    }
}
