package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.models.BullPen;
import sinon.models.Level;
import sinon.views.BullpenView;

/**
 * This controller responds to mouse interactions with the BullpenView.
 */
public class BullpenController implements MouseListener {

    Level level;
    BullPen bullpen;
    BullpenView bullpenView;

    public BullpenController(BullPen k, BullpenView b, Level level) {
        // TODO better var names
        this.bullpen = k;
        this.bullpenView = b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("I AM A BULLPEN AND I JUST GOT CLICKED ON!");
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
