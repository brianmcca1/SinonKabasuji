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
    JPanel contentPanel;

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
    	ArrayList<Hexomino> hexominoesReadFromFile = new ArrayList<Hexomino>();
    	Deserializer deserializer = new Deserializer();

    	hexominoesReadFromFile = deserializer.deserializeHexominoesForBankView();

    	for(int i = 0; i < hexominoesReadFromFile.size(); i++){
    		HexominoBullpenView tempHexBullpenView = new HexominoBullpenView(hexominoesReadFromFile.get(i));
    		tempHexBullpenView.setHexominoOnGrid();

            this.contentPanel.add(tempHexBullpenView);
    	}

        this.contentPanel.doLayout();
        this.validate();
    }
}
