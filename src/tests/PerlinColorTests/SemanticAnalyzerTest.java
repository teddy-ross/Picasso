package tests.PerlinColorTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.PerlinColorToken;

/**
 * Semantic Analyzer Test: perlinColor
 * 
 * @author Edward Ross
 */
public class SemanticAnalyzerTest {

	private SemanticAnalyzer semAnalyzer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		semAnalyzer = SemanticAnalyzer.getInstance();
	}

	@Test
	void testParseCos() {

		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new PerlinColorToken());

		ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

		assertEquals(new PerlinColor(new X(), new Y()), actual);
		
		
		tokens.push(new IdentifierToken("y"));
		tokens.push(new IdentifierToken("x"));
		tokens.push(new PerlinColorToken());
		
		actual = semAnalyzer.generateExpressionTree(tokens);
		
		assertEquals(new PerlinColor(new Y(), new X()), actual);
		
	}

}
