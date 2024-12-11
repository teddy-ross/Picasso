package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the Modulo sign token with a percentage sign %
 * 
 * @author Sanjog Basnet
 */
public class ModToken extends CharToken implements OperationInterface {
	public ModToken() {
		super(CharConstants.MOD);
	}
	@Override
	public int getPrecedence() {
		return MULTIPLY_OR_DIVIDE;
	}
}
