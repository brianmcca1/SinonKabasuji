package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.moves.MoveToBullpenFromBoard;
import sinon.views.BullpenView;

/**
 * This controller responds to mouse interactions with the BullpenView.
 * Primarily this controller merely handles dropping a piece from the board
 * to the bullpen.
 */
public class BullpenController implements MouseListener {

	Level level;
	BullPen bullpen;
	BullpenView bullpenView;

	public BullpenController(BullPen bullpen, BullpenView view, Level level) {
		this.bullpen = Objects.requireNonNull(bullpen);
		this.bullpenView = Objects.requireNonNull(view);
		this.level = Objects.requireNonNull(level);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("I AM A BULLPEN AND I JUST GOT CLICKED ON!");
		handleClick();
	}

	protected void handleClick() {
		if (level.hasSelected()) {
			Hexomino hex = level.getSelectedHexomino().get();
			int srcAnchorRow, srcAnchorColumn;
			srcAnchorRow = level.getBoard().getHexominoLocation(hex).x;
			srcAnchorColumn = level.getBoard().getHexominoLocation(hex).y;
			MoveToBullpenFromBoard move = new MoveToBullpenFromBoard(level, srcAnchorRow, srcAnchorColumn);
			move.doMove();
			level.pushMove(move);
			level.deselect();
			System.out.println("SELECTED HEXOMINO HAS BEEN DESELECTED");
		}

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
