package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.tokens.Token;

/**
 * 
 * 
 * @author Sylvia Agatako
 */
public class PerlinBWAnalyzer implements SemanticAnalyzerInterface {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        // Remove the PerlinBW token
        tokens.pop();

        // Generate Y and X expressions from the stack (arguments for PerlinBW)
        ExpressionTreeNode pary = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
        ExpressionTreeNode parx = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);

        // Return a new PerlinBW expression tree node
        return new PerlinBW(parx, pary);
    }
}
