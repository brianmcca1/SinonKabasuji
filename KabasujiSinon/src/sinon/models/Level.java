package sinon.models;

import sinon.models.data.LevelData;
import sinon.models.data.LevelType.types;

public class Level {
    int levelNum;
    Board board;
    BullPen bullpen;
    LevelData levelData;
    public Hexomino selectedHexomino;

    public Level(int levelNum, Board b, BullPen bp) {
        this.levelNum = levelNum;
        this.board = b;
        this.bullpen = bp;
    }

    /**
     * Used by the Builder's new level controllers to set the Level field
     * regarding its type
     * 
     * @param t
     *            Enum type of level (puzzle/lightning/release)
     */
    public Level(types t, Board b, BullPen bp) {
        this.levelData = new LevelData(t);
        this.board = b;
        this.bullpen = bp;
    }

    /**
     * @return returns BullPen of this level
     */
    public BullPen getBullpen() {
        return this.bullpen;
    }

    /**
     * Sets the selected hexomino
     * 
     * @param hex
     */
    public void select(Hexomino hex) {
        this.selectedHexomino = hex;
    }

    /**
     * Sets the selected hexomino to empty
     */
    public void deselect() {
        this.selectedHexomino = null;
    }

    /**
     * @return TRUE - There is a selected hexomino FALSE - There is no selected
     *         hexomino
     */
    public boolean hasSelected() {
        return this.selectedHexomino != null;
    }

    public Board getBoard() {
        return board;
    }

}
