/**
 * 
 */
package tests.MultiplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Multiplication;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.MultiplyToken;

/**
 * 
 * @author Edward Ross
 */
class SemanticAnalyzerTest {

	private SemanticAnalyzer semAnalyzer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		semAnalyzer = SemanticAnalyzer.getInstance();
	}

	@Test
	void testParseMultiplication() {

		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new MultiplyToken());

		ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

		assertEquals(new Multiplication(new X(), new Y()), actual);
		
		
		
	}
}
