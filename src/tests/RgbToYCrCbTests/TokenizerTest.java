
package tests.RgbToYCrCbTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.LeftParenToken;
import picasso.parser.tokens.chars.RightParenToken;
import picasso.parser.tokens.functions.RgbToYCrCbToken;


/**
 * 
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
		String expression = "rgbToYCrCb(x)";
		tokens = tokenizer.parseTokens(expression);

	    assertEquals(new RgbToYCrCbToken(), tokens.get(0));
	    assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));	
		assertEquals(new RightParenToken(), tokens.get(3));
		
	
	}

}
