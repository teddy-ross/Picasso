/**
 * 
 */
package tests.MultiplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Multiplication;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
/**
 * 
 * @author Edward Ross
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
	public void testMultiplicationEvaluation() {
		Multiplication myTree = new Multiplication(new X(), new Y());


		assertEquals(new RGBColor(0.5,0.5,0.5), myTree.evaluate(0.25, 2));
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(0.5, 0.5));
		assertEquals(new RGBColor(-0.5, -0.5, -0.5), myTree.evaluate(-1, 0.5));

	}
}
