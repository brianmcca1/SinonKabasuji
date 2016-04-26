package sinon.models.data;

import java.util.List;

public class ReleaseLevelProperty<List> implements LevelProperty{
	
	public List numberTilePoints;
	
	public ReleaseLevelProperty(List list){
		this.numberTilePoints = list;
	}

	@Override
	public List getPropertyValue() {
		return this.numberTilePoints;
	}
	
}
