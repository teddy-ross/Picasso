package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceil;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the ceiling function.
 * 
 * @author Nisha Walvekar
 * 
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Ceil(paramETN);
	}

}
