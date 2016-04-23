package sinon.views.builder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.HexominoBankController;
import sinon.main.HexominoBankControllerFactory;
import sinon.models.BullPen;
import sinon.views.HexominoBullpenView;
import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class BankView extends InfoPanel implements HexominoContainerView {

    JScrollPane scrollPanel;
    JPanel contentPanel;
    // Builder builder;
    BullPen bullpen;
    List<HexominoBullpenView> hexominoViews;

    public BankView(BullPen bullpen) {
        super();
        this.bullpen = bullpen;
        this.hexominoViews = new LinkedList<HexominoBullpenView>();
        // this.builder = b;
        // initialize builder menu bar
        // BuilderMenuBar menuBar = new BuilderMenuBar(this.builder);
        // this.builder.setJMenuBar(menuBar);

        initContentPanel();
        initBankViewScrollPanel();
        populateBankViewWithHexominoes();

        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPanel);
        this.validate();

    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.orange);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    }

    private void initBankViewScrollPanel() {
        scrollPanel = new JScrollPane();

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollPanel.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.add(scrollBar);
        scrollPanel.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPanel.setViewportView(contentPanel);

    }

    private void populateBankViewWithHexominoes() {

        for (int i = 0; i < bullpen.getPieces().size(); i++) {
            HexominoBullpenView tempHexBullpenView = new HexominoBullpenView(
                    bullpen.getPieces().get(i));
            this.contentPanel.add(tempHexBullpenView.getHexominoPanel());
            this.hexominoViews.add(tempHexBullpenView);
            // tempHexBullpenView.addMouseListener(new
            // HexominoBankController(this.builder, tempHexBullpenView));
        }

        this.contentPanel.doLayout();
        this.validate();
    }

    @Override
    public void registerControllers(
            HexominoBankControllerFactory hexominoBankControllerFactory) {
        assert bullpen != null;

        for (HexominoBullpenView view : hexominoViews) {
            hexominoBankControllerFactory.registerHexomino(view, bullpen);
            // FIXME this should be using the bank controller factory
            view.addMouseListener(new HexominoBankController(bullpen,
                    view.getHexomino(), null, view));
        }
    }
}