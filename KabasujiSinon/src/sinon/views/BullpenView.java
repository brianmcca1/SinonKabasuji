package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.HexStashRegistrator;
import sinon.models.BullPen;
import sinon.models.Level;

/**
 * The boundary class that is associated with the BullPen Entity class.
 * It is a JPanel therefore it can be drawn (or added to) the main
 * Kabasuji JFrame graphic object.
 * 
 * @author kartik
 *
 */
@SuppressWarnings("serial")
public class BullpenView extends JPanel implements StashView, Observer {

	/** This is the scrolling pane that is responsible for the scrolling functionality in the bullpen. */
    public JScrollPane scrollPanel;
    
    /** This is the JPanel that holds all the contents of the bullpen. */
    public JPanel contentPanel;

    HexViewStash stash;
    
    /**The bullpen model that is associated with this class. */
    private BullPen bullpen;

    /** The main constructor that is used to construct a bullpenView. */
    public BullpenView(Level level) {
        Objects.requireNonNull(level);
        this.bullpen = level.getBullpen();
        initContentPanel();
        initBullpenViewScrollPanel();
        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPanel);
        bullpen.registerObserver(this);
        this.stash = new HexViewStash(level, contentPanel);
        this.validate();
    }

    /** Helper function to initialize the scroll panel in the bullpen. */
    private void initBullpenViewScrollPanel() {
        scrollPanel = new JScrollPane();
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollPanel.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.add(scrollBar);
        scrollPanel.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setViewportView(contentPanel);
    }

    /**helper function called from the constructor to initialize the content panel graphic. */
    private void initContentPanel() {
        this.contentPanel = new JPanel();
        contentPanel.setBackground(Color.gray);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
    }

    @Override
    public void setRegistrator(HexStashRegistrator hexStashRegistrator) {
        stash.setRegistrator(Objects.requireNonNull(hexStashRegistrator));
        updated();
    }

    @Override
    public void updated() {
        stash.updated();
    }

    @Override
    public JPanel getPanelToRegisterController() {
        return contentPanel;
    }
}
