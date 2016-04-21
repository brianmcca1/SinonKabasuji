package sinon.views.builder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.models.Hexomino;
import sinon.serial.Deserializer;
import sinon.views.HexominoBullpenView;
import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class BankView extends InfoPanel {

    JScrollPane scrollPanel;
    JPanel bankViewPanel;

    public BankView() {
        super();

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
    	System.out.println("POPULATING BANKVIEW");
    	
    	Deserializer deserializer = new Deserializer();
    	ArrayList<Hexomino> hexominoesReadFromFile = new ArrayList<Hexomino>();
    	hexominoesReadFromFile = deserializer.deserializeHexominoesForBankView();

    	for(int i = 0; i < hexominoesReadFromFile.size(); i++){
    		HexominoBullpenView tempHexBullpenView = new HexominoBullpenView(hexominoesReadFromFile.get(i));

            this.bankViewPanel.add(tempHexBullpenView.getHexominoPanel());
    	}

        this.bankViewPanel.doLayout();
        this.validate();
    }
}
