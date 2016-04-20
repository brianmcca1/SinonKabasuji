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
        		TileView temp = new TileView(counter);
        		
    			if(counter == 0)
    				temp.setBackground(Color.blue);
    			if(counter == 12)
    				temp.setBackground(Color.green);
    			if(counter == 24)
    				temp.setBackground(Color.yellow);
    			if(counter == 36)
    				temp.setBackground(Color.black);
    			if(counter == 48)
    				temp.setBackground(Color.red);
    			if(counter == 60)
    				temp.setBackground(Color.gray);
    			if(counter == 72)
    				temp.setBackground(Color.blue);
    			if(counter == 84)
    				temp.setBackground(Color.red);
    			if(counter == 96)
    				temp.setBackground(Color.black);
    			if(counter == 108)
    				temp.setBackground(Color.green);
    			if(counter == 120)
    				temp.setBackground(Color.yellow);
    			if(counter == 132)
    				temp.setBackground(Color.GRAY);
    			if(counter == 144)
    				temp.setBackground(Color.blue);
    			
 
    			if(counter == 1)
    				temp.setBackground(Color.green);
    			if(counter == 2)
    				temp.setBackground(Color.yellow);
    			if(counter == 3)
    				temp.setBackground(Color.black);
    			if(counter == 4)
    				temp.setBackground(Color.red);
    			if(counter == 5)
    				temp.setBackground(Color.green);
    			if(counter == 6)
    				temp.setBackground(Color.cyan);
    			if(counter == 7)
    				temp.setBackground(Color.blue);
    			if(counter == 8)
    				temp.setBackground(Color.red);
    			if(counter == 9)
    				temp.setBackground(Color.black);
    			if(counter == 10)
    				temp.setBackground(Color.green);
    			if(counter == 11)
    				temp.setBackground(Color.yellow);
    			if(counter == 12)
    				temp.setBackground(Color.GRAY);
    			
    			
        		temp.setBounds(12*i,12*j,32,32);
        		temp.addMouseListener(new TileController(kabasuji, temp));
        		board.add(temp);
        		flipper = !flipper;
        		counter++;
        	}
        }
	}
}
