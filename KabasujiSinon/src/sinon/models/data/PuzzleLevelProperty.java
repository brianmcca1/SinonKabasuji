package sinon.models.data;

public class PuzzleLevelProperty<Integer> implements LevelProperty {

	private static final long serialVersionUID = 7502352531785165619L;
	public Integer numMoves;
	
	public PuzzleLevelProperty(Integer m){
		this.numMoves = m;
	}

	@Override
	public Integer getPropertyValue() {
		return this.numMoves;
	}
	
}
