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
      
        double expressionX = parx.evaluate(x, y).getRed();
        double expressionY = pary.evaluate(x, y).getRed();

        // Use the ImprovedNoise class to calculate Perlin noise
        double noiseVal = ImprovedNoise.noise(expressionX, expressionY, 0); // noise takes three paramaters

        noiseVal = (noiseVal + 1) / 2; // reduced noiseVal to [0,1] for black and white(to later give us)

        // Return a grayscale color
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
