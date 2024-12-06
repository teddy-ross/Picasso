package picasso.parser.language.expressions;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Clamp; 

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
	 * @param var
	 * @param expression
	 */
	public ImageClip(ImgNameString imgstr, ExpressionTreeNode parx, ExpressionTreeNode pary) {
		this.parx = parx;
		this.pary = pary;
		this.imgstr=imgstr;
	}
	public RGBColor evaluate(double x, double y) {
		double expressionx = Clamp.clamp((parx.evaluate(x,y)).getRed());
		double expressiony = Clamp.clamp((pary.evaluate(x,y)).getRed());
		
		RGBColor newimgclip = imgstr.evaluate(expressionx, expressiony);
		return newimgclip;

	
}
