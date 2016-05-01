package sinon.views.builder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.HexStashRegistrator;
import sinon.models.BullPen;
import sinon.models.data.HexominoBankData;
import sinon.views.HexViewStash;
import sinon.views.InfoPanel;
import sinon.views.Observer;
import sinon.views.StashView;

@SuppressWarnings("serial")
public class BankView extends InfoPanel implements StashView, Observer {

    JScrollPane scrollPanel;
    JPanel contentPanel;
    // BullPen bullpen;

    HexViewStash stash;

    public BankView() {
        super();
        initContentPanel();
        initBankViewScrollPanel();
        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPanel);

        this.stash = new HexViewStash(
                new BullPen(HexominoBankData.getHexominos()), contentPanel);
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

    @Override
    public void setRegistrator(HexStashRegistrator hexStashRegistrator) {
        assert hexStashRegistrator != null;
        this.stash.setRegistrator(hexStashRegistrator);
        updated();
    }

    @Override
    public void updated() {
        this.stash.updated();
        validate();
    }

    @Override
    public JPanel getPanelToRegisterController() {
        return this.contentPanel;
    }

    public void setStars(int s) {
    }
}