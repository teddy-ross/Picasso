/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImgNameString;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing of a image name string.
 * 
 * @author Sanjog Basnet
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		StringToken token = (StringToken) tokens.pop();
		String fileName = token.getName();
		
		return new ImgNameString(fileName);

	}

}
