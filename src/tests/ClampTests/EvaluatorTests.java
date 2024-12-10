package tests.ClampTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

/**
 * Unit tests for the Clamp class.
 * 
 * @author  Sarina Cusumano
 * 
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
     * Tests the evaluation of the ceiling function.
     */
    @Test
    public void testClampEvaluation() {
        Clamp myTree = new Clamp(new X());

        // Simple test cases
        assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(2, 2));
        assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-3, -3));
        assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 0));

        

        // Test with fractional values
        double[] testValues = { -0.7, -0.00001, 0.000001, 0.5 };

        for (double testVal : testValues) {
            double ceilOfTestVal = Math.clamp(testVal, testVal, testVal);
            assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
            assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, testVal));
        }
    }
}
