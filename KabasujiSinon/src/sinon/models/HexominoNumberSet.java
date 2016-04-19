package sinon.models;

public class HexominoNumberSet {

    public void flipHorizontally() {
        for (int i = 0; i < 6; i++) {
            int temp = squares[i].x;
            temp = temp * (-1);
            squares[i].x = temp;
        }

    }

    public void flipVertically() {
        for (int i = 0; i < 6; i++) {
            int temp = squares[i].y;
            temp = temp * (-1);
            squares[i].y = temp;
        }
    }

    public void rotateC() {
        for (int i = 0; i < 6; i++) {
            int x = squares[i].x;
            int y = squares[i].y;
            int newX;
            int newY;

            // Perform rotation, Matrix is
            // [0 1]
            // [-1 0]
            newX = y;
            newY = -x;

            // set new location
            squares[i].move(newX, newY);
        }
    }

    public void rotateCC() {
        rotateC();
        rotateC();
        rotateC();
    }

}
