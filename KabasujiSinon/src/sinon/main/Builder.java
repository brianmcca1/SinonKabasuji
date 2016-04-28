package sinon.main;

import javax.swing.JPanel;

import sinon.controllers.BullpenController;
import sinon.controllers.HexStashRegistrator;
import sinon.controllers.TileRegistrator;
import sinon.models.BullPen;
import sinon.models.data.HexominoBankData;
import sinon.views.LevelTypeInfoView;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	/** JPanel that the builder initially starts out with. */
	public JPanel blankPanel;
	/** BullPen containing all 35 hexominos. */
	BullPen bullpen = new BullPen(HexominoBankData.getHexominos());

	public Builder() {

		super();

		this.blankPanel = new JPanel();
		this.setJMenuBar(new BuilderMenuBar(this, this.blankPanel));
		startSplash("Kabasuji Builder", this.blankPanel);
	}

	public void initializeMainView(LevelTypeInfoView lvlTypeInfoView) {
		if (this.mainView != null) {
			this.remove(this.mainView);
			this.revalidate();
		}

		MainView mv = new MainView(this.getLevel(), new BankView(),
				lvlTypeInfoView);
		this.setMainView(mv);
		this.mainView.revalidate();
		this.startNextPanel(this.blankPanel, mv);
		this.tileRegistrator = new TileRegistrator(getLevel(), mainView);
		this.tileRegistrator.setToBuilderType();
		registerBoardViewControllers();

		((BankView) this.mainView.getInfoPanel())
		.setRegistrator(new HexStashRegistrator(getLevel(),
				getMainView(), true));

		this.mainView.getBullpenView().setRegistrator(
				new HexStashRegistrator(getLevel(), getMainView(), false));

		this.getMainView()
		.getBullpenView()
		.getPanelToRegisterController()
		.addMouseListener(
				new BullpenController(this.getLevel().getBullpen(),
						this.getMainView().getBullpenView(), getLevel()));
	}

	public BullPen getBullpen() {
		return this.bullpen;
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Kabasuji builder = new Builder();
	}
}
