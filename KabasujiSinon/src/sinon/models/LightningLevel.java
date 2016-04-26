package sinon.models;

import sinon.models.data.LevelType.types;

public class LightningLevel extends Level{
	/** Maximum amount of time allowed, in seconds */
	int maxTime;
	/** Time left, in seconds */
	int timeLeft;
	
	
	
	public LightningLevel(Board b, BullPen bp, int maxTime) {
		super(types.LIGHTNING, b, bp);
		this.maxTime = maxTime;
		this.timeLeft = maxTime;
		// TODO Auto-generated constructor stub
	} 
	
	public int countStars(){
		int numNotPlayed = 0;
		for (Tile t : this.board.getTiles()){
			if (!t.hasHex()){
				numNotPlayed++;
			}
		}
		
		
		if (numNotPlayed == 0){
			return 3;
		}
		
		if (numNotPlayed <= 6){
			return 2;
		}
		
		if (numNotPlayed <= 12){
			return 1;
		}
		
		return 0;
	}


}
