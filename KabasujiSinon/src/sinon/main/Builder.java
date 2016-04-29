package sinon.main;

import javax.swing.JPanel;

import sinon.controllers.BuilderRedoController;
import sinon.controllers.BuilderUndoController;
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
		this.setJMenuBar(new BuilderMenuBar(this));
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
		this.startNextPanel(this.blankPanel, mv);
		initializeControllers();
	}

	/** Registers all of the controllers to the already initialized mainView */
	private void initializeControllers() {
		// Sets the type of tile register to a builder specific type.
		this.tileRegistrator = new TileRegistrator(getLevel(), mainView);
		this.tileRegistrator.setToBuilderType();
		registerBoardViewControllers();

		getBankView().setRegistrator(
				new HexStashRegistrator(getLevel(), getMainView(), true));

		registerBullpenController();
		this.getJMenuBar().getMenu(1).getItem(0).addActionListener(new BuilderUndoController(currentLevel));
		this.getJMenuBar().getMenu(1).getItem(1).addActionListener(new BuilderRedoController(currentLevel));
	}

	public BullPen getBullpen() {
		return this.bullpen;
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}

	private BankView getBankView() {
		assert this.getMainView() != null;
		return (BankView) this.mainView.getInfoPanel();
	}
}
