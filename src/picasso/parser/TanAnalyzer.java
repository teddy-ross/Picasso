package picasso.parser;

import java.util.Stack;

/**
 * Handles parsing the tangent function
 * 
 * @author Sylvia Agatako
 */

public class TanAnalyzer implements SemanticAnalyzerInterface{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Tangent(paramETN);
	}
}
