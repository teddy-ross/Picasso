package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an ImageWrap in the Picasso language.
 * 
 * Combines an image (via `ImgNameString`) with two parameter expressions to
 * determine pixel coordinates.
 * 
 * @author Edward Ross
 */
public class ImageWrap extends MultiArgumentFunction {

    private ImgNameString imgstr;


    /**
     * Constructs an ImageWrap expression.
     * 
     * @param imgstr The image name string (wrapped as an ImgNameString)
     * @param parx   The expression for calculating the X coordinate
     * @param pary   The expression for calculating the Y coordinate
     */
    public ImageWrap(String imageName, ExpressionTreeNode parx, ExpressionTreeNode pary) {
    	super(parx,pary);
    	imgstr = new ImgNameString(imageName);

    }

    @Override
    public RGBColor evaluate(double x, double y) {
        // Evaluate the X and Y parameters using the given expressions
        double expressionX = Wrap.wrap((parx.evaluate(x, y)).getRed());
        double expressionY = Wrap.wrap((pary.evaluate(x, y)).getRed());

        // Use ImgNameString to evaluate the color at the calculated coordinates
        return imgstr.evaluate(expressionX, expressionY);
    }

}
