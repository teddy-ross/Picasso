/**
 * 
 */
package tests.CosineTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.*;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cosine;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
 * 
 * @author Edward Ross
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
	public void cosineFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cosine(x)");
		assertEquals(new Cosine(new X()), e);

		e = parser.makeExpression("cosine( x + y )");
		assertEquals(new Cosine(new Addition(new X(), new Y())), e);
	}
}
