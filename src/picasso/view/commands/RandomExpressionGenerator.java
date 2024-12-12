package picasso.view.commands;

import java.util.Random;

public class RandomExpressionGenerator {
	private static final String[] coords = {"x", "y"};
	private static final String[] binops = {"+", "-", "/", "*", "%", "^"};
	private static final String[] unaryFn = {"floor", "cos", "sin", "tan", "abs", "log", "exp", "ceil","clamp", "wrap", "atan", "yCrCbToRGB", "rgbToYCrCb"};
	private static final String[] multiFn = {"perlinColor", "perlinBW"};
	private static final int MAX_DEPTH = 7;




	public RandomExpressionGenerator() {
	}
	private static final Random r = new Random();
	
	public String generateExpression(String expression, int depth) {

		if (depth >= MAX_DEPTH) {

			int terminalChoice = r.nextInt(2);

			if (terminalChoice  == 0) {
				return coords[r.nextInt(coords.length)];
			} else {
				double red = r.nextDouble()*2 - 1;
				double green = r.nextDouble()*2 -1;
				double blue = r.nextDouble()*2 -1 ;
				String RGBcolour = "[" + String.format("%.5f", red) + "," + String.format("%.5f", green) + "," + String.format("%.5f", blue) + "]";
				return RGBcolour;	
			}
		}

		int choice = r.nextInt(4);

		if (choice == 0) {
			return multiFn[r.nextInt(multiFn.length)] + "(" + generateExpression("", depth + 1) + "," + generateExpression("", depth + 1) + ")";
		} else if (choice == 1) {
			return unaryFn[r.nextInt(unaryFn.length)] + "(" + generateExpression("", depth + 1) + ")";
		}
		else if (choice == 2) {
			return "(" + generateExpression("", depth + 1)  + ")"+binops[r.nextInt(binops.length)] + "(" + generateExpression("", depth + 1)  + ")";
		}
		else  {
			return coords[r.nextInt(coords.length)]; 
//					+binops[r.nextInt(binops.length)]  +generateExpression("", depth + 1) ;
		}

	}
}


