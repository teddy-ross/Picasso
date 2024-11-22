package tests.CeilTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Ceil;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

/**
 * Unit tests for the Ceil class.
 * 
 * @author  Nisha Walvekar
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
    public void testCeilEvaluation() {
        Ceil myTree = new Ceil(new X());

        // Simple test cases
        assertEquals(new RGBColor(Math.ceil(0.9), Math.ceil(0.9), Math.ceil(0.9)), myTree.evaluate(0.9, -1));
        assertEquals(new RGBColor(Math.ceil(0.5), Math.ceil(0.5), Math.ceil(0.5)), myTree.evaluate(0.5, -1));
        assertEquals(new RGBColor(Math.ceil(-0.7), Math.ceil(-0.7), Math.ceil(-0.7)), myTree.evaluate(-0.7, -1));

        

        // Test with fractional values
        double[] testValues = { -0.7, -0.00001, 0.000001, 0.5 };

        for (double testVal : testValues) {
            double ceilOfTestVal = Math.ceil(testVal);
            assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
            assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, testVal));
        }
    }
}
