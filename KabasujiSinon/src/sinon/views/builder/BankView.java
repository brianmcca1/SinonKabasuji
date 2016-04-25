package sinon.views.builder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.main.Builder;
import sinon.main.HexStashRegistrator;
import sinon.models.BullPen;
import sinon.views.HexViewStash;
import sinon.views.HexominoBullpenView;
import sinon.views.InfoPanel;
import sinon.views.StashView;

@SuppressWarnings("serial")
public class BankView extends InfoPanel implements StashView {

	JScrollPane scrollPanel;
	JPanel contentPanel;
	// BullPen bullpen;
	Builder builder;
	HexViewStash stash;

	public BankView(Builder builder, BullPen bullpen) {
		super();
		this.stash = new HexViewStash(Objects.requireNonNull(bullpen),
				contentPanel);
		this.builder = Objects.requireNonNull(builder);
		initContentPanel();
		initBankViewScrollPanel();
		this.setLayout(new GridLayout(1, 1));
		this.add(scrollPanel);
		this.validate();

		populateBankViewWithHexominoes();
	}

	private void initContentPanel() {
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.orange);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
	}

	private void initBankViewScrollPanel() {
		scrollPanel = new JScrollPane();
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanel
		.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.add(scrollBar);
		scrollPanel
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setViewportView(contentPanel);
	}

	private void populateBankViewWithHexominoes() {
		stash.populateViewWithHexominos();

		for (HexominoBullpenView hex : stash.getHexominos()) {
			this.contentPanel.add(hex);
		}

		// TODO move these two lines to another method.
		this.contentPanel.doLayout();
		this.validate();
	}

	@Override
	public void setRegistrator(HexStashRegistrator hexStashRegistrator) {
		this.stash.setRegistrator(hexStashRegistrator);
	}

}