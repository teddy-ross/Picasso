package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Log;
import picasso.parser.tokens.Token;

/**
 * Handles Parsing for the Log function
 * 
 * @author Sanjog Basnet
 */
public class LogAnalyzer extends UnaryFunctionAnalyzer{


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); //remove the top token
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Log(paramETN);
	}

}
