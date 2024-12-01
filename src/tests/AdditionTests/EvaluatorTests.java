/**
 * 
 */
package tests.AdditionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Addition;
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
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());

		
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, 1));
		assertEquals(new RGBColor(-2, -2, -2), myTree.evaluate(-1, -1));

}
}
