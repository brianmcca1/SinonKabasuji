package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.views.ReleaseInfoView;

/**
 * Controller for adding Release numbers to a release level.
 * 
 * @author Brian
 *
 */
public class ReleaseInfoViewButtonController implements ActionListener {
	ReleaseLevel level;
	ReleaseInfoView infoView;
	ReleaseNumber releaseNumber;

	/**
	 * Controller for adding ReleaseNumbers to a release level.
	 * 
	 * @param level
	 *            The release level.
	 * @param infoView
	 *            The ReleaseInfoView associated with the controller.
	 * @param releaseNumber
	 *            The ReleaseNumber associated with the controller.
	 */
	public ReleaseInfoViewButtonController(ReleaseLevel level, ReleaseInfoView infoView, ReleaseNumber releaseNumber) {
		this.level = level;
		this.infoView = infoView;
		this.releaseNumber = releaseNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ReleaseNumber copyNumber = new ReleaseNumber(this.releaseNumber.getColor(), this.releaseNumber.getNumber());
		this.level.selectReleaseNumber(copyNumber);
		this.infoView.select(copyNumber);
	}

}
