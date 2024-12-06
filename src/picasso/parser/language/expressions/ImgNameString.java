/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.model.Pixmap;
import java.awt.Color;


/**
 * Represents an imagefile in a Picasso expression
 * 
 * @author Sanjog Basnet
 */	
public class ImgNameString extends ExpressionTreeNode {
	
	private Pixmap pixmap;
	
	public ImgNameString(String imageName) {
        pixmap = new Pixmap("images/" + imageName); // Load the image onto the pixmap
    }
	
	
	@Override
	public RGBColor evaluate(double x, double y) {
		int pixelX = (int)((x+1)/2)*299 ;
        int pixelY = (int)((y+1)/2)*299 ;
        Color color = pixmap.getColor(pixelX,pixelY);
		
        double red = color.getRed();
        double green = color.getGreen();
        double blue = color.getBlue();
        
		return new RGBColor(red, green, blue);
        
	}

}
