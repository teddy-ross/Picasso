package tests.RgbToYCrCbTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RgbToYCrCb;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.RgbToYCrCbToken;

/**
* Unit tests for the SemanticAnalyzer to verify parsing of RgbToYCrCb expression.
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
  * Tests parsing and constructing RgbToYCrCb expressions.
  */
 @Test
 public void testParseRgbToYCrCb() {

     // Test for RgbToYCrCbTests(x)
     Stack<Token> tokens = new Stack<>();
     tokens.push(new IdentifierToken("x"));
     tokens.push(new RgbToYCrCbToken());

     ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

     assertEquals(new RgbToYCrCb(new X()),actual);
     
 }}

