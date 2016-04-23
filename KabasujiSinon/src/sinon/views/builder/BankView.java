package sinon.views.builder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.HexominoBankController;
import sinon.main.Builder;
import sinon.models.Hexomino;
import sinon.models.data.HexominoBankData;
import sinon.views.HexominoBullpenView;
import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class BankView extends InfoPanel {

    JScrollPane scrollPanel;
    JPanel bankViewPanel;
    Builder builder;

    public BankView(Builder b) {
        super();
        
        this.builder = b;
        //initialize builder menu bar
		BuilderMenuBar menuBar = new BuilderMenuBar(this.builder);
		this.builder.setJMenuBar(menuBar);

        initContentPanel();
        initBankViewScrollPanel();
        populateBankViewWithHexominoes();

        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPanel);
        this.validate();
    }

    private void initContentPanel() {
        bankViewPanel = new JPanel();
        bankViewPanel.setBackground(Color.orange);
        bankViewPanel.setLayout(new BoxLayout(bankViewPanel, BoxLayout.Y_AXIS));
    }

    private void initBankViewScrollPanel() {
        scrollPanel = new JScrollPane();

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollPanel.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.add(scrollBar);
        scrollPanel.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPanel.setViewportView(bankViewPanel);

    }

    private void populateBankViewWithHexominoes() {
        List<Hexomino> hexominoesReadFromFile = HexominoBankData.getHexominos();

        for (int i = 0; i < hexominoesReadFromFile.size(); i++) {
            HexominoBullpenView tempHexBullpenView = new HexominoBullpenView(hexominoesReadFromFile.get(i));
            tempHexBullpenView.getHexominoPanel().addMouseListener(new HexominoBankController(this.builder, tempHexBullpenView));
            this.bankViewPanel.add(tempHexBullpenView.getHexominoPanel());
        }

        this.bankViewPanel.doLayout();
        this.validate();
    }
}
