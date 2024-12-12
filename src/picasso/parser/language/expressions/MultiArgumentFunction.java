package picasso.parser.language.expressions;

//import java.util.List;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Parent Class for a multi-argument function.
 * 
 * @author Edward Ross 
 *
 * @author Sanjog Basnet
 */

public abstract class MultiArgumentFunction extends ExpressionTreeNode{
	
	
	protected ExpressionTreeNode parx;
	protected ExpressionTreeNode pary;



	public MultiArgumentFunction(ExpressionTreeNode param1,ExpressionTreeNode param2) { 
		this.parx = param1;
		this.pary = param2;
	}
	public MultiArgumentFunction() {
		
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
		if (!(o instanceof MultiArgumentFunction)) {
			return false;
		}

		// Ensure the objects are of the same type
		if (o.getClass() != this.getClass()) {
			return false;
		}

		MultiArgumentFunction other = (MultiArgumentFunction) o;

		// Check if the parameters are equal
		return this.parx.equals(other.parx) && this.pary.equals(other.pary);
	}
	
	
//	protected List<ExpressionTreeNode> params;
//	
//	
//	public MultiArgumentFunction(List<ExpressionTreeNode> params) { //We store our params in a list
//		this.params = params;
//		
//		}
//	
//	@Override
//	public String toString() {
//		String classname = this.getClass().getName();
//		StringBuilder stringBuilder = new StringBuilder(); //We create a string builder object to make our string of with n parameters
//		
//		stringBuilder.append(classname.substring(classname.lastIndexOf(".") + 1)).append("("); //We use last index of to realize where we start our parameters
//		
//		for(int i = 0; i < params.size(); i++) { // Simple loop to iterate over all parameters and then append them to our string builder object
//			stringBuilder.append(params.get(i).toString());
//			if (i < params.size() - 1) {
//				stringBuilder.append(", ");
//			}
//		}
//		stringBuilder.append(")"); // close off string parameters
//		return stringBuilder.toString(); //return string!
//	}
//	 @Override
//	 public boolean equals(Object o) {
//	     if (o == this) {
//	         return true;
//	        }
//
//	     if (!(o instanceof MultiArgumentFunction)) {
//	         return false;
//	        }
//
//	     // Make sure the objects are the same type
//	     if (o.getClass() != this.getClass()) {
//	         return false;
//	        }
//
//	     MultiArgumentFunction multiArgumentFunction = (MultiArgumentFunction) o;
//
//	     // Check if the parameters are equal, this differs from unary function as we can check size (length first) to optimize then we interate through each parameter for uniqueness
//	     if (this.params.size() != multiArgumentFunction.params.size()) {
//	         return false;
//	        }
//
//	     for (int i = 0; i < this.params.size(); i++) {
//	         if (!this.params.get(i).equals(multiArgumentFunction.params.get(i))) {
//	             return false;
//	            }
//	        }
//
//	     return true;
//	    }
}

