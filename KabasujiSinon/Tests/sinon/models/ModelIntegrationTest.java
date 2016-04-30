package sinon.models;

import java.awt.Point;
import java.util.ArrayList;

import sinon.moves.MoveToBoardFromBullpen;

public class ModelIntegrationTest {

    BullPen bullpen;
    Hexomino hex1;
    Hexomino hex2;
    Hexomino hex3;
    Hexomino hex4;
    Hexomino hex5;
    Hexomino hex6;
    Board board;

    public ModelIntegrationTest() {
        constructHexominos();
        initializeBullpen();
        initializeBoard();
    }

    void initializeBullpen() {
        ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();
        assert hex1 != null;
        hexList.add(hex1);
        hexList.add(hex2);
        hexList.add(hex3);
        hexList.add(hex4);
        hexList.add(hex5);
        hexList.add(hex6);
        this.bullpen = new BullPen(hexList);
    }

    void constructHexominos() {
        HexominoNumberSet hexset1 = NumberSetFactory.getByNumbers(0, 0, 1, 0, 0,
                1, 1, 1, -1, 1, 0, 2);
        HexominoNumberSet hexset2 = NumberSetFactory.getByNumbers(0, 0, 1, 0, 0,
                1, 1, 1, -1, 1, 0, 2);
        HexominoNumberSet hexset3 = NumberSetFactory.getByNumbers(0, 0, 1, 0, 0,
                1, 1, 1, -1, 1, 0, 2);
        hex1 = new Hexomino(hexset1);
        hex2 = new Hexomino(hexset2);
        hex3 = new Hexomino(hexset3);
        hex1.flipVertically();
        hex2.rotateC();

        hex4 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3,
                0, 1, 1, 1, 2));
        hex4.flipVertically();

        hex5 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 2,
                1, 3, 0, 4, 0));
        hex6 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3,
                0, 4, 0, 5, 0));
    }

    MoveToBoardFromBullpen getMove(Level level, int i) {
        switch (i) {
        case 1:
            return new MoveToBoardFromBullpen(level, 2, 2);
        case 2:
            return new MoveToBoardFromBullpen(level, 5, 1);
        case 3:
            return new MoveToBoardFromBullpen(level, 7, 0);
        case 4:
            return new MoveToBoardFromBullpen(level, 3, 1);
        case 5:
            return new MoveToBoardFromBullpen(level, 2, 0);
        }

        throw new IllegalArgumentException(
                String.format("Given i was not between 1 and %s", 5));
    }

    void initializeBoard() {
        Board b = new Board();

        // Now set the top left box to be playable.
        // it's a 9x4 box that's supposed to be playable.
        Point topLeft1 = new Point(9, 0);
        Point bottomRight1 = new Point(11, 11);
        Point topLeft2 = new Point(0, 4);
        Point bottomRight2 = new Point(11, 11);

        b.setUnplayableRectangle(topLeft1, bottomRight1);
        b.setUnplayableRectangle(topLeft2, bottomRight2);

        b.getTile(new Point(0, 0)).setPlayable(false);
        b.getTile(new Point(0, 2)).setPlayable(false);
        b.getTile(new Point(0, 3)).setPlayable(false);
        b.getTile(new Point(7, 3)).setPlayable(false);
        b.getTile(new Point(8, 2)).setPlayable(false);
        b.getTile(new Point(8, 3)).setPlayable(false);

        this.board = b;
    }

    Board getBoard() {
        return this.board;
    }

    BullPen getBullpen() {
        return this.bullpen;
    }

}
