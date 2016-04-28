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
import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.views.HexominoBullpenView;
import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class BankView extends InfoPanel {

	JScrollPane scrollPanel;
	JPanel contentPanel;
	BullPen bullpen;
	Builder builder;
	List<HexominoBullpenView> hexominoViews;

	public BankView(Builder b, BullPen bullpen) {
		super();

		this.builder = b;
		this.bullpen = bullpen;
		this.hexominoViews = new LinkedList<HexominoBullpenView>();

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
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.add(scrollBar);
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setViewportView(contentPanel);
	}

	private void populateBankViewWithHexominoes() {
		for (int i = 0; i < bullpen.getPieces().size(); i++) {
			HexominoBullpenView tempHexBullpenView = new HexominoBullpenView(bullpen.getPieces().get(i));
			this.contentPanel.add(tempHexBullpenView);
			this.hexominoViews.add(tempHexBullpenView);
			tempHexBullpenView.addMouseListener(new HexominoBankController(this.builder, this.builder.getLevel().getBullpen(), tempHexBullpenView));
		}

		this.contentPanel.doLayout();
		this.validate();
	}

}