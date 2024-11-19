/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

import picasso.parser.language.expressions.UnaryFunction;

/**
 * 
 */
public class TanFunction extends UnaryFunction{
	
	private final SineFunction sin;
	private final CosineFunction cos; 

	/**
	 * 
	 */
	public TanFunction(ExpressionTreeNode param) {
		super(param);
		
		this.sin = new SinFunction(param);
		this.cos = new CosFunction(param);
	}

}
