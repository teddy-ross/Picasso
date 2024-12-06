package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a constant in the Picasso language.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ImageClip extends ExpressionTreeNode {

	private ImgNameString imgstr;
	private ExpressionTreeNode parx;
	private ExpressionTreeNode pary;

	/**
	 * @param imagenamestring
	 * @param expression
	 * @param expression
	 */
	public ImageClip(ImgNameString imgstr, ExpressionTreeNode parx, ExpressionTreeNode pary) {
		this.imgstr=imgstr;
		this.parx = parx;
		this.pary = pary;
		
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		double expressionx = Clamp.clamp((parx.evaluate(x,y)).getRed());
		double expressiony = Clamp.clamp((pary.evaluate(x,y)).getRed());
		
		RGBColor newimgclip = imgstr.evaluate(expressionx, expressiony);
		return newimgclip;

	
}

}
