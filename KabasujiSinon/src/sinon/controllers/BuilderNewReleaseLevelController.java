package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;
import sinon.views.ReleaseInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller that handles the opening of a new release level in the builder.
 * 
 */
public class BuilderNewReleaseLevelController extends BuilderNewLevelController implements ActionListener {

	/** The builder application that is associated with this controller. */
	private Builder builder;

	/** This controller is fired from an option in this menu bar. */
	private BuilderMenuBar builderMenuBar;

	public BuilderNewReleaseLevelController(Builder b, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW RELEASE LEVEL");
		this.builder.setLevel(new Level(types.RELEASE, new Board(), new BullPen(new BullPenData())));
		this.handleNewLevel(this.builder, this.builderMenuBar, new ReleaseInfoView());
	}
}
