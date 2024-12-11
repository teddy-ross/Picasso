package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Converts a YCrCb color back to the RGB color space.
 * @author Sylvia Agatako
 */
public class YCrCbToRGB extends UnaryFunction {

    public YCrCbToRGB(ExpressionTreeNode param) {
        super(param);
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        RGBColor paramVal = param.evaluate(x, y);
        double r = paramVal.getRed();
        double g = paramVal.getGreen();
        double b = paramVal.getBlue();

        // Convert to RGB
        double red = r + b * 1.4022;
		double green = r + g * -0.3456 + b * -0.7145;
		double blue = r + g * 1.7710;
		
		return new RGBColor(red, green, blue);
 
    }
}
