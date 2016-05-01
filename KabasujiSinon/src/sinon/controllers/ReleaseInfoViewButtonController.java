package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.views.ReleaseInfoView;

/**
 * Controller for adding Release numbers to a release level
 * 
 * @author Brian
 *
 */
public class ReleaseInfoViewButtonController implements ActionListener {
	ReleaseLevel level;
	ReleaseInfoView infoView;
	ReleaseNumber releaseNumber;

	public ReleaseInfoViewButtonController(ReleaseLevel level, ReleaseInfoView infoView, ReleaseNumber releaseNumber) {
		this.level = level;
		this.infoView = infoView;
		this.releaseNumber = releaseNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ReleaseNumber 
		this.level.selectReleaseNumber(new ReleaseNumber(this.releaseNumber.getColor(),);
		System.out.println(this.level.getSelectedReleaseNumber().toString());
	}

}
