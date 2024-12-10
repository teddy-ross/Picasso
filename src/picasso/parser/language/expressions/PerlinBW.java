package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;
import picasso.model.*;
/**
 * Represents the perlinBW function that takes two expressions and creates a
 * grey scale color based on 2D noise. 
 * 
 * 
 *@author Sylvia Agatako
 */
public class PerlinBW extends ExpressionTreeNode {
    private ExpressionTreeNode parx;
    private ExpressionTreeNode pary;
    
    public PerlinBW(ExpressionTreeNode parx, ExpressionTreeNode pary) {
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
        

		double grey = ImprovedNoise.noise(r_left + r_right, g_left + g_right, b_left + b_right);
		return new RGBColor(grey, grey, grey);
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
        if (!(o instanceof PerlinBW)) {
            return false;
        }
        // Make sure the objects are the same type
        if (o.getClass() != this.getClass()) {
            return false;
        }
        PerlinBW pbw = (PerlinBW) o;
        // Check if their parameters are equal
        if (!(this.pary.equals(pbw.pary) && this.parx.equals(pbw.parx))) {
            return false;
        }
        return true;
    }
}