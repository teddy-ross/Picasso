package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the floor function in the Picasso language.
 * 
 * @author Nisha Walvekar
 */
public class Clamp extends UnaryFunction {

	/**
	 * Create a clamp expression tree that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}

	private double clamp(double z) {
		double outcome=z;
		if (outcome>1) {
			outcome=1;
		}
		if(outcome<-1) {
			outcome=-1;
		}
			
		return outcome;
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
		double red = clamp(result.getRed());
		double green = clamp(result.getGreen());
		double blue = clamp(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	
}
