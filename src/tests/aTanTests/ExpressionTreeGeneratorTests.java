package tests.aTanTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.aTan;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
 * Unit tests for parsing and constructing  arc tangent expressions with the ExpressionTreeGenerator.
 * @author Sarina Cusumano
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
        // Test for simple arc tangent of x
        ExpressionTreeNode e = parser.makeExpression("atan(x)");
        assertEquals(new aTan(new X()), e);

        // Test for arc tangent of a complex expression: tan(x + y)
        e = parser.makeExpression("tan( x + y )");
        assertEquals(new aTan(new Addition(new X(), new Y())), e);
    }
}
