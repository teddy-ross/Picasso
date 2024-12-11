/**
 * 
 */
package tests.ClampTests;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.ClampToken;

/**
 * 
 * @author Sarina Cusumano
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
		tokens.push(new ClampToken());
		

		ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

		assertEquals(new Clamp(new X()), actual);
		
		
		tokens.push(new IdentifierToken("y"));
		tokens.push(new ClampToken());
		
		actual = semAnalyzer.generateExpressionTree(tokens);
		
		assertEquals(new Clamp(new Y()), actual);
		
	}

}
