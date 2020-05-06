/** 
 * The original program mistake is that Java does manipulate objects by reference, and all object variables are references.
 * Java doesn't pass method arguments by reference; it passes them by value.
 * Besides this,this swap method has not temp for intermediate variable.So the i value lost.
 * @author  RUOPENG JIANG
 * @since 2019-10-06
 * @version 2019-07-16
 */
public class EX4{
	 /**
	 *  swaps i and j
	 *  @param j 1st variable.
	 *  @param j 2nd variable.
	 */
     public static void swap(int[]arr){
     int temp=arr[0];
     arr[0]=arr[1];
     arr[1]=temp;
     }

     public static void main(String[] args){
         int[]arr={10,20};
		 System.out.println("Original i:"+arr[0]+" k:"+arr[1]);
		 swap (arr);
		 System.out.println("After swapping i:"+arr[0]+" k:"+arr[1]);
     }
}
