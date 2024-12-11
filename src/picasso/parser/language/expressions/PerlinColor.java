package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;
import picasso.model.*;
/**
 * Represents the perlinColor function that takes two expressions and creates a
 * random color based on 2D noise. 
 * 
 * 
 *@author Edward Ross
 */
public class PerlinColor extends ExpressionTreeNode {
    private final ExpressionTreeNode parx;
    private final ExpressionTreeNode pary;
    
    public PerlinColor(ExpressionTreeNode parx, ExpressionTreeNode pary) {
        this.parx = parx;
        this.pary = pary;
    }
    @Override
    public RGBColor evaluate(double x, double y) {
      
    	RGBColor paramVal1 = parx.evaluate(x, y);
        RGBColor paramVal2 = pary.evaluate(x, y);
        
        double r_left = paramVal1.getRed();
        double g_left = paramVal1.getGreen();
        double b_left = paramVal1.getBlue();
        
        double r_right = paramVal2.getRed();
        double g_right = paramVal2.getGreen();
        double b_right = paramVal2.getBlue();
        

		double red = ImprovedNoise.noise(r_left + r_right, g_left+g_right, b_left + b_right);
		double green = ImprovedNoise.noise(r_left+ r_right, g_right + g_left, b_left - b_right);
		double blue = ImprovedNoise.noise(r_left+r_right, b_right, b_left * b_right);
		
        
		return new RGBColor(red, green, blue);
   
    }
    @Override
    public String toString() {
        String classname = this.getClass().getName();
        return classname.substring(classname.lastIndexOf(".")) + "(" + parx + "," + pary + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true; 
        }
        if (!(o instanceof PerlinColor)) {
            return false;
        }
        // Make sure the objects are the same type
        if (o.getClass() != this.getClass()) {
            return false;
        }
        PerlinColor pbw = (PerlinColor) o;
        // Check if their parameters are equal
        if (!(this.pary.equals(pbw.pary) && this.parx.equals(pbw.parx))) {
            return false;
        }
        return true;
    }
}