package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the tan function in the Picasso language.
 * 
 * @author Sylvia Agatako
 *
 */

public class Tan extends UnaryFunction{
	
	public Tan(ExpressionTreeNode param) {
		super(param);
	}


	/**
	 * Evaluates this expression at the given x,y point by evaluating the tan of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	
	@Override
	
	public RGBColor evaluate(double x, double y) {
		RGBColor paramVal = param.evaluate(x, y);
		double red = Math.tan(paramVal.getRed());
		double green = Math.tan(paramVal.getGreen());
		double blue = Math.tan(paramVal.getBlue());

		return new RGBColor(red, green, blue);
		}
	
	}



