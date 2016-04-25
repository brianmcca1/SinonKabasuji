package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import sinon.main.Kabasuji;
import sinon.models.Board;

public class BoardView extends JPanel {
	
	JPanel boardPanel;
    private Board board;
    Collection<TileView> tileViews;
    private Kabasuji kabasuji;

    public BoardView(Kabasuji k, Board board) {
        this.board = board;
        this.kabasuji = k;
        this.boardPanel = new JPanel();
        this.boardPanel.setLayout(new GridLayout(12, 12));
        this.boardPanel.setBounds(80, 26, 300, 300);
        this.boardPanel.setBackground(Color.BLACK);
        this.boardPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.tileViews = new ArrayList<TileView>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                initializeTile(i, j);
            }
        }
    }

    private void initializeTile(int row, int column) {
        TileView tileView = new TileView(board.getTile(row, column));

        tileView.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.tileViews.add(tileView);
        boardPanel.add(tileView);
    }

    public Collection<TileView> getTileViews() {
        return tileViews;
    }

    public void redrawTiles(){
    	for(TileView tv: this.tileViews) {
    		if(board.getTile(new Point(tv.row, tv.column)).hasHex()) {
    			tv.setColor(Color.blue);
    		}
    	}
    }
}
