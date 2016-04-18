package sinon.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sinon.models.AbsPiece;
import sinon.models.Hexomino;
import sinon.models.HexominoFactory;

public class HexominoTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * 
	 * @return {[0,0],[0,1],[0,2],[0,3],[0,4],[1,4]}
	 */
	private static Hexomino buildExampleHexomino() {
		return HexominoFactory.buildHexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
	}

	@Test
	public void testFlipHorizontally() {
		Hexomino hex = buildExampleHexomino();
		hex.flipHorizontally();
		AbsPiece expectedFlippedHex = HexominoFactory.buildHexomino(0, 0, 0, 1, 0, 2,
				0, 3, 0, 4, -1, 4);
		assertSame(expectedFlippedHex, hex);
	}

	@Test
	public void testFlipVertically() {
		Hexomino hex = buildExampleHexomino();
		hex.flipVertically();
		AbsPiece expectedFlippedHex = HexominoFactory.buildHexomino(0, 0, 0, -1, 0,
				-2, 0, -3, 0, -4, 1, -4);
		assertSame(expectedFlippedHex, hex);
	}

	@Test
	public void testNormalEquality() {
		AbsPiece hex1 = buildExampleHexomino();
		AbsPiece hex2 = buildExampleHexomino();
		assertSame(hex1, hex2);
	}

	@Test
	public void testUnorderedEquality() {
		AbsPiece hex1 = HexominoFactory.buildHexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0,
				5);
		AbsPiece hex2 = HexominoFactory.buildHexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 5, 0,
				4);
		assertSame(hex1, hex2);
	}

	@Test
	public void testFlippingEquaility() {
		Hexomino hex1 = HexominoFactory.buildHexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0,
				5);
		Hexomino hex2 = HexominoFactory.buildHexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 5, 0,
				4);

		hex1.flipHorizontally();
		hex1.flipHorizontally();
		assertSame(hex1, hex2);
		hex2.flipVertically();
		hex2.flipHorizontally();
		hex1.flipHorizontally();
		hex1.flipVertically();
		assertSame(hex1, hex2);
	}

}
