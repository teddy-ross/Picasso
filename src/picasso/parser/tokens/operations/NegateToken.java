package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the negate token(!)
 * 
 * @author Sylvia Agatako 
 */
public class NegateToken extends CharToken implements OperationInterface {
	public NegateToken() {
		super(CharConstants.NEGATE);
	}

	@Override
	public int getPrecedence() {
		
		return 5; //not really a binary operation either 
	}

}
