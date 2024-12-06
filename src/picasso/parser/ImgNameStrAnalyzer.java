package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImgNameString;
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
        
        // Pop the token
        Token token = tokens.pop();

        // Cast the token to ImgNameStrToken and create the ImgNameStr node
        
        ImgNameStrToken imgToken = (ImgNameStrToken) token;
        return new ImgNameString(imgToken.getName());
    }
}