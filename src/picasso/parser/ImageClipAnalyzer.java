package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
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
		ExpressionTreeNode parx = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode pary = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		ImageNameStrAnalyzer analyzer = new ImageAnalyzer();
		ExpressionTreeNode newImage = analyzer.generateExpressionTree(tokens);
		return new ImageClip((Image) newImage, paramx, paramy);
		return new ImageClip(leftETN, rightETN);
	}
}