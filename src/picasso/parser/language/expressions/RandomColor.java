/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the class for the equals (assignment) operator 
 * 
 * @author Nisha Walvekar
 */
public class RandomColor extends ExpressionTreeNode {

	
	public RandomColor() {
		
	}
	
		
	
	
	public RGBColor evaluate(double x, double y) {

		return new RGBColor(0.6,0,1);
	}
}



