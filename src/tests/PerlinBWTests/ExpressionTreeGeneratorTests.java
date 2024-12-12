package tests.PerlinBWTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

/**
* Unit tests for ExpressionTreeGenerator.
* @author Sylvia Agatako
*/
public class ExpressionTreeGeneratorTests {

 private ExpressionTreeGenerator parser;

 /**
  * Sets up the ExpressionTreeGenerator before each test.
  *
  * @throws Exception if setup fails.
  */
 @BeforeEach
 public void setUp() throws Exception {
     parser = new ExpressionTreeGenerator();
 }

 /**
  * Tests parsing and PerlinBW expressions.
  */
 @Test
 public void perlinBWFunctionTests() {
    
     ExpressionTreeNode e = parser.makeExpression("perlinBW(x, y)");
     assertEquals(new PerlinBW(new X(), new Y()), e);

 }
}

