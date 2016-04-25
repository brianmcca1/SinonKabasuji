package sinon.models;

import sinon.models.data.LevelType.types;

public class LightningLevel extends Level{
	/** Maximum amount of time allowed, in seconds */
	int maxTime;
	/** Time left, in seconds */
	int timeLeft;
	
	
	
	public LightningLevel(int levelNum, Board b, BullPen bp, int maxTime) {
		super(levelNum, types.LIGHTNING, b, bp);
		this.maxTime = maxTime;
		this.timeLeft = maxTime;
		// TODO Auto-generated constructor stub
	} 

}
