package sinon.main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import sinon.controllers.BuilderRedoController;
import sinon.controllers.BuilderUndoController;
import sinon.controllers.HexStashRegistrator;
import sinon.controllers.ReleaseInfoViewButtonController;
import sinon.controllers.TileRegistrator;
import sinon.models.BullPen;
import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.models.data.HexominoBankData;
import sinon.models.data.LevelType.Types;
import sinon.views.LevelTypeInfoView;
import sinon.views.MainView;
import sinon.views.ReleaseInfoView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the main builder "application" class that extends the superclass
 * {@link Kabasuji}. Therefore it is a JFrame.
 *
 */
@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	/** JPanel that the builder initially starts out with. */
	public JPanel blankPanel;
	/** BullPen containing all 35 hexominos. */
	BullPen bullpen = new BullPen(HexominoBankData.getHexominos());

	/** Construct the builder. */
	public Builder() {

		super();

		this.blankPanel = new JPanel();
		this.setJMenuBar(new BuilderMenuBar(this));
		startSplash("Kabasuji Builder", this.blankPanel);
	}

	/**
	 * Initialize the main view for the builder.
	 * 
	 * @param lvlTypeInfoView
	 *            The levelType info view associated with the MainView.
	 */
	public void initializeMainView(LevelTypeInfoView lvlTypeInfoView) {
		if (this.mainView != null) {
			this.remove(this.mainView);
			this.revalidate();
		}

		MainView mv = new MainView(this.getLevel(), new BankView(), lvlTypeInfoView);
		this.setMainView(mv);
		this.startNextPanel(this.blankPanel, mv);
		initializeControllers();
	}

	/** Registers all of the controllers to the already initialized mainView. */
	private void initializeControllers() {
		// Sets the type of tile register to a builder specific type.
		this.tileRegistrator = new TileRegistrator(getLevel(), mainView);
		this.tileRegistrator.setToBuilderType();
		registerBoardViewControllers();

		if (this.getLevel().getLevelData().getLevelType() == Types.RELEASE) {

			ReleaseInfoView infoView = (ReleaseInfoView) this.getMainView().getLevelTypeInfoView();
			for (JButton j : infoView.getAllButtons()) {
				ReleaseNumber releaseNumber;
				if (j.getForeground() == Color.ORANGE) {
					releaseNumber = new ReleaseNumber(Color.YELLOW, Integer.parseInt(j.getText()));
				} else {
					releaseNumber = new ReleaseNumber(j.getForeground(), Integer.parseInt(j.getText()));
				}
				ReleaseInfoViewButtonController buttonController = new ReleaseInfoViewButtonController(
						(ReleaseLevel) this.getLevel(), infoView, releaseNumber);
				j.addActionListener(buttonController);
			}
		}

		getBankView().setRegistrator(new HexStashRegistrator(getLevel(), getMainView(), true));

		registerBullpenController();
		this.getJMenuBar().getMenu(1).getItem(0).addActionListener(new BuilderUndoController(currentLevel));
		this.getJMenuBar().getMenu(1).getItem(1).addActionListener(new BuilderRedoController(currentLevel));
	}

	/**
	 * Get the Builder's bullpen.
	 * 
	 * @return The Bullpen.
	 */
	public BullPen getBullpen() {
		return this.bullpen;
	}

	/** Main function that is called for the builder application. 
	 * @param args
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}

	/**
	 * Get the Builder's BankView.
	 * 
	 * @return The BankView.
	 */
	private BankView getBankView() {
		assert this.getMainView() != null;
		return (BankView) this.mainView.getInfoPanel();
	}
}
