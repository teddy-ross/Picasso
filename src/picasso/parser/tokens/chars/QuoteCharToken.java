package picasso.parser.tokens.chars;

import picasso.parser.language.CharConstants;

/**
 * Represents a left parenthesis in the Picasso programming language
 * @author Edward Ross
 */
public class QuoteCharToken extends CharToken {
	public QuoteCharToken() {
		super(CharConstants.QUOTE);
	}
}
