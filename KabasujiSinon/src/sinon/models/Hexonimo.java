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
			
		}
		
		void rotateCC(){
			 
		}
		
}
