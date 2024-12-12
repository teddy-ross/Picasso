
package tests.YCrCbToRGBTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.YCrCbToRGB;

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
	 public void YCrCbToRGBFunctionTests() {
		
		ExpressionTreeNode e = parser.makeExpression("yCrCbToRGB(x)");
	    assertNotNull(new YCrCbToRGB(new X()));
	    
	    assertEquals(new YCrCbToRGB(new X()),e);
	        
        e = parser.makeExpression("yCrCbToRGB( x / y )");
        
		
		System.out.print(e);
		System.out.print(new YCrCbToRGB(new Division(new X(), new Y())));
		assertEquals(new YCrCbToRGB(new Division(new X(), new Y())), e);
		}
}
	