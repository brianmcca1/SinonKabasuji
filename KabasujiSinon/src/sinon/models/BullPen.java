package sinon.models;
import java.util.ArrayList;

public class BullPen {
	@Override
	public String toString() {
		return "BullPen [pieces=" + pieces + "]";
	}

	ArrayList<Hexomino> pieces;
	
	public BullPen(ArrayList<Hexomino> pieces){
		this.pieces = pieces;
	}
	
	public void addHexomino(Hexomino hex){
		pieces.add(hex);
	}
	
	public void removeHexomino(Hexomino hex){
		if(pieces.contains(hex)){
			pieces.remove(hex);
		} else {
			System.err.println("Bullpen does not contain that Hexomino");
		}
	}
	
	public void rotateHexominoClockwise(Hexomino hex){
		if(pieces.contains(hex)){
			hex.rotateC();
		} else {
			System.err.println("Bullpen does not contain that Hexomino");
		}
	}
	
	public void rotateHexominoCounterClockwise(Hexomino hex){
		if(pieces.contains(hex)){
			hex.rotateCC();
		} else {
			System.err.println("Bullpen does not contain that Hexomino");
		}
	}
	
	public void flipHexominoVertical(Hexomino hex){
		if(pieces.contains(hex)){
			hex.flipVertically();
		} else {
			System.err.println("Bullpen does not contain that Hexomino");
		}

	}
	
	public void flipHexominoHorizontal(Hexomino hex){
		if(pieces.contains(hex)){
			hex.flipHorizontally();
		} else {
			System.err.println("Bullpen does not contain that Hexomino");
		}
		
	}
}
