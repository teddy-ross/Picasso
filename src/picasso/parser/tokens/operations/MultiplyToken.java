package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the Multiply sign token with a star
 * 
 */
public class MultiplyToken extends CharToken implements OperationInterface {
	public MultiplyToken() {
		super(CharConstants.MULTIPLY);
	}
	@Override
	public int getPrecedence() {
		return MULTIPLY_OR_DIVIDE;
	}

}
