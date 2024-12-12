/**
 * 
 */
package tests.AnimateTests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Animate;
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
	public void testAnimateEvaluation() {
		Animate myTree = new Animate(new X());

		// some straightforward tests
		assertEquals(new RGBColor(1,1,1), myTree.evaluate(1, 1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, -1));

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {

			assertEquals(new RGBColor(testVal, testVal, testVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(testVal, testVal, testVal),
					myTree.evaluate(testVal, testVal));
		}

		
	}
	

}
