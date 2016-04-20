package sinon.models;

@Deprecated
public class Lightning extends Level {
    int maxTime;
    int usedTime;

    public Lightning(int levelNum, Board b, BullPen bp, int maxTime,
            int usedTime) {
        super(levelNum, b, bp);
        this.maxTime = maxTime;
        this.usedTime = usedTime;
    }
}
