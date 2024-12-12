
package tests.RgbToYCrCbTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.RgbToYCrCb;

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
	public void testRgbToYCrCbEvaluation() {
		RgbToYCrCb myTree = new RgbToYCrCb(new RGBColor(0.5, 0.3, 0.2));
        RGBColor result = myTree.evaluate(0, 0);

        double r = 0.5 * 0.2989 + 0.3 * 0.5866 + 0.2 * 0.1145;
        double g = 0.5 * -0.1687 + 0.3 * -0.3312 + 0.2 * 0.5;
        double b = 0.5 * 0.5000 + 0.3 * -0.4183 + 0.2 * -0.0816;

        assertEquals(r, result.getRed(), 0.001);
        assertEquals(g, result.getGreen(), 0.001);
        assertEquals(b, result.getBlue(), 0.001);
    }

}
