package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import sinon.models.Board;

public class BoardView extends JPanel {

    JPanel boardPanel;
    private Board board;
    Collection<TileView> tileViews;

    public BoardView(Board board) {
        this.board = board;
        this.boardPanel = new JPanel();
        this.boardPanel.setLayout(new GridLayout(12, 12));
        this.boardPanel.setBounds(80, 26, 300, 300);
        this.boardPanel.setBackground(Color.BLACK);
        this.boardPanel
                .setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.tileViews = new ArrayList<TileView>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                initializeTileView(i, j);
            }
        }
    }

    /**
     * Initializes a tile view at the given row column.
     * 
     * @param row
     * @param column
     */
    private void initializeTileView(int row, int column) {
        TileView tileView = new TileView(board.getTile(row, column));
        this.tileViews.add(tileView);
        boardPanel.add(tileView);
    }

    public Collection<TileView> getTileViews() {
        return tileViews;
    }

    public void redrawTiles() {
        for (TileView tv : this.tileViews) {
            if (board.getTile(tv.row, tv.column).hasHex()) {
                // TODO temporary logic for color.
                tv.setColor(Color.blue);
            }
        }
    }
}
