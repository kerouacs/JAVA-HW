
/**
* The original code just Given the value of the perimeter, 
* so the perimeter will not change after the height is reset.
* I changed the return value of perimeter in toString to 
* Make sure return height*2+width*2 each time.
*
* We define a rectangle by the three field variables width, height,
* and perimeter, each of type double. Furthermore, we write getters and
* setters for the three fields as well as a toString method. We test
* it in a main method.
*
* @version 2019-09-26
* @author Manfred Kerber
*/
public class Rectangle {
	private double width;
	private double height;
	private double perimeter;
	/**
	* <pre>
	* width
	* +--------------------------------------+
	* | |
	* | |
	* | | height
	* | |
	* | |
	* +--------------------------------------+
	* </pre>
	* @param width The width of the rectangle.
	* @param height The height of the rectangle.
	* @param perimeter The perimeter of the rectangle as 2
	* times the width plus the height.
	*/
	public Rectangle(double width, double height, double perimeter) {
		this.width = width;
		this.height = height;
		this.perimeter = perimeter;
	}
	/**
	* Getter for the width.
	* @return The width of the rectangle is returned.
	*/
	public double getWidth() {
		return width;
	}
	/**
	* Getter for the height.
	* @return The height of the rectangle is returned.
	*/
	public double getHeight() {
		return height;
	}
	/**
	* Getter for the perimeter.
	* @return The perimeter of the rectangle is returned.
	*/
	public double getPerimeter() {
		return perimeter;
	}
	/**
	* Setter for the width. The width of the rectangle is updated.
	* @param width The new width of the updated rectangle.
	*/
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	* Setter for the height. The height of the rectangle is updated.
	* @param height The new height of the updated rectangle.
	*/
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	* Setter for the perimeter. The perimeter of the
	* rectangle is updated.
	* @param perimeter The new perimeter of the updated rectangle.
	*/
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	/**
	* @return A human readable description of the rectangle in form
	* of the three field variables specifying it.
	*/
	public String toString() {
		return "The rectangle has a width of " + width +
		", a height of " + height +
		", and a perimeter of " + (width*2+height*2) + ".";
	}
	//I changed the code to width*2+height*2 above.
	/*
	* main method with a test of the setHeight setter and the
	* toString method.
	*/
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 4, 12);
		System.out.println(r);
		r.setHeight(5);
		System.out.println(r);
	}
}