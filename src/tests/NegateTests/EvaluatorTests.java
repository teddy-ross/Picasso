/**
 * 
 */
package tests.NegateTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Negate;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

/**
 * Tests for the negate function evaluation. 
 * @author Sylvia Agatako
 */
class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
    public void testNegateEvaluation() {
		Negate myTree = new Negate(new X());
		
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(-0.25, -0.25));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(1, 1));
	}


	
}
