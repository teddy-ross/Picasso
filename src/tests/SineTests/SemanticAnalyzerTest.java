/**
 * 
 */
package tests.SineTests;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.Sine;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.SineToken;
import picasso.parser.tokens.operations.PlusToken;

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
	void testParseSine() {

		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new SineToken());

		ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

		assertEquals(new Sine(new X()), actual);
		
		
		tokens.push(new IdentifierToken("y"));
		tokens.push(new SineToken());
		
		actual = semAnalyzer.generateExpressionTree(tokens);
		
		assertEquals(new Sine(new Y()), actual);
		
	}


}