package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.ParseException;
import picasso.errors.Error;

/**
 * Represents the Addition operator in the Picasso language.
 * @author Sanjog Basnet
 */

public class Addition extends BinaryOperator {

	/**
	 * Creates a addition expression tree that takes as parameter the given expression
	 * 
	 * @param left 
	 * @param right 
	 */
	public Addition(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		if(this.left == null) {
			Error error = new Error("Missing operator(s)");
			throw new ParseException("this.left is null");
		}
		else if (this.right == null) {
			Error error = new Error("Missing operator(s)");
			throw new ParseException("this.right is null");
		}
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		double red = l.getRed() + r.getRed();
		double green = l.getGreen() + r.getGreen();
		double blue = l.getBlue() + r.getBlue();	
		
	return new RGBColor(red,green,blue);
	}
	
	@Override
	public String getOperator() {
		return "+";
	}
	
}
