/**
 * 
 */
package tests.DivisionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
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
	public void divisionFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("x / y");
		assertEquals(new Division(new X(), new Y()), e);
	}

}
