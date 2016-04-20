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
        this.board.setBounds(30, 26, 384, 384);
        this.board.setBackground(Color.BLACK);
        this.board.setBorder(BorderFactory.createLineBorder(Color.black));
        
        int counter = 0;
        boolean flipper = true;
        for(int i = 0; i < 12; i++){
        	for(int j = 0; j < 12; j++){
        		TileView tempTile = new TileView(counter);
        		
    			if(counter == 0)
    				tempTile.setBackground(Color.blue);
    			if(counter == 12)
    				tempTile.setBackground(Color.green);
    			if(counter == 24)
    				tempTile.setBackground(Color.yellow);
    			if(counter == 36)
    				tempTile.setBackground(Color.black);
    			if(counter == 48)
    				tempTile.setBackground(Color.red);
    			if(counter == 60)
    				tempTile.setBackground(Color.gray);
    			if(counter == 72)
    				tempTile.setBackground(Color.blue);
    			if(counter == 84)
    				tempTile.setBackground(Color.red);
    			if(counter == 96)
    				tempTile.setBackground(Color.black);
    			if(counter == 108)
    				tempTile.setBackground(Color.green);
    			if(counter == 120)
    				tempTile.setBackground(Color.yellow);
    			if(counter == 132)
    				tempTile.setBackground(Color.GRAY);
    			if(counter == 144)
    				tempTile.setBackground(Color.blue);
    			
 
    			if(counter == 1)
    				tempTile.setBackground(Color.green);
    			if(counter == 2)
    				tempTile.setBackground(Color.yellow);
    			if(counter == 3)
    				tempTile.setBackground(Color.black);
    			if(counter == 4)
    				tempTile.setBackground(Color.red);
    			if(counter == 5)
    				tempTile.setBackground(Color.green);
    			if(counter == 6)
    				tempTile.setBackground(Color.cyan);
    			if(counter == 7)
    				tempTile.setBackground(Color.blue);
    			if(counter == 8)
    				tempTile.setBackground(Color.red);
    			if(counter == 9)
    				tempTile.setBackground(Color.black);
    			if(counter == 10)
    				tempTile.setBackground(Color.green);
    			if(counter == 11)
    				tempTile.setBackground(Color.yellow);
    			if(counter == 12)
    				tempTile.setBackground(Color.GRAY);
    			
    			
        		tempTile.setBounds(12*i,12*j,32,32);
        		tempTile.addMouseListener(new TileController(kabasuji, tempTile));
        		board.add(tempTile);
        		flipper = !flipper;
        		counter++;
        	}
        }
	}
}
