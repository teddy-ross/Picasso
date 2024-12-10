package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;


/**
 * Converts an RGB color to the YCrCb color space.
 * @author Sylvia Agatako
 */
public class RgbToYCrCb extends UnaryFunction {

    public RgbToYCrCb(ExpressionTreeNode param) {
        super(param);
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        RGBColor paramVal = param.evaluate(x, y);
        double r = paramVal.getRed();
        double g = paramVal.getGreen();
        double b = paramVal.getBlue();

       // Convert to YCrCb       
        double red = r * 0.2989 + g * 0.5866 + b * 0.1145;
		double green = r * -0.1687 + g * -0.3312 + b * 0.5;
		double blue = r * 0.5000 + g * -0.4183 + b * -0.0816;
        return new RGBColor(red, green, blue);
    }
}
