/**
 * 
 */
package tests.AnimateTests;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Animate;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.AnimateToken;

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
	void testParseSin() {

		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new AnimateToken());

		ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

		assertEquals(new Animate(new X()), actual);
		
		
		tokens.push(new IdentifierToken("y"));
		tokens.push(new AnimateToken());
		
		actual = semAnalyzer.generateExpressionTree(tokens);
		
		assertEquals(new Animate(new Y()), actual);
		
	}



}

