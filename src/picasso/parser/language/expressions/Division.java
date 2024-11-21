package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Division operator in the Picasso language.
 * @author Sanjog Basnet
 */

public class Division extends BinaryOperator {

	/**
	 * Creates a division expression tree that takes as parameter the given expression
	 * 
	 * @param left expression to the left of /
	 * @param right expression to the right of /
	 */
	public Division(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left,right);	
	}	
	@Override
	public String getOperator() {
		return "/";	
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the x/y where the params are (x,y)
	 * 
	 * @return the color from evaluating the quotient of the operation
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		double red;
		double green;
		double blue;
		//its going to be l/r, division by 0 will return 0
		if (r.getRed() == 0) {
			red = 0;
		}
		else {
			red = l.getRed() / r.getRed();
		}
		if (r.getBlue() == 0) {
			blue = 0;
		}
		else {
			blue = l.getBlue() / r.getBlue();
		}
		if (r.getGreen() == 0) {
			green = 0;
		}
		else {
			green = l.getGreen() / r.getGreen();
		}
		
		return new RGBColor(red,green,blue);
	}
}
