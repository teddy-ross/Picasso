/**
 * 
 */
package tests.SineTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Sine;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

/**
 * 
 * @author Edward Ross
 */
class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testSineEvaluation() {
		Sine myTree = new Sine(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.sin(.9),Math.sin(.9), Math.sin(.9)), myTree.evaluate(.9, -1));
		assertEquals(new RGBColor(Math.sin(0.5), Math.sin(0.5), Math.sin(0.5)), myTree.evaluate(.5, -1));
		assertEquals(new RGBColor(Math.sin(-.7), Math.sin(-.7), Math.sin(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.s(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double sineOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(sineOfTestVal, sineOfTestVal, sineOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(sineOfTestVal, sineOfTestVal, sineOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

}

