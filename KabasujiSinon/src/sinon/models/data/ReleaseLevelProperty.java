package sinon.models.data;

import java.awt.Point;
import java.util.List;

public class ReleaseLevelProperty implements LevelProperty{

	private static final long serialVersionUID = -3400567687242596430L;
	public List<Point> numberTilePoints;
	
	public ReleaseLevelProperty(List<Point> list){
		this.numberTilePoints = list;
	}

	public int getPropertyValue(){
		return -999;
	}
}
