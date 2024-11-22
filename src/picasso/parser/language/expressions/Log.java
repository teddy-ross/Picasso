package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the natural log function in the Picasso Langauge
 * 
 * @author Sanjog Basnet
 */
public class Log extends UnaryFunction {

	public Log(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.log(result.getRed());
		double green = Math.log(result.getGreen());
		double blue = Math.log(result.getBlue());
	return new RGBColor(red,green,blue);
	}
	

}
