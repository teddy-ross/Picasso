package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Multiplication operator in the Picasso language.
 * @author Sanjog Basnet
 */
public class Multiplication extends BinaryOperator {

	public Multiplication(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		
	}
	@Override
	public String getOperator() {
		return "*";	
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
		double red = l.getRed()*r.getRed();
		double green = l.getGreen()*r.getGreen();
		double blue = l.getBlue()*r.getBlue();
		return new RGBColor(red,green,blue);
	}
}
