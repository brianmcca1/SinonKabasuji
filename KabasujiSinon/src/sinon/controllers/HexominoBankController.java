package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.views.BullpenView;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to mouse interactions with the HexominoBullpenViews
 * in the bank of the builder.
 * 
 * @author kartik
 */
public class HexominoBankController implements MouseListener {

    BullPen bullpen;
    BullpenView bpview;
    HexominoBullpenView hexBullpenView;
    Hexomino hex;

    public HexominoBankController(BullPen bp, Hexomino hex, BullpenView bpview,
            HexominoBullpenView view) {
        this.bullpen = bp;
        this.hexBullpenView = view;
        this.hex = hex;
        this.bpview = bpview;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("I AM A BANK HEXOMINO AND I GOT CLICKED ON");
        bullpen.addHexomino(hex);
        System.out.println(bullpen.getPieces().toString());

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
