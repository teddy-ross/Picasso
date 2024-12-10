package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the slash/ divide or "division operation".
 * 
 * @author Sanjog Basnet
 * 
 */

public class DivideAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the slash token
		ExpressionTreeNode rightETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode leftETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Division(leftETN, rightETN);

	}
}