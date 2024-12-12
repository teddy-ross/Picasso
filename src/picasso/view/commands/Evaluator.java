package picasso.view.commands;

import java.util.concurrent.TimeUnit;

import java.awt.Color;

import java.awt.Dimension;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import picasso.view.Frame;
import picasso.util.Error;

/**
 * Evaluate an expression for each pixel in an image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;

	private Frame container;

	/**
	 * Constructor to initialize the evaluator with the frame.
	 * 
	 * @param container Frame containing user input or settings.
	 */
	public Evaluator(Frame container) {
		this.container = container;
	}

	/**
	 * Evaluate an expression for each point in the image.
	 */
	@Override
	public void execute(Pixmap target) {

		ExpressionTreeNode expr = null;

		try {
			// Determine the source of the expression
			String expression = getExpression(target);

			// Generate the expression tree
			expr = createExpressionTree(expression);

		} catch (ParseException p) {
			Error error = new Error("Invalid Expression: " + p.getMessage());
			p.printStackTrace();
			return;
		} catch (ClassCastException c) {
			Error error = new Error("Invalid Expression: Unable to Read Input");
			c.printStackTrace();
			return;
		}

		if (expr == null) {
			Error error = new Error("Invalid Expression");
		}

		else {
			// Evaluate the expression for each pixel
			Dimension size = target.getSize();
			for (int imageY = 0; imageY < size.height; imageY++) {
				double evalY = imageToDomainScale(imageY, size.height);
				for (int imageX = 0; imageX < size.width; imageX++) {
					double evalX = imageToDomainScale(imageX, size.width);
					Color pixelColor;
					try {
						pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
					} catch (NullPointerException n) {
						Error error = new Error("Invalid Expression: Unable to Read Input");
						n.printStackTrace();
						return;
					}
					target.setColor(imageX, imageY, pixelColor);
					
					
				}

			}
		}
	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * Gets the expression from either the text field or the file.
	 * 
	 * @param target Pixmap containing the expression from the file.
	 * @return The chosen expression as a string.
	 */
	private String getExpression(Pixmap target) {
		String fileExpression = target.getExpression();
		String textExpression = container.getText();

		// Evaluate text input first
		if (textExpression != null && !textExpression.isEmpty()) {
			System.out.println("Using text expression: " + textExpression);
			return textExpression;
		}

		if (fileExpression != null && !fileExpression.isEmpty()) {
			System.out.println("Using file expression: " + fileExpression);
			return fileExpression;
		}

		// If no valid input is found, throw an error
		throw new ParseException("No valid expression provided from text or file.");
	}

	/**
	 * Creates the expression tree from the given expression string.
	 * 
	 * @param expression The input expression as a string.
	 * @return The expression tree.
	 */
	private ExpressionTreeNode createExpressionTree(String expression) {
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		return expTreeGen.makeExpression(expression);
	}
	// return new Multiply( new X(), new Y() );
}
