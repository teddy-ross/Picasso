
package tests.TanTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Tan;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

/**
 * Unit tests for the Tan class.
 * 
 * @author Sylvia Agatako
 */

class EvaluatorTests {

    /**
     * Sets up the test environment before each test.
     * 
     * @throws Exception if setup fails.
     */
    @BeforeEach
    public void setUp() throws Exception {
    }

    /**
     * Tests the evaluation of the tangent function.
     */
    @Test
    public void testTangentEvaluation() {
        Tan myTree = new Tan(new X());

        // Simple test cases
        assertEquals(new RGBColor(Math.tan(0.9), Math.tan(0.9), Math.tan(0.9)), myTree.evaluate(0.9, -1));
        assertEquals(new RGBColor(Math.tan(0.5), Math.tan(0.5), Math.tan(0.5)), myTree.evaluate(0.5, -1));
        assertEquals(new RGBColor(Math.tan(-0.7), Math.tan(-0.7), Math.tan(-0.7)), myTree.evaluate(-0.7, -1));

        // Test with integer inputs (y-value doesn't matter)
        for (int i = -1; i <= 1; i++) {
            assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, -i));
            assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, i));
        }

        // Test with fractional values
        double[] testValues = { -0.7, -0.00001, 0.000001, 0.5 };

        for (double testVal : testValues) {
            double tanOfTestVal = Math.tan(testVal);
            assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, -1));
            assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, testVal));
        }
    }
}
