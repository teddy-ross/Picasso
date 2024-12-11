package picasso.parser.tokens.operations;

import picasso.parser.tokens.chars.CharToken;
import picasso.parser.language.CharConstants;

/**
 * Represents the minus sign token
 * 
 */
public class MinusToken extends CharToken implements OperationInterface {
	public MinusToken() {
		super(CharConstants.MINUS);
	}
	@Override
	public int getPrecedence() {
		return ADD_OR_SUBTRACT;
	}
}

