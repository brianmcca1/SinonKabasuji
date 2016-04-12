package sinon.main;

import java.util.Stack;

import sinon.models.Level;

public class Kabasuji {

	//COMMON VIEWS AND MODELS BETWEEN BOTH BUILDER AND GAME GO HERE
	Stack undo = new Stack();
	Stack redo = new Stack();
	public Level[] levels = new Level[15];
	
	//COMMON OPERATIONS BETWEEN BOTH BUILDER AND GAME GO HERE
	//void openLevel(int levelNum);
	
	
}
