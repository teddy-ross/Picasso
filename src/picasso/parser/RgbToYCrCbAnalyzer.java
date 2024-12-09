package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RgbToYCrCb;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the RGBToYCrCb function.
 * @author Sylvia Agatako
 */
public class RgbToYCrCbAnalyzer extends UnaryFunctionAnalyzer {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // Remove the RgbToYCrCb token
        // The parameter is the next token(s) on the stack, which needs to be processed
        ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
        return new RgbToYCrCb(paramETN);
    }

}
