/**
 * Unit tests for parsing and constructing tangent expressions with the ExpressionTreeGenerator.
 * @author Nisha Walvekar
 * 
 */
package tests.ClampTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
 * 
 * @author Sarina Cusumano
 */
class ExpressionTreeGeneratorTests {

    private ExpressionTreeGenerator parser;

    /**
     * Sets up the ExpressionTreeGenerator before each test.
     * 
     * @throws Exception if setup fails.
     */
    @BeforeEach
    void setUp() throws Exception {
        parser = new ExpressionTreeGenerator();
    }

    /**
     * Tests parsing and constructing clamp expressions.
     */
    @Test
    public void clampFunctionTests() {
        // Test for simple ceiling of x
        ExpressionTreeNode e = parser.makeExpression("clamp(x)");
        assertEquals(new Clamp(new X()), e);

        // Test for ceiling of a complex expression: Ceil(x + y)
        e = parser.makeExpression("clamp( x + y )");
        assertEquals(new Clamp(new Addition(new X(), new Y())), e);
    }
} 
