/** 
 * This program is about how to compute a circle area ,just need Math.PI*radius*radius.
 * and test for the radius 0,5,10.
 * @author  RUOPENG JIANG
 * @since 2019-10-06
 * @version 2019-07-16
 */
public class EX1{
	public static double areaCircle(double radius){
		return Math.PI*radius*radius;
	}
	public static void main(String args[]){
		System.out.println(areaCircle(0));
		System.out.println(areaCircle(5));
		System.out.println(areaCircle(10));
	}
}