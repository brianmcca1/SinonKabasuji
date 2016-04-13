package sinon.controllers;

import sinon.main.Kabasuji;
import sinon.views.BoardView;
import sinon.views.HexominoView;

public class HexominoController {

	Kabasuji kabasuji;
	HexominoView view;

	public HexominoController(Kabasuji kaba, HexominoView view){
		this.kabasuji = kaba;
		this.view = view;
	}
}
