package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Equals;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the equals sign.
 * 
 * @author Nisha Walvekar
 * 
 */

public class EqualsAnalyzer implements SemanticAnalyzerInterface {
	

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		
		try {
		tokens.pop();
			 
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		IdentifierToken tok = (IdentifierToken) tokens.pop();
		String id = tok.getName();
		if (!(id.equals("x") || id.equals("y"))) {
			return new Equals(id, param);
		}
		else {
			return null;
		}
		}
		

		catch(ClassCastException e) {

			return null;
		}
	}
}


 