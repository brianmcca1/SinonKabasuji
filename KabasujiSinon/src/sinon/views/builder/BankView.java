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

/**
 * The JPanel that appears on the right side only in Builder mode which contains all 35 Hexominoes.
 */
@SuppressWarnings("serial")
public class BankView extends InfoPanel implements StashView, Observer {

	/** Scroll panel for the BankView. */
	JScrollPane scrollPanel;
	/** JPanel that holds the actual Hexomino views. */
	JPanel contentPanel;
	/** HexViewStash which handles creating the hexominos. */
	HexViewStash stash;

	/**
	 * Creates a BankView.
	 */
	public BankView() {
		super();
		initContentPanel();
		initBankViewScrollPanel();
		this.setLayout(new GridLayout(1, 1));
		this.add(scrollPanel);

		this.stash = new HexViewStash(new BullPen(HexominoBankData.getHexominos()), contentPanel);
	}

	/**
	 * Creates the contentPanel and sets its layout.
	 */
	private void initContentPanel() {
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.orange);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
	}

	/**
	 * Creates the scrollPanel for the BankView and sets its layout.
	 */
	private void initBankViewScrollPanel() {
		scrollPanel = new JScrollPane();
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.add(scrollBar);
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setViewportView(contentPanel);
	}

	/**
	 * Sets the HexStashRegistrator to the BankView's HexViewStash.
	 */
	@Override
	public void setRegistrator(HexStashRegistrator hexStashRegistrator) {
		assert hexStashRegistrator != null;
		this.stash.setRegistrator(hexStashRegistrator);
		updated();
	}
	
	/**
	 * @return BankView's contentPanel.
	 */
	@Override
	public JPanel getPanelToRegisterController() {
		return this.contentPanel;
	}
	
	@Override
	public void updated() {
		this.stash.updated();
		validate();
	}
}