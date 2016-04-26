package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * Is the controller which gets added to Bullpen Hexominos and Bank Hexominos.
 */
public abstract class AbstractHexStashController implements MouseListener {

    /** Current level that the game/builder is in. */
    Level level;
    /** MainView associated with the current level */
    MainView mainView;
    /** HexominoView associated with this controller. */
    HexominoBullpenView hex;

    public AbstractHexStashController(Level level, MainView mainView,
            HexominoBullpenView hex) {
        this.level = Objects.requireNonNull(level);
        this.mainView = Objects.requireNonNull(mainView);
        this.hex = Objects.requireNonNull(hex);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
        handleClicked();
    }

    protected abstract void handleClicked();

    @Override
    public void mousePressed(MouseEvent e) {
    };

    @Override
    public void mouseReleased(MouseEvent e) {
    };

    @Override
    public void mouseEntered(MouseEvent e) {
    };

    @Override
    public void mouseExited(MouseEvent e) {
    };

}
