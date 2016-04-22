package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;

public class BuilderNewReleaseLevelController implements ActionListener {

	private Builder builder;

	public BuilderNewReleaseLevelController(Builder b){
		this.builder = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("(TEMP) CREATING NEW RELEASE LEVEL");
	}
}
