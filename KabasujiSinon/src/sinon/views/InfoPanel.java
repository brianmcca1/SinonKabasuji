package sinon.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sinon.views.builder.BankView;
import sinon.views.game.GameInfoView;

/**
 * InfoPanel is an interface/abstract class which encapsulates different things
 * depending on whether you're in the builder or player mode.
 * 
 * If you are in the game, this will display the number of stars, as well as
 * buttons for exiting and restarting a game.
 * 
 * If you are in the builder this will be a BankView.
 * 
 * 
 * @see BankView
 * @see GameInfoView
 * @author Josh Desmond
 */
@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

    /** Initializes the empty panel. */
    public InfoPanel() {
        this.setPreferredSize(new Dimension(180, 800));
        this.setMinimumSize(new Dimension(150, 800));
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
    }

    public void setStars(int s) {

    }

}
