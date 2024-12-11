package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.YCrCbToRGB;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the YCrCb to RGB function.
 * @author Sylvia Agatako
 */
public class YCrCbToRGBAnalyzer extends UnaryFunctionAnalyzer {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // Remove the YCrCbToRgb token
        // The parameter is the next token(s) on the stack, which needs to be processed
        ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
        return new YCrCbToRGB(paramETN);
    }

}
