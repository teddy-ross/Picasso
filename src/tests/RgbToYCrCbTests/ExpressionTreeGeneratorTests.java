/**
 * 
 */
package tests.RgbToYCrCbTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.language.expressions.RgbToYCrCb;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;


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
	 public void RgbToYCrCbFunctionTests() {
		
		ExpressionTreeNode e = parser.makeExpression("rgbToYCrCb(x)");
		assertNotNull(new RgbToYCrCb(new X()));
	    assertEquals(new RgbToYCrCb(new X()),e);
	        
        e = parser.makeExpression("rgbToYCrCb( x / y )");
		assertEquals(new RgbToYCrCb(new Division(new X(), new Y())), e);
		}
}
	