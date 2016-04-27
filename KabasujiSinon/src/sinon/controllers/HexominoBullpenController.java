package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.moves.MoveToBullpenFromBoard;
import sinon.views.BullpenView;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * This controller responds to mouse interactions with HexominoBullpenViews in
 * the BullpenView.
 */
public class HexominoBullpenController implements MouseListener {

    /** View associated with this controller. */
    HexominoBullpenView hexBullpenView;

    /** View associated with the Bullpen that contains this hexomino. */
    BullpenView bpview;

    /** Current level that the game/builder is in. */
    Level level;

    /** Hexomino model that's associated with this controller. */
    Hexomino hex;

    MainView mainView;

    public HexominoBullpenController(HexominoBullpenView view, Level level,
            BullpenView bullpenView, MainView mainView) {
        this.hexBullpenView = view;
        this.hex = hexBullpenView.getHexomino();
        this.level = level;
        this.bpview = bullpenView;
        this.mainView = Objects.requireNonNull(mainView);
    }

    /**
     * Event where a hexomino gets selected from the bullpen.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out
                .println("I AM A BULLPEN HEXOMINO AND I JUST GOT CLICKED ON!");

        // FIXME A new move is NOT always created when you click on the bullpen
        if (level.hasSelected()) {
            // compare this.hex to level.selectedHexomino.get()
            if (this.level.getBullpen()
                    .containsHexID(level.getSelectedHexomino().get().getID())) {
                System.out.println("THIS HEXOMINO IS ALREADY SELECTED");
                return;
            }

            int x, y;
            if (level.getBoard().hasHex(level.getSelectedHexomino().get())) {
                x = level.getBoard().getHexominoLocation(
                        level.getSelectedHexomino().get()).x;
                y = level.getBoard().getHexominoLocation(
                        level.getSelectedHexomino().get()).y;
                MoveToBullpenFromBoard move = new MoveToBullpenFromBoard(level,
                        x, y);
                move.doMove();
            } else {
                level.getBullpen()
                        .addHexomino(level.getSelectedHexomino().get());
            }

            // For when we have the stack for undo
            // level.push(move);

            // Commented out old working stuff
            // Hexomino alreadySelected = level.selectedHexomino.get();
            // this.level.getBullpen().addHexomino(alreadySelected);
            bpview.redrawBullpenView();
            // level.deselect();
            System.out.println("SELECTED HEXOMINO HAS BEEN DESELECTED");
        } else {
            level.select(hex);
            System.out.println("NEWLY SELECTED HEXOMINO: "
                    + level.getSelectedHexomino().toString());
        }

        bpview.redrawBullpenView();
        mainView.getBoardView().redrawTiles();
        // need to redraw tiles as well
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
