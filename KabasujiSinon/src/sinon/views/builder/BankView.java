package sinon.views.builder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.views.HexominoBullpenView;
import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class BankView extends InfoPanel {

    JScrollPane scrollPanel;
    JPanel contentPanel;

    public BankView() {
        super();

        initContentPanel();
        initBankViewScrollPanel();

        examplePopulateBankView();
        examplePopulateBankView();
        examplePopulateBankView();
        examplePopulateBankView();
        examplePopulateBankView();
        examplePopulateBankView();
        examplePopulateBankView();
        examplePopulateBankView();

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

    private void examplePopulateBankView() {
        HexominoBullpenView a = new HexominoBullpenView();
        a.setBackground(Color.black);
        this.contentPanel.add(a);
        HexominoBullpenView b = new HexominoBullpenView();
        b.setBackground(Color.gray);
        this.contentPanel.add(b);
        HexominoBullpenView c = new HexominoBullpenView();
        c.setBackground(Color.black);
        this.contentPanel.add(c);
        HexominoBullpenView d = new HexominoBullpenView();
        d.setBackground(Color.gray);
        this.contentPanel.add(d);
        this.contentPanel.doLayout();
        this.validate();
    }

}
