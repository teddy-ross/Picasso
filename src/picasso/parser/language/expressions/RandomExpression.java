package picasso.parser.language.expressions;

import java.util.Arrays;
import java.util.List;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the random expression function in the Picasso language.
 * 
 * @author Nisha Walvekar
 * 
 */
public class RandomExpression extends ExpressionTreeNode {
	/**
	 * 
	 * @param param the expression
	 */
	
	public int length;
	public String expression;
	ExpressionTreeNode e;
	
	public RandomExpression(int length) {
		this.length = length;
		
		List<String> functions = Arrays.asList("RGBToYCrCb(", "yCrCbToRGB(","ceil(", "floor(","sin(","abs(","cos(","tan(","atan(","log(");
		List<String> others = Arrays.asList("x","y","random()");
		List<String> operators = Arrays.asList("+","-","*","/","%");
	}
		
	@Override
	public RGBColor evaluate(double x, double y) {
	    RGBColor result = e.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}

}
