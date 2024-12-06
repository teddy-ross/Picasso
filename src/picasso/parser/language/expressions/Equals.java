/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the class for the equals (assignment) operator 
 * 
 * @author Nisha Walvekar
 */
public class Equals extends ExpressionTreeNode {

	String left;
	ExpressionTreeNode right;
	/**
	 * @param var
	 * @param expression
	 */
	public Equals(String left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
		IdentifierAnalyzer.idToExpression.put(this.left, this.right);
	}
	
	/**
	 * Evaluates the right side of the assignment operator
	 * 
	 * @return the color from evaluating the right side of the input
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = right.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}
}



