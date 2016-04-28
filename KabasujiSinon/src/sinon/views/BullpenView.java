package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.HexStashRegistrator;
import sinon.models.BullPen;

@SuppressWarnings("serial")
public class BullpenView extends JPanel implements StashView, Observer {

	public JScrollPane scrollPanel;
	public JPanel contentPanel;

	HexViewStash stash;

	public BullpenView(BullPen bullpen) {
		initContentPanel();
		initBullpenViewScrollPanel();
		this.setLayout(new GridLayout(1, 1));
		this.add(scrollPanel);
		bullpen.registerObserver(this);
		this.stash = new HexViewStash(Objects.requireNonNull(bullpen),
				contentPanel);
		this.validate();
	}

	private void initBullpenViewScrollPanel() {
		scrollPanel = new JScrollPane();
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollPanel
		.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanel.add(scrollBar);
		scrollPanel
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPanel.setViewportView(contentPanel);
	}

	private void initContentPanel() {
		this.contentPanel = new JPanel();
		contentPanel.setBackground(Color.gray);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
	}

	@Override
	public void setRegistrator(HexStashRegistrator hexStashRegistrator) {
		stash.setRegistrator(Objects.requireNonNull(hexStashRegistrator));
		updated();
	}

	@Override
	public void updated() {
		stash.update();
	}

	@Override
	public JPanel getPanelToRegisterController() {
		return contentPanel;
	}
}
