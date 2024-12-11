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
        
        double red = ImprovedNoise.noise(paramVal1.getRed() + 0.3, paramVal2.getRed() + 0.3, 0);

        double blue = ImprovedNoise.noise(paramVal1.getBlue() + 0.1, paramVal2.getBlue() + 0.1, 0);

        double green = ImprovedNoise.noise(paramVal1.getGreen() - 0.8, paramVal2.getGreen() - 0.8, 0);

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