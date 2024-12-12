/**
 * 
 */
package tests.ExpTests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Exp;
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
	public void testExpEvaluation() {
		Exp myTree = new Exp(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.exp(.2),Math.exp(.2), Math.exp(.2)), myTree.evaluate(.2, -1));
		assertEquals(new RGBColor(Math.exp(0.5), Math.exp(0.5), Math.exp(0.5)), myTree.evaluate(.5, -1));
		assertEquals(new RGBColor(Math.exp(-.8), Math.exp(-.8), Math.exp(-.8)), myTree.evaluate(-.8, -1));

		// test; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {

			double expOfTestVal = Math.exp(testVal);

			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal),
					myTree.evaluate(testVal, testVal));
		}

		
	}
	

}
