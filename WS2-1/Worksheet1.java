/**
 * @author <Ruopeng Jiang> This class contains the solution for Worksheet1
 */

public class Worksheet1 {

	// Exercise 1
	/**
	 * Method raising integer m to the power of integer n (both non-negative)
	 * 
	 * @param m base of the calculation
	 * @param n index of the calculation
	 * @return integer m to the power of integer n
	 */
	static int power(int m, int n) {
		if (n == 1) {
			return m;
		}
		return m * power(m, n - 1);
	}

	/**
	 * Method raising integer m to the fast power of integer n (both non-negative)
	 * 
	 * @param m base of the calculation
	 * @param n index of the calculation
	 * @return integer m to the power of integer n
	 */
	static int fastPower(int m, int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return m;
		} else {
			if (n % 2 == 0) {
				return fastPower(m, n / 2) * fastPower(m, n / 2);
			} else
				return m * fastPower(m, n - 1);
		}
	}

	// Exercise 2
	/**
	 * method that returns a new list with all the elements of a with sign negated
	 * 
	 * @param a list to be operated
	 * @return a new list with all the elements of a with sign negated
	 */
	static List<Integer> negateAll(List<Integer> a) {

		if (a.isEmpty()) {
			return a;
		} else {
			return new List<Integer>(a.head * -1, negateAll(a.getTail()));
		}
	}

	// Exercise 3
	/**
	 * method that returns the position of the first occurrence of x in a. If x does
	 * not appear in the list, you should throw an IllegalArgumentException
	 * 
	 * @param x the integer in the list
	 * @param a list to be operated
	 * @return position of the first occurrence of x in a
	 */
	static int find(int x, List<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("No this number in List");
		} else {
			if (a.getHead() != x) {
				return find(x, a.getTail()) + 1;
			} else
				return 0;
		}
	}

	// Exercise 4
	/**
	 * method that return a boolean value indicating whether all its elements are
	 * even.
	 * 
	 * @param a list to be operated
	 * @return a boolean value indicating whether all its elements are even
	 */
	static boolean allEven(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else {
			if (a.getHead() % 2 == 0) {
				return allEven(a.getTail());
			} else
				return false;
		}
	}

	// Exercise 5
	/**
	 * method that return a new list which contains all the even elements of a
	 * 
	 * @param a list to be operated
	 * @return a new list which contains all the even elements of a
	 */
	static List<Integer> evenNumbers(List<Integer> a) {
		if (a.isEmpty()) {
			return a;
		} else {
			return a.getHead() % 2 == 0 ? new List<Integer>(a.getHead(), evenNumbers(a.getTail()))
					: evenNumbers(a.getTail());
		}
	}

	// Exercise 6
	/**
	 * method that return a boolean value indicating whether a is sorted in
	 * descending order
	 * 
	 * @param a list to be operated
	 * @return a boolean value indicating whether a is sorted in descending order
	 */
	static boolean sorted(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		} else {
			if (a.getHead() < a.getTail().getHead()) {
				return false;
			} else
				return sorted(a.getTail());
		}
	}

	// Exercise 7
	/**
	 * method that return a new sorted list that contains all the elements of a and
	 * all the elements of b
	 * 
	 * @param a list to be operated
	 * @param   b, a list to be operated
	 * @return a new sorted list that contains all the elements of a and all the
	 *         elements of b
	 */
	static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) {
			return b;
		}
		if (b.isEmpty()) {
			return a;
		} else
			return a.getHead() >= b.getHead() ? new List<Integer>(a.getHead(), merge(a.getTail(), b))
					: new List<Integer>(b.getHead(), merge(a, b.getTail()));

	}

	// Exercise 8
	/**
	 * method that return a new list which contains all the even elements of a
	 * 
	 * @param a list to be operated
	 * @return a new list which contains all the even elements of a
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return a;
		} else
			return new List<Integer>(notDuplicates(a).getHead(), removeDuplicates(notDuplicates(a).getTail()));
	}

	/**
	 * method that estimate the list is not a duplicates one.
	 * 
	 * @param a list to be operated
	 * @return a list is not a duplicates one.
	 */
	static List<Integer> notDuplicates(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return a;
		} else if (a.getHead() == a.getTail().getHead()) {
			return notDuplicates(a.getTail());
		} else
			return a;
	}
}
