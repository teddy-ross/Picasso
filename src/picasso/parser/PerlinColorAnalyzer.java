package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.tokens.Token;

/**
 * An analyzer for PerlinColor expression tree nodes
 * 
 * @author Edward Ross
 */
public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        // Remove the PerlinColor token
        tokens.pop();

        // Generate Y and X expressions from the stack (arguments for PerlinColor)
        ExpressionTreeNode pary = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
        ExpressionTreeNode parx = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);

        // Return a new PerlinColor expression tree node
        return new PerlinColor(parx, pary);
    }
}
