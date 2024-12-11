package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an ImageClip in the Picasso language.
 * 
 * Combines an image (via `ImgNameString`) with two parameter expressions to
 * determine pixel coordinates.
 * 
 * @author Sanjog Basnet
 * @author Nisha Walvekar
 */
public class ImageClip extends ExpressionTreeNode {

    private ImgNameString imgstr;
    private ExpressionTreeNode parx;
    private ExpressionTreeNode pary;

    /**
     * Constructs an ImageClip expression.
     * 
     * @param imgstr The image name string (wrapped as an ImgNameString)
     * @param parx   The expression for calculating the X coordinate
     * @param pary   The expression for calculating the Y coordinate
     */
    public ImageClip(String imageName, ExpressionTreeNode parx, ExpressionTreeNode pary) {
        imgstr = new ImgNameString(imageName);
        this.parx = parx;
        this.pary = pary;
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        // Evaluate the X and Y parameters using the given expressions
        double expressionX = Clamp.clamp((parx.evaluate(x, y)).getRed());
        double expressionY = Clamp.clamp((pary.evaluate(x, y)).getRed());

        // Use ImgNameString to evaluate the color at the calculated coordinates
        return imgstr.evaluate(expressionX, expressionY);
    }

    @Override
    public String toString() {  //
    	String classname = this.getClass().getName();
    	return classname.substring(classname.lastIndexOf(".")) + "(" + parx + "," + pary + ")";
    } 

    @Override
    public boolean equals(Object o) {
    	if (o == this) {
    		return true;
    	}

    	if (!(o instanceof ImageClip)) {
    		return false;
    	}

    	// Make sure the objects are the same type

    	if (o.getClass() != this.getClass()) {
    		return false;
    	}

    	ImageClip ic = (ImageClip) o;

    	// check if their parameters are equal
    	if (!(this.pary.equals(ic.pary) && this.parx.equals(ic.parx))) {
    		return false;
    	}
    	return true;
    }
}
