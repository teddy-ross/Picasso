/**
 * 
 */
package tests.SubtractionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Subtraction;
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
	public void testSubtractionEvaluation() {
		Subtraction myTree = new Subtraction(new X(), new Y());

		
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(1, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0, 1));
		assertEquals(new RGBColor(-0.5, -0.5, -0.5), myTree.evaluate(-1, -0.5));

}
}
