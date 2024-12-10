package tests.PerlinColorTests;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
 * PerlinColor Tests
 * @author Edward Ross
 */
class EvaluatorTests {


	@Test
	public void testPerlinColorEvaluation() {
		PerlinColor myTree = new PerlinColor(new X(), new Y());

		// some straightforward tests
		assertEquals(new RGBColor(Math.cos(.9),Math.cos(.9), Math.cos(.9)), myTree.evaluate(.9, -1));
		assertEquals(new RGBColor(Math.cos(0.5), Math.cos(0.5), Math.cos(0.5)), myTree.evaluate(.5, -1));
		assertEquals(new RGBColor(Math.cos(-.7), Math.cos(-.7), Math.cos(-.7)), myTree.evaluate(-.7, -1));

		
		}
	}


