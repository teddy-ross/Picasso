package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RandomColor;
import picasso.parser.tokens.Token;

/**
 * Handles Parsing for the Log function
 * 
 * @author Nisha
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); //remove the top token
		return new RandomColor();
	}

}
