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
    private String imageName;
    
    public ImgNameString(String imageName) {
        this.imageName = imageName;
        pixmap = new Pixmap("images/" + imageName); // Load the image onto the pixmap
    }
    
    @Override
    public RGBColor evaluate(double x, double y) {
        // Map the (x, y) to pixel coordinates of the image
        int pixelX = (int) ((x + 1) / 2 * pixmap.getSize().width); // Scaling based on the actual image width
        int pixelY = (int) ((y + 1) / 2 * pixmap.getSize().height); // Scaling based on the actual image height
        
        // Ensure that the coordinates are within bounds
        pixelX = Math.min(Math.max(pixelX, 0), pixmap.getSize().width - 1);
        pixelY = Math.min(Math.max(pixelY, 0), pixmap.getSize().height - 1);
        
        Color color = pixmap.getColor(pixelX, pixelY); // Get the color at the scaled pixel
        
        return new RGBColor(color); // RGBColor object can handle the conversion
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ImgNameString)) {
            return false;
        }

        // Make sure the objects are the same type
        if (o.getClass() != this.getClass()) {
            return false;
        }

        ImgNameString ins = (ImgNameString) o;

        // Check if their parameters are equal
        return this.imageName.equals(ins.imageName);
    }
}
