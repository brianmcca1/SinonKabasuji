package sinon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sinon.controllers.TileController;
import sinon.main.Kabasuji;

public class BoardView extends JPanel{

	JPanel board;
	Kabasuji kabasuji;
	
	public BoardView(){
		initialize();
	}
	
	void initialize(){
		this.board = new JPanel();
		this.board.setLayout(new GridLayout(12,12));
        this.board.setBounds(80, 26, 300, 300);
        this.board.setBackground(Color.BLACK);
        this.board.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        int counter = 1;
        for(int i = 0; i < 12; i++){
        	for(int j = 0; j < 12; j++){
        		TileView tempTile = new TileView(kabasuji.openedLevel.board.getTile(i, j));
        		
        		tempTile.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        		tempTile.setBounds(12*i,12*j,25, 25);
        		tempTile.addMouseListener(new TileController(kabasuji, tempTile));
        		board.add(tempTile);
        		counter++;
        	}
        }
	}
}
