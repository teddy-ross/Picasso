package tests.aTanTests;

import static org.junit.jupiter.api.Assertions.*;



import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Atan;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.AtanToken;

/**
 * Unit tests for the SemanticAnalyzer to verify parsing of arc tangent expressions.
 * 
 *@author Sarina Cusumano
 */
class SemanticAnalyzerTest {

    private SemanticAnalyzer semAnalyzer;

    /**
     * Sets up the SemanticAnalyzer instance before each test.
     * 
     * @throws Exception if setup fails.
     */
    @BeforeEach
    void setUp() throws Exception {
        semAnalyzer = SemanticAnalyzer.getInstance();
    }

    /**
     * Tests parsing and constructing arc tangent expressions.
     */
    @Test
    void testParseArcTangent() {

        // Test for atan(x)
        Stack<Token> tokens = new Stack<>();
        tokens.push(new IdentifierToken("x"));
        tokens.push(new AtanToken());

        ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

        assertEquals(new Atan(new X()), actual);

        // Test for atan(y)
        tokens.clear();
        tokens.push(new IdentifierToken("y"));
        tokens.push(new AtanToken());

        actual = semAnalyzer.generateExpressionTree(tokens);

        assertEquals(new Atan(new Y()), actual);
    }
}
