/**
 * 
 */
package tests.SinTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Sin;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

/**
 * 
 * @author Sarina Cusumano
 */
class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testSinEvaluation() {
		Sin myTree = new Sin(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.sin(.2),Math.sin(.2), Math.sin(.2)), myTree.evaluate(.2, -1));
		assertEquals(new RGBColor(Math.sin(0.5), Math.sin(0.5), Math.sin(0.5)), myTree.evaluate(.5, -1));
		assertEquals(new RGBColor(Math.sin(-.8), Math.sin(-.8), Math.sin(-.8)), myTree.evaluate(-.8, -1));

		// test; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {

			double sineOfTestVal = Math.sin(testVal);

			assertEquals(new RGBColor(sineOfTestVal, sineOfTestVal, sineOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(sineOfTestVal, sineOfTestVal, sineOfTestVal),
					myTree.evaluate(testVal, testVal));
		}

		
	}
	

}
