package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
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

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                initializeTile(i, j);
            }
        }
    }

    private void initializeTile(int row, int column) {
        TileView tileView = new TileView(board.getTile(row, column));
        // FIXME this is just sort of there.
        // tileView.addMouseListener(
        // new TileController(kabasuji.openedLevel, tileView, null));

        tileView.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        tileView.setBounds(12 * row, 12 * column, 25, 25); // TODO this is in
                                                           // absolute
                                                           // positioning?

        boardPanel.add(tileView);
    }

    public Collection<TileView> getTileViews() {
        return tileViews;
    }

}
