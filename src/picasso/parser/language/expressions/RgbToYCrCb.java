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
        double yComponent = 0.299 * r + 0.587 * g + 0.114 * b;
        double cr = (r - yComponent) * 0.713;
        double cb = (b - yComponent) * 0.564;

        return new RGBColor(yComponent, cr, cb);
    }
}
