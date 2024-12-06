/**
 * 
 */
package tests.LogTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.*;

/**
 * 
 * 
 * @author Sanjog Basnet
 */
public class EvaluatorTests {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}
	@Test
	public void testLogEvaluation() {
		Log myTree = new Log(new Y());
		
		//straight Y evaluation tests
		assertEquals(new RGBColor(0,0,0) , myTree.evaluate(1, 1));
		assertEquals(new RGBColor(Math.log(0.4),Math.log(0.4),Math.log(0.4)), myTree.evaluate(1, 0.4));
		
		//same for X
		Log myTree2 = new Log(new X());
		assertEquals(new RGBColor(0,0,0) , myTree.evaluate(1, 1));
		assertEquals(new RGBColor(Math.log(0.4),Math.log(0.4),Math.log(0.4)), myTree2.evaluate(0.4, 0.4));

		
	}

}
