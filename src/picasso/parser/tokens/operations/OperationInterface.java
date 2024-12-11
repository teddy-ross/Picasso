package picasso.parser.tokens.operations;

/**
 * A marker interface
 * 
 */
public interface OperationInterface {
	

	public static final int GROUPING = 1; // parentheses
	public static final int ADD_OR_SUBTRACT = 2;
	public static final int MULTIPLY_OR_DIVIDE = 3;
	public static final int EXPONENTIATE = 4;
	

	public abstract int getPrecedence();
}
