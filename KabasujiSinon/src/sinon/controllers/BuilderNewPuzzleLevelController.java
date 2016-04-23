package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;
import sinon.views.MainView;
import sinon.views.builder.BankView;

public class BuilderNewPuzzleLevelController implements ActionListener{

	private Builder builder;
	
	private JPanel blankPanel;

	public BuilderNewPuzzleLevelController(Builder b, JPanel bPanel){
		this.builder = b;
		this.blankPanel = bPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW PUZZLE LEVEL");
		this.builder.startNextPanel(this.blankPanel, new MainView(this.builder, new BankView(this.builder)));
		this.builder.setCurrentLevel(new Level(types.PUZZLE, new Board(), new BullPen(new BullPenData())));
	}
}