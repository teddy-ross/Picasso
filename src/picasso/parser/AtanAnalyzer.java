package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Atan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the arc tangent function.
 * @author Sarina Cusumano
 */
public class AtanAnalyzer extends UnaryFunctionAnalyzer {

    /**
     * Generates the expression tree for the arc tangent function.
     * 
     * @param tokens the stack of tokens to process
     * @return an ExpressionTreeNode representing the tangent function
     */
    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // Remove the tan token from the stack
        // The parameter is the next token(s) on the stack and needs to be processed
        ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
        return new Atan(paramETN);
    }
}
