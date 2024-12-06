/**
 * 
 */
package tests.ClampTests;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.Tokenizer;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.LeftParenToken;
import picasso.parser.tokens.chars.RightParenToken;
import picasso.parser.tokens.functions.ClampToken;

/**
 * Tests that the clamp tokenization process works
 * @author Sarina Cusumano
 */
class TokenizerTest {
	
	Tokenizer tokenizer;
	List<Token> tokens;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}

	@Test
	public void testTokenizeCeilingFunctionExpression() {
		String expression = "clamp(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ClampToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}

}
