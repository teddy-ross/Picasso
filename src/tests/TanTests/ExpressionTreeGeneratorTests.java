package tests.TanTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.Tan;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
 * Unit tests for parsing and constructing tangent expressions with the ExpressionTreeGenerator.
 * @author Sylvia Agatako
 * 
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
     * Tests parsing and constructing tangent expressions.
     */
    @Test
    public void tangentFunctionTests() {
        // Test for simple tangent of x
        ExpressionTreeNode e = parser.makeExpression("tan(x)");
        assertEquals(new Tan(new X()), e);

        // Test for tangent of a complex expression: tan(x + y)
        e = parser.makeExpression("tan( x + y )");
        assertEquals(new Tan(new Addition(new X(), new Y())), e);
    }
}
