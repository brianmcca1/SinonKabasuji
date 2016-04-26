package sinon.models.data;

public class LightningLevelProperty<Integer> implements LevelProperty {

	private static final long serialVersionUID = -1510251264746958369L;
	public Integer time;
	
	public LightningLevelProperty(Integer t){
		this.time = t;
	}

	@Override
	public Integer getPropertyValue() {
		return (Integer)this.time;
	}

}
