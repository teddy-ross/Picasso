package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the Divide sign token with a forwards slash
 * 
 * @author Sanjog Basnet
 */
public class DivideToken extends CharToken implements OperationInterface {
	public DivideToken() {
		super(CharConstants.DIVIDE);
	}
	@Override
	public int getPrecedence() {
		return MULTIPLY_OR_DIVIDE;
	}
}
