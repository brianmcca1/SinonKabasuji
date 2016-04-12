package sinon.models;

import java.awt.Point;

public class Hexonimo extends AbsPiece{
	
		public Hexonimo(Point[] otherSquares, int anchorRow, int anchorColumn){
			super(otherSquares, anchorRow, anchorColumn);
		}
		
		void flipHorizontally(){
			for(int i = 0; i < 6; i++){
				int temp = otherSquares[i].y;
				temp = temp*(-1);
				otherSquares[i].y = temp;
			}
		}
		
		void flipVertically(){
			for(int i = 0; i < 6; i++){
				int temp = otherSquares[i].x;
				temp = temp*(-1);
				otherSquares[i].x = temp;
			}
		}
		
		void rotateC(){
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
		
		void rotateCC(){
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
