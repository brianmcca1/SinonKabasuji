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
    	ArrayList<Hexomino> hexominoesReadFromFile = new ArrayList<Hexomino>();
    	
    	hexominoesReadFromFile.add(new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
    	hexominoesReadFromFile.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 0, 3, 0, 4));
    	hexominoesReadFromFile.add(new Hexomino(0, 0, 0, 1, 1, 1, 0, 2, 0, 3, 0, 4));
		hexominoesReadFromFile.add(new Hexomino(0, 0, 0, 1, 0, 2, 1, 2, 0, 3, 0, 4));
		hexominoesReadFromFile.add(new Hexomino(0, 0, 0, 1, -1, 1, -1, 2, -1, 3, -1, 4));
		hexominoesReadFromFile.add(new Hexomino(0, 0, 0, 1, 1, 0, 1, 1, 0, 2, 0, 3));
		hexominoesReadFromFile.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 1, 2, 0, 3));

    	for(int i = 0; i < hexominoesReadFromFile.size(); i++){
    		HexominoBullpenView tempHexBullpenView = new HexominoBullpenView(hexominoesReadFromFile.get(i));
            this.bankViewPanel.add(tempHexBullpenView.getHexominoPanel());
    	}

        this.bankViewPanel.doLayout();
        this.validate();
    }
}
