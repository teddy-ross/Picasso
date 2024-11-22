/**
 * 
 */
package tests.SineTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.*;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Sine;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
 * 
 * @author Sarina Cusumano
 */
class ExpressionTreeGeneratorTests {
	
	private ExpressionTreeGenerator parser;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
		
	}

	@Test
	public void sineFunctionTests() {

		ExpressionTreeNode e = parser.makeExpression("sine(x)");
		assertEquals(new Sine(new X()), e);

		e = parser.makeExpression("sine( x + y )");
		assertEquals(new Sine(new Addition(new X(), new Y())), e);
	}
}

