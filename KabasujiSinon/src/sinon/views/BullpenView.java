package sinon.views;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.main.HexominoBankControllerFactory;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;
import sinon.views.builder.HexominoContainerView;

@SuppressWarnings("serial")
public class BullpenView extends JScrollPane implements HexominoContainerView {

    JPanel contentPanel;

    /** This is the bullpen that is associated with the view */
    BullPen bullpen;
    List<HexominoBullpenView> hexominoViews;

    public BullpenView(BullPen bullpen) {
        this.bullpen = bullpen;
        this.hexominoViews = new LinkedList<HexominoBullpenView>();

        initContentPanel();
        populateBullpen();

        this.validate();
    }

    private void initContentPanel() {
        this.contentPanel = new JPanel();
        contentPanel.setBackground(Color.gray);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.add(scrollBar);
        this.setViewportView(contentPanel);
    }

    /**
     * Creates a HexominoBullpenView and registers a HexominoBullpenController
     * to it.
     */
    private void populateBullpen() {

        // temp work/

        Hexomino hex = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0,
                2, 0, 3, 0, 4, 0, 5));
        HexominoBullpenView hexView = new HexominoBullpenView(hex);
        this.contentPanel.add(hexView);

        // We will actually need this block uncommented when we get the entities
        // working.
        // for(Hexomino hex : bullpen.getPieces()) {
        // HexominoBullpenView hbpView = new HexominoBullpenView(hex);
        // hbpView.setBackground(Color.red);
        // this.bullpenPanel.add(hbpView); hbpView.addMouseListener(new
        // HexominoBullpenController(MainView.kabasuji, hbpView));
        // }

    }

    @Override
    public void registerControllers(
            HexominoBankControllerFactory hexominoBankControllerFactory) {
        // TODO copy the code from BankView once that is finished. Don't copy
        // it if it isn't finished.
    }

}
