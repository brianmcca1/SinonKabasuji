package sinon.controllers;

import sinon.main.Kabasuji;
import sinon.views.BullpenView;

public class BullpenController {

	Kabasuji kabasuji;
	BullpenView view;

	public BullpenController(Kabasuji kaba, BullpenView view){
		this.kabasuji = kaba;
		this.view = view;
	}
}
