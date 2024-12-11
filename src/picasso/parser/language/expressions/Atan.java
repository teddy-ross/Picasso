package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the arc tan function in the Picasso language.
 * 
 * @author Sarina Cusumano
 *
 */

public class Atan extends UnaryFunction{
	
	public Atan(ExpressionTreeNode param) {
		super(param);
	}


	/**
	 * Evaluates this expression at the given x,y point by evaluating the  arc tan of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	
	@Override
	
	public RGBColor evaluate(double x, double y) {
		RGBColor paramVal = param.evaluate(x, y);
		double red = Math.atan(paramVal.getRed());
		double green = Math.atan(paramVal.getGreen());
		double blue = Math.atan(paramVal.getBlue());

		return new RGBColor(red, green, blue);
		}
	
	}



