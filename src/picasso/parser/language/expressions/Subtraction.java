package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Subtraction operator in the Picasso language.
 * @author Sanjog Basnet
 */

public class Subtraction extends BinaryOperator {

	/**
	 * Creates a subtraction expression tree that takes as parameter the given expression
	 * 
	 * @param left 
	 * @param right 
	 */
	public Subtraction(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		double red = l.getRed() - r.getRed();
		double green = l.getGreen() - r.getGreen();
		double blue = l.getBlue() - r.getBlue();	
	return new RGBColor(red,green,blue);
	}
	
	@Override
	public String getOperator() {
		return "-";
	}
	
}
