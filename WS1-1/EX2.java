/** 
 * This program is about converting masses in the imperial system into kilograms
 * and test for valuess 11stones and 6pounds.
 * @author  RUOPENG JIANG
 * @since 2019-10-06
 * @version 2019-07-16
 */
class EX2{
	public static double imperialToKg(double ton,double hundredweight,double quarter,double stone,double pound,double ounce,double drachm,double grain){
      double total;
	  total=pound+2240*ton+112*hundredweight+28*quarter+14*stone+1/16*ounce+1/256*drachm+1/7000*grain;
	  double kilograms;
	  kilograms=0.45359237*total;
	  return kilograms;
	}
	public static void main(String [ ] args) {
      System.out.println(imperialToKg(0,0,0,11,6,0,0,0));
	}
}