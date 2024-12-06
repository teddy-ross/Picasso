/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Modulo operator in the Picasso language.
 * @author Sanjog Basnet
 */
public class Modulo extends BinaryOperator {

	/**
	 * @param left
	 * @param right
	 */
	public Modulo(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	/**
	 * @return
	 * @see picasso.parser.language.expressions.BinaryOperator#getOperator()
	 */
	@Override
	public String getOperator() {
		return "%";
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l= left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		double red = l.getRed()%r.getRed();
		double green = l.getGreen()%r.getGreen();
		double blue = l.getBlue()%r.getBlue();
		return new RGBColor(red, green, blue);
		
	}

}
