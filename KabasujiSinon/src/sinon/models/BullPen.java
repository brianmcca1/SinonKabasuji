package sinon.models;

import java.util.ArrayList;

public class BullPen {

    /** ArrayList of all the hexominos that will be in this level's bullpen. */
    ArrayList<Hexomino> pieces;

    public BullPen(ArrayList<Hexomino> pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "BullPen [pieces=" + pieces + "]";
    }

    /**
     * Getter that returns all the hexominos in the bullpen
     */
    public ArrayList<Hexomino> getPieces() {
        return this.pieces;
    }

    public void addHexomino(Hexomino hex) {
        pieces.add(hex);
    }

    public void removeHexomino(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            this.pieces.remove(hex);
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }
    }

    public void rotateHexominoClockwise(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.rotateC();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }
    }

    public void rotateHexominoCounterClockwise(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.rotateCC();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }
    }

    public void flipHexominoVertical(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.flipVertically();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }

    }

    public void flipHexominoHorizontal(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.flipHorizontally();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }

    }
}
