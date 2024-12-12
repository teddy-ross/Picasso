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
public class PerlinBW extends MultiArgumentFunction {

    
    public PerlinBW(ExpressionTreeNode parx, ExpressionTreeNode pary) {
        super(parx,pary);
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
    

}