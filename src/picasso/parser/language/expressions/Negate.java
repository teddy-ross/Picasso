package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Class represents the Negate function that inverts a color. 
 * @author Sylvia Agatako 
 * 
 */

public class Negate extends UnaryFunction {
    
    public Negate(ExpressionTreeNode param) {
        super(param);
    }

    @Override
    public RGBColor evaluate(double x, double y) {
       
        RGBColor result = param.evaluate(x, y);
        
     // Negate each RGB color 
        double red =  -result.getRed();
        double green = -result.getGreen();
        double blue = -result.getBlue();
       
        return new RGBColor(red, green, blue);
    }

    @Override
    public String toString() {
        return "!(" + param + ")";
    }
}
