/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.language.expressions.Modulo;
import picasso.parser.tokens.Token;

/**
 * 
 * @author Sanjog Basnet
 */
public class ModAnalyzer implements SemanticAnalyzerInterface {

	/**
	 * 
	 * @return
	 * @see picasso.parser.SemanticAnalyzerInterface#generateExpressionTree(java.util.Stack)
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
			tokens.pop(); // Remove the slash token
			ExpressionTreeNode rightETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
			ExpressionTreeNode leftETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
			return new Modulo(leftETN, rightETN);

	}

}
