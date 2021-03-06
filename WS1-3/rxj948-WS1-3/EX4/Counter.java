import java.util.Scanner;
import java.util.regex.Pattern;
/**
* Problem:The original code did not terminate the loop after each cases,so user can not run it many times.
* and there is no feedback for each cases
* and it did not throw exception when counter is negative.
* Improve:So I added "continue" after cases 1 to 4,and "break" after case 5, 
* improved to "continue" out the switch.
* Then added some feedbacks when users did cases.
* Finally I throw the new exception when the counter is negative.
*/

/**
* The class is used in order to interactively count a number of
* persons/items in a room, storeroom, etc. A user is able to select
* between five options:
* <pre>
* 1. add to the counter,
* 2. subtract from the counter,
* 3. show the counter,
* 4. set the counter to a new value, and
* 5. exit the program.
* </pre>
* @author Manfred Kerber and Alexandros Evangelidis
* @version 2019-10-21
*/
public class Counter {
	/**
	* Pattern for the choice of input: either 1, 2, 3, 4, or 5
	*/
	public static final Pattern p12345 = Pattern.compile("[12345]");
	/**
	* Field variable to store the value of the counter.
	*/
	private int counter;
	/**
	* The constructor initializes the counter as 0. Starts a scanner
	* to read from the command line, offering 5 choices for (add,
	* subtract, show counter, set counter, and exit). It stays in a
	* loop until the program is explicitly exited by entering 5.
	* It has no parameters.
	*/
	public Counter(){
		this.counter = 0;
		//System.in is like System.out, however, for input and not for output.
		Scanner s = new Scanner(System.in);
		/* can take value 1 (add)
		* 2 (subtract)
		* 3 (show counter)
		* 4 (set counter)
		* 5 (exit)
		*/
		byte topChoice = 1; // Can be anything but 5 to enter the loop
		while (topChoice != 5) {
			System.out.println("Please enter:\n"+
			"1 to add to the total\n" +
			"2 to subtract from the total\n"+
			"3 to show the total\n"+
			"4 to set the total\n"+
			"5 to exit the program");
			topChoice = (byte) Integer.parseInt(s.next(p12345));
			switch(topChoice) {
				case 1: add(s);continue;
				case 2: subtract(s);continue;
				case 3: show();continue;
				case 4: set(s);continue;
				case 5: System.out.println("Finally there are "
				+ counter + " items available.");break;
				default: throw new IllegalArgumentException();
			}
			continue;
		}
	}
	/**
	* The method reads in a number from the input and adds it to the counter.
	* @param s The scanner from which the input is read.
	*/
	public void add(Scanner s) {
		System.out.println("How much to add?");
		try {
			counter += Integer.parseInt(s.next());
			if (counter<0) {
				throw new IllegalArgumentException("the left must be positve or zero");
			}
			System.out.println("You added:"+counter+"\nWhat you wan to do next?");

		}
		catch (NumberFormatException e) {
			System.out.println("You need to enter an integer.");
			s = new Scanner(System.in);
		}
	}
	/**
	* The method reads in a number from the input and subtracts it
	* from the counter.
	* @param s The scanner from which the input is read.
	*/
	public void subtract(Scanner s) {
	System.out.println("How much to subtract?");
		try {
			counter -= Integer.parseInt(s.next());
			if (counter<0) {
				throw new IllegalArgumentException("the left must be positve or zero");
			}
			System.out.println("You subtracted:"+counter+"\nWhat you wan to do next?");
		}
		catch (NumberFormatException e) {
			System.out.println("You need to enter an integer.");
			s = new Scanner(System.in);
		}
	}
	/**
	* The method prints the current value of the counter.
	*/
	public void show() {
		if (counter<0) {
			throw new IllegalArgumentException("the left must be positve or zero");
		}
		System.out.println("Currently there are " + counter +
		" items available.\nWhat you wan to do next?");
	}
	/**
	* The method reads in a number from the input and sets the
	* counter to this value
	* @param s The scanner from which the input is read.
	*/
	public void set(Scanner s) {
		System.out.println("To which value do you want to set the counter?");
		try {
			counter = Integer.parseInt(s.next());
			if (counter<0) {
				throw new IllegalArgumentException("the left must be positve or zero");
			}
			System.out.println("You set:"+counter+"\nWhat you wan to do next?");
		}
		catch (NumberFormatException e) {
			System.out.println("You need to enter an integer and left must be positive.");
			s = new Scanner(System.in);
		}
	}
	public static void main(String[] args) {
		Counter parcels = new Counter();
	}
}