package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Equals;
import picasso.parser.language.expressions.ImgNameString;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.ImgNameStrToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing of image name string tokens.
 * 
 * @author Edward Ross
 */
public class ImgNameStrAnalyzer implements SemanticAnalyzerInterface {

 
    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        
    	try {
	        // Pop the token
	        Token token = tokens.pop();

	        // Check if token is an ImgNameStrToken
	        if (token instanceof ImgNameStrToken) {
	            ImgNameStrToken imgToken = (ImgNameStrToken) token;
	            return new ImgNameString(imgToken.getName());
	        } else {
	            return null;
	        }
	    } catch (ClassCastException e) {
	        // Handle the exception if necessary (e.g., log the error)
	        return null;
	    }
	}
}