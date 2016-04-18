package sinon.models;

import java.awt.Point;

public class Hexomino extends AbsPiece {

	public Hexomino(Point[] squares) {
		super(squares);
	}

	@Override
	void addToTile(Tile t) {
		t.addHexomino(this);
	}

	// Flip the hexomino over the Y axis
	public void flipHorizontally() {
		for (int i = 0; i < 6; i++) {
			int temp = squares[i].x;
			temp = temp * (-1);
			squares[i].x = temp;
		}
	}

	// Flip the hexomino over the X axis
	public void flipVertically() {
		for (int i = 0; i < 6; i++) {
			int temp = squares[i].y;
			temp = temp * (-1);
			squares[i].y = temp;
		}
	}

	// Rotate this hexomino 90 degrees clockwise
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

	// Rotate this hexomino 90 degrees counter-clockwise
	public void rotateCC() {
		for (int i = 0; i < 6; i++) {
			int x = squares[i].x;
			int y = squares[i].y;
			int newX;
			int newY;

			// Perform rotation, Matrix is
			// [0 -1]
			// [1 0]
			newX = -y;
			newY = x;

			squares[i].move(newX, newY);
		}

	}
}
