package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the Exponentiate sign token with a carrot
 * 
 * @author Sarina Cusumano
 */
public class ExponentiateToken extends CharToken implements OperationInterface {
	public ExponentiateToken() {
		super(CharConstants.EXPONENTIATE);
	}

	@Override
	public int getPrecedence() {
		return EXPONENTIATE;
	}
}
