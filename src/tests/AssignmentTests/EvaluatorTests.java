/**
 * 
 */
package tests.AssignmentTests;

import static org.junit.jupiter.api.Assertions.*;

////import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cos;
//import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cos;
import picasso.parser.language.expressions.Equals;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.operations.EqualsToken;

/**
 * 
 * @author Nisha Walvekar
 */
class EvaluatorTests {
	
	String testVar = new String("a");
	X x = new X();
	Y y = new Y();

	@Test
	public void testEqualsTokenFunction() {
		EqualsToken token = new EqualsToken();
		assertTrue(token.isFunction()== false);
	}
	@Test
	public void testEqualsTokenNotConstant() {
		EqualsToken token = new EqualsToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testEqualsEvaluation() {
		Equals myTree = new Equals(testVar, x);

		// some straightforward tests
		assertEquals(new RGBColor(0.3, 0.3, 0.3), myTree.evaluate(.3, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, -1));

		}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}


	@Test
	public void testCosineEvaluation() {
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


