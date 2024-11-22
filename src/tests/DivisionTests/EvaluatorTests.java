/**
 * 
 */
package tests.DivisionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Division;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
/**
 * 
 * @author Edward Ross
 */
class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testDivisionEvaluation() {
		Division myTree = new Division(new X(), new Y());

		
		assertEquals(new RGBColor(0.5,0.5,0.5), myTree.evaluate(1, 2));
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(1, 4));
		assertEquals(new RGBColor(-0.75, -0.75, -0.75), myTree.evaluate(-3, 4));

}
}
