package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import sinon.models.LightningLevel;
import sinon.views.LightningInfoView;

/**
 * This is the controller that is responsible for the time-left in a lightning
 * level. It is also responsible for starting off the timer.
 * 
 * @author kartik
 *
 */
public class LightningTimerController {

	LightningLevel level;
	LightningInfoView infoView;
	public static Timer timer;

	/**
	 * The controller for handling the time left in a lightning level
	 * 
	 * @param level
	 *            The level the timer is contained in
	 * @param infoView
	 *            The Lightning info view associated with the timer
	 */
	public LightningTimerController(LightningLevel level, LightningInfoView infoView) {
		this.level = level;
		this.infoView = infoView;
		this.startTimer(level, this.infoView);
	}

	/**
	 * Start the timer
	 * 
	 * @param level
	 *            The level the timer is contained in
	 * @param infoView
	 *            The Lightning info view the timer is associated with
	 */
	public void startTimer(LightningLevel level, LightningInfoView infoView) {
		int delay = 1000;
		ActionListener timer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (level.getTimeLeft() > 0) {
					level.tickTimeLeft();
					infoView.updateTimeLeft();
				}
			}
		};
		Timer t = new Timer(delay, timer);
		t.start();
		LightningTimerController.timer = t;

	}
}
