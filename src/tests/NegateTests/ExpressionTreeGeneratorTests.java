/**
 * 
 */
package tests.NegateTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.language.expressions.X;


/**
 * 
 * @author Sylvia Agatako
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
	public void negateFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("!x");
		assertEquals(new Negate(new X()), e);
	}
	


}
