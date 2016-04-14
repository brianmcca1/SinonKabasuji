package sinon.models;

import java.util.List;

public class Board {
    /** */
    List<Hint> hints;
    /** */
    List<Tile> tiles;

    /**
     * 
     * @param tiles
     */
    public Board(List<Tile> tiles) {
        this.tiles = tiles;
        // this.hints = hints;

    }

    /**
     * Determines whether it's possible to add a Hexomino at the given location.
     * 
     * @param hex
     *            The Hexomino to be added
     * @param anchorRow
     *            The row of where the anchor square will go
     * @param anchorColumn
     *            The column number where the anchor square will go
     * @return True if the move if possible, false otherwise.
     */
    public boolean canAddHexomino(Hexomino hex, int anchorRow,
            int anchorColumn) {
        return false;
    }

    public void addPiece(AbsPiece piece, int anchorRow, int anchorColumn) {

        for (int i = 0; i < 6; i++) {
            int deltaX = piece.squares[i].x;
            int deltaY = piece.squares[i].y;

            int row = anchorRow + deltaX;
            int column = anchorColumn + deltaY;

            Tile t = this.getTile(row, column);
            if (t.playable == true) {
                piece.addToTile(t);
            } else {
                System.err.println("Piece is not playable at that location");
            }

        }
    }

    /** */
    public Tile getTile(int row, int column) {
        for (Tile t : tiles) {
            if ((t.row == row) & (t.column == column)) {
                return t;
            }
        }
        return null;
    }

    public void removeHexomino(Hexomino hex) {

        for (Tile t : tiles) {
            if (t.getHexomino().isPresent()) {
                if (t.getHexomino().get() == hex) {
                    t.removeHex();
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Board [tiles=" + tiles + ", hints=" + hints + "]";
    }

}
