package picasso.parser.language.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the random expression function in the Picasso language.
 * 
 * @author Nisha Walvekar
 * 
 */
public class RandomExpression extends ExpressionTreeNode {
	/**
	 * Create a random expression that takes as a parameter ~ the desired size of the expression
	 * To avoid errors, sometimes an additional function is added so the length might be greater than you intended
	 * User inputed length is to make sure the expression isn't enormous
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
		
	@Override
	public RGBColor evaluate(double x, double y) {
	    RGBColor result = e.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}

}
