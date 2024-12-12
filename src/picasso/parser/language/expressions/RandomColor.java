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
	
	private static final double min = -1.0; 
    private static final double max = 1.0;
    
    double red = Math.random()*(max-min)+min;
	double green = Math.random()*(max-min)+min;
	double blue = Math.random()*(max-min)+min;
	

	
	public RandomColor() {
		
	}
	
	public RGBColor evaluate(double x, double y) {
		
		return new RGBColor(red,green,blue);
	}
}



