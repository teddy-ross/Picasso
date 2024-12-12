package tests.PerlinBWTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.PerlinBWToken;

/**
* Unit tests for the SemanticAnalyzer to verify parsing of PerlinBW expression.
* @author Sylvia Agatako
*/
public class SemanticAnalyzerTest {

 private SemanticAnalyzer semAnalyzer;

 /**
  * Sets up the SemanticAnalyzer instance before each test.
  *
  * @throws Exception if setup fails.
  */
 @BeforeEach
 public void setUp() throws Exception {
     semAnalyzer = SemanticAnalyzer.getInstance();
 }

 /**
  * Tests parsing and constructing PerlinBW expressions.
  */
 @Test
 public void testParsePerlinBW() {

     // Test for perlinBW(x, y)
     Stack<Token> tokens = new Stack<>();
     tokens.push(new IdentifierToken("x"));
     tokens.push(new IdentifierToken("y"));
     tokens.push(new PerlinBWToken());

     ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

     assertEquals(new PerlinBW(new X(), new Y()), actual);

     // Test for perlinBW(y, x)
     tokens.clear();
     tokens.push(new IdentifierToken("y"));
     tokens.push(new IdentifierToken("x"));
     tokens.push(new PerlinBWToken());

     actual = semAnalyzer.generateExpressionTree(tokens);

     assertEquals(new PerlinBW(new Y(), new X()), actual);
 }
}

