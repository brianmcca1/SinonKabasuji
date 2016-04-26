package sinon.models.data;

public class LightningLevelProperty implements LevelProperty {

	public int time;
	
	public LightningLevelProperty(int t){
		this.time = t;
	}

	@Override
	public int getPropertyValue() {
		return this.time;
	}

}
