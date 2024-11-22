package tests.TanTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tan;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.TanToken;

/**
 * Unit tests for the SemanticAnalyzer to verify parsing of tangent expressions.
 * 
 *@author Sylvia Agatako 
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
     * Tests parsing and constructing tangent expressions.
     */
    @Test
    void testParseTangent() {

        // Test for tan(x)
        Stack<Token> tokens = new Stack<>();
        tokens.push(new IdentifierToken("x"));
        tokens.push(new TanToken());

        ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

        assertEquals(new Tan(new X()), actual);

        // Test for tan(y)
        tokens.clear();
        tokens.push(new IdentifierToken("y"));
        tokens.push(new TanToken());

        actual = semAnalyzer.generateExpressionTree(tokens);

        assertEquals(new Tan(new Y()), actual);
    }
}
