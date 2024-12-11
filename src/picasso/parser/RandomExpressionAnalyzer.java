package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RandomExpression;
import picasso.parser.tokens.NumberToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the cosine function
 * 
 * @author Edward Ross
 */

public class RandomExpressionAnalyzer implements SemanticAnalyzerInterface{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		NumberToken token = (NumberToken) tokens.pop();
		int len = (int) token.value();
		return new RandomExpression(len);
	}
}
