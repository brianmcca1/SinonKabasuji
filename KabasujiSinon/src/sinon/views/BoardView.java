package sinon.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sinon.main.Kabasuji;

public class BoardView extends JPanel{

	JPanel board;
	Kabasuji kabasuji;
	
	public BoardView(){
		
	}
	
	void initialize(){
		this.board = new JPanel();
		board.setLayout(new GridLayout(12, 12));
		
		for(int i = 0; i < 144; i++){
			TileView temp = new TileView();
			temp.addMouseListener(new TileController(kabasuji, temp));;
			board.add(temp);
		}
	}
}
