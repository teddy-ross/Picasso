package tests.aTanTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.Atan;
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
    public void ArctanFunctionTests() {
        // Test for simple arc tangent of x
        ExpressionTreeNode e = parser.makeExpression("atan(x)");
        assertEquals(new Atan(new X()), e);

        e = parser.makeExpression("atan(x+y)");
        assertEquals(new Atan(new Addition(new X(), new Y())), e);
    }
}
