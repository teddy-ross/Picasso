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
    private ExpressionTreeNode parx;
    private ExpressionTreeNode pary;
    
    public PerlinColor(ExpressionTreeNode parx, ExpressionTreeNode pary) {
        this.parx = parx;
        this.pary = pary;
    }
    @Override
    public RGBColor evaluate(double x, double y) {
      
        double expressionX = parx.evaluate(x, y).getRed();
        double expressionY = pary.evaluate(x, y).getRed();
        
        
        double noiseVal = (ImprovedNoise.noise(expressionX , expressionY , 0) + 1) / 2;
    
        return new RGBColor(noiseVal, noiseVal, noiseVal);
   
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