package sinon.models.data;

public class LightningLevelProperty implements LevelProperty {

	private static final long serialVersionUID = -1510251264746958369L;
	public int time;
	
	public LightningLevelProperty(int t){
		this.time = t;
	}

	public int getPropertyValue() {
		return this.time;
	}

}
