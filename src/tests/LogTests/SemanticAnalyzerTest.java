/**
 * 
 */
package tests.LogTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Log;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.LogToken;

/**
 * 
 * @author Sanjog Basnet
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
	void testParseLog() {

		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new LogToken());

		ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

		assertEquals(new Log(new X()), actual);
		
		
		tokens.push(new IdentifierToken("y"));
		tokens.push(new LogToken());
		
		actual = semAnalyzer.generateExpressionTree(tokens);
		
		assertEquals(new Log(new Y()), actual);
		
	}

}
