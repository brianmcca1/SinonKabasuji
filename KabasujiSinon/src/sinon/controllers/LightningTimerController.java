package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import sinon.models.Level;
import sinon.models.LightningLevel;
import sinon.views.LightningInfoView;

public class LightningTimerController {
	LightningLevel level;
	LightningInfoView infoView;
	Timer theTimer;
	public LightningTimerController(LightningLevel level, LightningInfoView infoView) {
		this.level = level;
		this.infoView = infoView;
	}
	
	public void startTimer(){
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
		new Timer(delay, timer).start();
		
	}
}
