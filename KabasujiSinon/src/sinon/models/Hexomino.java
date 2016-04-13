package sinon.models;

import java.awt.Point;
import java.util.Arrays;

public class Hexomino extends AbsPiece{
	
		public Hexomino(Point[] otherSquares, int anchorRow, int anchorColumn){
			super(otherSquares, anchorRow, anchorColumn);
		}
		
		@Override
		public String toString() {
			return "Hexonimo [otherSquares=" + Arrays.toString(otherSquares) + ", anchorRow=" + anchorRow
					+ ", anchorColumn=" + anchorColumn + "]";
		}

		// Flip the hexomino over the X axis
		public void flipVertically(){
			for(int i = 0; i < 6; i++){
				int temp = otherSquares[i].y;
				temp = temp*(-1);
				otherSquares[i].y = temp;
			}
		}
		
		// Flip the hexomino over the Y axis
		public void flipHorizontally(){
			for(int i = 0; i < 6; i++){
				int temp = otherSquares[i].x;
				temp = temp*(-1);
				otherSquares[i].x = temp;
			}
		}
		
		// Rotate this hexomino 90 degrees clockwise
		public void rotateC(){
			for(int i = 0; i < 6; i++){
				int x = otherSquares[i].x;
				int y = otherSquares[i].y;
				int newX;
				int newY;
				
				// Perform rotation, Matrix is [0  1]
				//							   [-1 0]
				newX = y;
				newY = -x;
				
				// set new location
				otherSquares[i].move(newX, newY);
				
				
			}
		}
		// Rotate this hexomino 90 degrees counter-clockwise
		public void rotateCC(){
			for(int i = 0; i < 6; i++){
				int x = otherSquares[i].x;
				int y = otherSquares[i].y;
				int newX;
				int newY;
				
				// Perform rotation, Matrix is [0 -1]
				//							   [1  0]
				newX = -y;
				newY = x;
				
				otherSquares[i].move(newX, newY);
			}
		}
		
}
