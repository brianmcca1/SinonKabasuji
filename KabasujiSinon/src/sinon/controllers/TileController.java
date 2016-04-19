package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import sinon.main.Kabasuji;
import sinon.models.Hexomino;
import sinon.models.Puzzle;
import sinon.views.TileView;

public class TileController implements MouseListener{
	
	Kabasuji kabasuji;
	TileView view;

	public TileController(Kabasuji kabasuji, TileView view) {
		this.kabasuji = kabasuji;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (kabasuji.hasSelected()== true){
			Hexomino hex = kabasuji.selected.get();
			int num = view.num;
			int row = num / 12;
			int col = num % 12;
			col++;
			hex.anchorColumn = col;
			hex.anchorRow = row;
			kabasuji.opened.b.addPiece(hex);
			kabasuji.selected.empty();
		}
		
		if (kabasuji.hasSelected() == false){
			if (kabasuji.opened instanceof Puzzle){
				int num = view.num;
				int row = num / 12;
				int col = num % 12;
				col++;
				if (kabasuji.opened.b.hasHex(row, col)){
					kabasuji.selected = kabasuji.opened.b.getTile(row, col).getHexomino();
					Hexomino hex = kabasuji.selected.get();
					kabasuji.opened.b.removeHexomino(hex);
				}
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO shadows
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO shadows
		
	}


}
