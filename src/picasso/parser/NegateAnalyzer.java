package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.tokens.Token;

/**
 * Represents the negate analyzer. 
 * @author Sylvia Agatako 
 */


public class NegateAnalyzer implements SemanticAnalyzerInterface {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // Remove the ! token
       
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Negate(param);

    	}

}
