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
        double yComponent = paramVal.getRed();
        double cr = paramVal.getGreen();
        double cb = paramVal.getBlue();

        // Convert to RGB
        double r = yComponent + cr / 0.713;
        double g = yComponent - 0.344 * cb - 0.714 * cr;
        double b = yComponent + cb / 0.564;

        return new RGBColor(r, g, b);
    }
}
