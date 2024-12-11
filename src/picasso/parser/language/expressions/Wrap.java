package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Nisha Walvekar
 */
public class Wrap extends UnaryFunction {

	
	/**
	 * Create a clamp expression tree that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	public static double wrap(double z) {
		double result = z;
		if (z>=1) {
			while (result > 1) {
				result = result - 2;
			}
		}
		else if (z<=-1) {
			while (result < -1) {
				result = result + 2;
			}
		}
		return result;
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the clamp of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrap(result.getRed());
		double green = wrap(result.getGreen());
		double blue = wrap(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	
}
