
package tests.YCrCbToRGBTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.YCrCbToRGB;

/**
 * 
 * @author Sylvia Agatako
 */
public class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testYCrCbToRGBEvaluation() {
		YCrCbToRGB myTree = new YCrCbToRGB(new RGBColor(0.5, 0.3, 0.2));
        RGBColor result = myTree.evaluate(0, 0);

        double r = 0.5 + 0.2 * 1.4022;
        double g = 0.5 + 0.3 * -0.3456 + 0.2 * - 0.7145;
        double b = 0.5 + 0.3 * 1.7710;;
       

        assertEquals(r, result.getRed(), 0.001);
        assertEquals(g, result.getGreen(), 0.001);
        assertEquals(b, result.getBlue(), 0.001);
    }

}
