package tests.TanTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.Tokenizer;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.LeftParenToken;
import picasso.parser.tokens.chars.RightParenToken;
import picasso.parser.tokens.functions.TanToken;

/**
 * Tests that the tangent tokenization process works
 * @author Sylvia Agatako
 *
 */
class TokenizerTest {

    Tokenizer tokenizer;
    List<Token> tokens;

    /**
     * Sets up the Tokenizer instance before each test.
     * 
     * @throws Exception if setup fails.
     */
    @BeforeEach
    void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }

    /**
     * Tests tokenizing a tangent function expression.
     */
    @Test
    public void testTokenizeTangentFunctionExpression() {
        String expression = "tan(x)";
        tokens = tokenizer.parseTokens(expression);

        // Verify tokens are correctly identified
        assertEquals(new TanToken(), tokens.get(0)); 
        assertEquals(new LeftParenToken(), tokens.get(1)); 
        assertEquals(new IdentifierToken("x"), tokens.get(2)); 
        assertEquals(new RightParenToken(), tokens.get(3)); 
    }
}
