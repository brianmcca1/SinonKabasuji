package sinon.models.data;

public class PuzzleLevelProperty implements LevelProperty {

	public int numMoves;
	
	public PuzzleLevelProperty(int m){
		this.numMoves = m;
	}

	@Override
	public int getPropertyValue() {
		return this.numMoves;
	}
	
}
