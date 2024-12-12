package tests.YCrCbToRGBTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.YCrCbToRGB;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.YCrCbToRGBToken;

/**
* Unit tests for the SemanticAnalyzer to verify parsing of YCrCbToRGB expression.
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
  * Tests parsing and constructing YCrCbToRGB expressions.
  */
 @Test
 public void testParseYCrCbToRGB() {

     Stack<Token> tokens = new Stack<>();
     tokens.push(new IdentifierToken("x"));
     tokens.push(new YCrCbToRGBToken());

     ExpressionTreeNode actual = semAnalyzer.generateExpressionTree(tokens);

     assertEquals(new YCrCbToRGB(new X()),actual);
     
     
     
     
 }}

