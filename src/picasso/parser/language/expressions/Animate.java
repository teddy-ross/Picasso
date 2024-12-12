package picasso.parser.language.expressions;

import java.util.concurrent.TimeUnit;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents animate in a Picasso expression
 * 
 * @author Sarina Cusumano
 * 
 */
public class Animate extends ExpressionTreeNode {

	ExpressionTreeNode node;
	
	public Animate(ExpressionTreeNode node){
    	this.node = node;
    	

    }
	
	/**		
		}*/
	
	@Override
	public RGBColor evaluate(double x, double y) {
		try {
			TimeUnit.MICROSECONDS.sleep(20); // Sleep for one second
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Restore interrupted status
		}
		return node.evaluate(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Animate)) {
			return false;
		}
		return true;
	}


}
