/**
 * 
 */
package tests.ModuloTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Modulo;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
/**
 * 
 * @author Sanjog Basnet
 */
class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testModuloEvaluation() {
		Modulo myTree = new Modulo(new X(), new Y());

		assertEquals(new RGBColor(0,0,0), myTree.evaluate(2, 2));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(3, 2));
		assertEquals(new RGBColor(3, 3, 3), myTree.evaluate(7, 4));

}
}
