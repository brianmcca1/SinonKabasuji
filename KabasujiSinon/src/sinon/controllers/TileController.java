package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;

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
		System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");
		
		/*
		int num = view.num;
		int row = num / 12;
		int col = num % 12;
		col++;
		if (kabasuji.hasSelected()== true){
			Hexomino hex = kabasuji.selected.get();
			hex.anchorColumn = col;
			hex.anchorRow = row;
			if (kabasuji.openedLevel.board.canAddHexomino(hex, row, col)){
				kabasuji.openedLevel.board.addPiece(hex);	
				kabasuji.deselect();
				
			}
			
		}

		if (kabasuji.hasSelected() == false){
			if (kabasuji.openedLevel instanceof Puzzle){
				if (kabasuji.openedLevel.board.hasHex(row, col)){
					kabasuji.select(kabasuji.openedLevel.board.getTile(row, col).getHexomino());
					Hexomino hex = kabasuji.selected.get();
					kabasuji.openedLevel.board.removeHexomino(hex);
				}
			}
		}
		*/
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
