/**
 * 
 */
package tests.NegateTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.Tokenizer;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.NegateToken;


/**
 * Tests that the Negate tokenization process works
 * @author Sylvia Agatako
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
	public void testTokenizeBasicFunctionExpression() {
		String expression = "!x";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NegateToken(), tokens.get(0));
		assertEquals(new IdentifierToken("x"), tokens.get(1));
		
		
	}


}
