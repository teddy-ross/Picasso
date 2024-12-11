package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.language.expressions.ImgNameString;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing ImageClip
 * 
 * @author Edward Ross
 * @param <ImageNameStrAnalyzer>
 */

public class ImageClipAnalyzer implements SemanticAnalyzerInterface{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the imageClip token
		ExpressionTreeNode pary = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode parx = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		

		StringToken token = (StringToken) tokens.pop();
	
		String imgName = token.getName();

        // Create and return the ImageClip expression
        return new ImageClip(imgName, parx, pary);
		
	}
}