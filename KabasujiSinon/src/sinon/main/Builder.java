package sinon.main;

import java.io.File;
import java.util.Collection;

import javax.swing.JPanel;

import sinon.controllers.BuilderTileController;
import sinon.controllers.BullpenController;
import sinon.models.BullPen;
import sinon.models.data.HexominoBankData;
import sinon.views.MainView;
import sinon.views.TileView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

@SuppressWarnings("serial")
public class Builder extends Kabasuji {

    /** File that is currently being read from / saved to. */
    File currentFile;
    /** JPanel that the builder initially starts out with. */
    public JPanel blankPanel;
    /** BullPen containing all 35 hexominos. */
    BullPen bankData = new BullPen(HexominoBankData.getHexominos());

    Builder() {
        super();
        this.currentFile = null;
        this.blankPanel = new JPanel();
        this.setJMenuBar(new BuilderMenuBar(this, this.blankPanel));
        startSplash("Kabasuji Builder", this.blankPanel);
    }

    public void initializeMainView() {
        MainView mv = new MainView(this.getLevel(), new BankView());

        mv.getBullpenView().setRegistrator(new HexStashRegistrator(
                this.getLevel(), mv, HexStashRegistrator.BULLPEN_CONTROLLER));
        BankView bank = (BankView) mv.getInfoPanel();
        bank.setRegistrator(new HexStashRegistrator(this.getLevel(), mv,
                HexStashRegistrator.BANK_CONTROLLER));

        mv.getBullpenView().contentPanel.addMouseListener(
                new BullpenController(this.getLevel().getBullpen(),
                        mv.getBullpenView(), currentLevel));

        this.setMainView(mv);
        mainView.getBullpenView().addMouseListener(
                new BullpenController(currentLevel.getBullpen(),
                        mainView.getBullpenView(), currentLevel));
        this.startNextPanel(this.blankPanel, mv);
    }

    public void setCurrentFile(File f) {
        this.currentFile = f;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public BullPen getBullpen() {
        return this.bankData;
    }

    /**
     * Registers the BuilderTileControllers to each TileView in the Builder's
     * BoardView.
     */
    @Override
    public void registerBoardViewControllers() {
        Collection<TileView> tileViews = this.mainView.getBoardView()
                .getTileViews();

        for (TileView t : tileViews) {
            t.addMouseListener(new BuilderTileController(t, this.currentLevel,
                    this.mainView.getBoardView()));
        }

    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Builder builder = new Builder();
    }
}
