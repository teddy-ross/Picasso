/**
 * 
 */
package tests.CosTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Cos;
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
	public void testCosEvaluation() {
		Cos myTree = new Cos(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.cos(.9),Math.cos(.9), Math.cos(.9)), myTree.evaluate(.9, -1));
		assertEquals(new RGBColor(Math.cos(0.5), Math.cos(0.5), Math.cos(0.5)), myTree.evaluate(.5, -1));
		assertEquals(new RGBColor(Math.cos(-.7), Math.cos(-.7), Math.cos(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double cosineOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(cosineOfTestVal, cosineOfTestVal, cosineOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(cosineOfTestVal, cosineOfTestVal, cosineOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

}

