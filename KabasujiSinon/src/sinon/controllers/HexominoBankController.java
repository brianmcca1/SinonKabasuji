package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.moves.BankToBullpenMove;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to mouse interactions with the HexominoBullpenViews
 * in the bank of the builder.
 * 
 * @author kartik
 */
public class HexominoBankController implements MouseListener {

    BullPen bullpen;
    HexominoBullpenView hexBullpenView;
    Builder builder; // TODO get rid of this field.
    // SUGGESTION morph this class with Hex Bullpen Controller?

    public HexominoBankController(Builder b, BullPen bp, HexominoBullpenView view) {
        this.bullpen = bp;
        this.hexBullpenView = view;
        this.builder = b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("I AM A BANK HEXOMINO AND I GOT CLICKED ON");
        
        BankToBullpenMove move = new BankToBullpenMove(bullpen, hexBullpenView.getHexomino());
        
        if(move.doMove()) {
        	System.out.println("Move was made successfully!");
        } else {
        	System.out.println("For some reason, move was not completed.");
        }
        
        //FIXME we might need to just refresh the views and not actually doing the adding here.
        this.builder.getMainView().getBullpenView().redrawBullpenView();

        System.out.println(this.builder.getLevel().getBullpen().getPieces().toString());
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
