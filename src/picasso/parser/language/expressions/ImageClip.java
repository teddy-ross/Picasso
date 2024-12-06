package picasso.parser.language.expressions;
import java.util.List;

import picasso.parser.language.ExpressionTreeNode;
/**
 * Image Clip Expression
 * 
 * @author Edward Ross
 */

public class ImageClip extends MultiArgumentFunction{

	public ImageClip(List<ExpressionTreeNode> params) {
		super(params);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		
		
		
		
		
		return new RGBColor(red,green,blue);
	

}
}
