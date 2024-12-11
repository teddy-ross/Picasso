/**
 * 
 */
package tests.ExponentiateTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Exponentiate;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
/**
 * 
 * @author Sarina Cusumano
 */
class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testExponentiateEvaluation() {
		Exponentiate myTree = new Exponentiate(new X(), new Y());

		
		assertEquals(new RGBColor(1,1,1), myTree.evaluate(1, 2));
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(.5, 2));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 3));

}
}
