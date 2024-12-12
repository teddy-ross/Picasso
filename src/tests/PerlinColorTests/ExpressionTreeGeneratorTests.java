package tests.PerlinColorTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
/**
 * Expression Tree Generator Test: perlinColor
 * 
 * @author Edward Ross
 */
public class ExpressionTreeGeneratorTests {

	private ExpressionTreeGenerator parser;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
		
	}

	@Test
	public void perlinColorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinColor(x,y)");
		assertEquals(new PerlinColor(new X(), new Y()), e);

		e = parser.makeExpression("perlinColor( x + y, x)");
		assertEquals(new PerlinColor(new Addition(new X(), new Y()), new X()), e);
	}

}
