package tests.PerlinBWTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.*;

/**
 * Evaluator tests for PerlinBW function.
 * @author Stlvia Agatako
 */
public class EvaluatorTests {

    private PerlinBW perlin;

    @BeforeEach
    public void setUp() {
        X x = new X();
        Y y = new Y();
        perlin = new PerlinBW(x, y);
    }

    @Test
    public void testPerlinBWEvaluation() {
     
        RGBColor result1 = perlin.evaluate(0.5, 0.5);
        assertTrue(result1.getRed() >= 0 && result1.getRed() <= 1);
        assertEquals(result1.getRed(), result1.getGreen());
        assertEquals(result1.getGreen(), result1.getBlue());

        RGBColor result2 = perlin.evaluate(0, 0);
        assertTrue(result2.getRed() >= 0 && result2.getRed() <= 1);
        assertEquals(result2.getRed(), result2.getGreen());
        assertEquals(result2.getGreen(), result2.getBlue());
    }

    @Test
    public void testPerlinBWEdgeCases() {
        
        RGBColor result1 = perlin.evaluate(1, 1);
        assertNotNull(result1);

        RGBColor result2 = perlin.evaluate(-1, -1);
        assertNotNull(result2);
    }

}
