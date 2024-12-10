/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the parent class for binary operators
 * 
 * @author Sanjog Basnet
 */
public abstract class BinaryOperator extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;
	/**
	 * 
	 */
	public BinaryOperator(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
	}
	/**
	 * Returns the string representation in the format "x/y"
	 * 
	 */
	
	@Override
	public String toString() {
		return this.left + this.getOperator() + this.right;
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BinaryOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryOperator bo = (BinaryOperator) o;

		// check if their parameters are equal
		if (!(this.left.equals(bo.left)) || !(this.right.equals(bo.right))){
			return false;
		}
		return true;
	}
	
	public abstract String getOperator(); 
}



