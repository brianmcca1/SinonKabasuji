package sinon.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelIntegrationTest {

	Hexomino hex1;
	Hexomino hex2;
	Hexomino hex3;
	Hexomino hex4;
	Hexomino hex5;
	Hexomino hex6;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void constructHexominos() {
		HexominoNumberSet hexset1 = NumberSetFactory.getByNumbers(0, 0, 1, 0, 0, 1, 1, 1, -1, 1, 0, 2);
		hex1 = new Hexomino(hexset1);
		hex2 = new Hexomino(hexset1);
		hex3 = new Hexomino(hexset1);
		hex1.flipVertically();
		hex2.rotateC();
		
		hex4 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 1, 1, 1, 2));
		hex4.flipVertically();
		
		hex5 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 2, 1, 3, 0, 4, 0));
		hex6 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
	}
	
}
