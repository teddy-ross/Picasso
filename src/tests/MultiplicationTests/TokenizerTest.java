/**
 * 
 */
package tests.MultiplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.Tokenizer;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.MultiplyToken;

/**
 * 
 * @author Edward Ross
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
		String expression = "x * y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new MultiplyToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}

}
