package sinon.models.data;

public class PuzzleLevelProperty implements LevelProperty {

	private static final long serialVersionUID = 7502352531785165619L;
	public int numMoves;
	
	public PuzzleLevelProperty(int m){
		this.numMoves = m;
	}

	public int getPropertyValue() {
		return this.numMoves;
	}
	
}
