package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import sinon.models.LightningLevel;
import sinon.views.LightningInfoView;

public class LightningTimerController {
	
	LightningLevel level;
	LightningInfoView infoView;
	public static Timer timer;
	
	public LightningTimerController(LightningLevel level, LightningInfoView infoView) {
		this.level = level;
		this.infoView = infoView;
		this.startTimer(level, this.infoView);
	}
	
	public void startTimer(LightningLevel level, LightningInfoView infoView){
		int delay = 1000;
		ActionListener timer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(level.getTimeLeft() > 0){
					level.tickTimeLeft();
					infoView.updateTimeLeft();
					
				}
				if(level.getTimeLeft() == 0){
					
				}
			}
		};
		Timer t = new Timer(delay, timer);		
		t.start();
		LightningTimerController.timer = t;
		
	}
}
