/**
 * 
 */
package picasso.parser.tokens;

/**
 * Represents an image file (image name string:"img1.jpg")
 * 
 * @author Sanjog Basnet
 */
public class ImgNameStrToken extends Token {

	private final String imgName;

	/**
	 * @param description
	 */
	public ImgNameStrToken(String value) {
		super("ImageNameString Token");
		imgName = value;

	}

	public boolean equals(Object o) {
		if( o == this ) {
			return true;
		}
		if (!(o instanceof ImgNameStrToken)) {
			return false;
		}
		ImgNameStrToken rhs = (ImgNameStrToken) o;
		return imgName.equals(rhs.imgName);
	}

	/**
	 * Returns the identifier's name
	 * @return the identifier's name
	 */
	public String getName() {
		return imgName;
	}

	public String toString() {
		return super.toString() + ": " + imgName;
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

}