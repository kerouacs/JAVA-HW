/**
 * @author <Ruopeng Jiang> This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1
	/**
	 * method that returns a new tree containing all the elements of a with their
	 * sign negated.
	 * 
	 * @param a Given a tree of integers.
	 * @return a new tree containing all the elements of a with their sign negated
	 */
	static Tree<Integer> negateAll(Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<>();
		}
		return new Tree<Integer>(a.getValue() * -1, negateAll(a.getLeft()), negateAll(a.getRight()));
	}

	// Exercise 2
	/**
	 * method that return a boolean value indicating whether all the values in its
	 * nodes are even.
	 * 
	 * @param a Given a tree of integers.
	 * @return a boolean value indicating whether all the values in its nodes are
	 *         even.
	 */
	static boolean allEven(Tree<Integer> a) {
		if (a.isEmpty()) {
			return true;
		}
		if (a.getValue() % 2 == 0) {
			return allEven(a.getLeft()) && allEven(a.getRight());
		} else
			return false;

	}

	// Exercise 3
	/**
	 * method that returns the depth of the given node value nodes are even.
	 * 
	 * @param a Given a tree of integers.
	 * @param x Given a integer.
	 * @return returns the depth of the given node value nodes are even.
	 */
	static int depth(Tree<Integer> a, int x) {
		if (a.isEmpty())
			return -1;
		if (a.getValue() == x) {
			return 0;
		}
		return Math.max(depth(a.getLeft(), x) == -1 ? -1 : 1 + depth(a.getLeft(), x),
				depth(a.getRight(), x) == -1 ? -1 : 1 + depth(a.getRight(), x));
	}

	// Exercise 4
	/**
	 * method that return a list containing the values in a by traversing the nodes
	 * in preorder.
	 * 
	 * @param a Given a tree of integers.
	 * @return return a list containing the values in a by traversing the nodes in
	 *         preorde
	 */
	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<>();
		}
		List<E> r = new List<>();
		List<E> l = new List<>();
		if (!a.getRight().isEmpty()) {
			r = preorder(a.getRight());
		}
		if (!a.getLeft().isEmpty()) {
			l = preorder(a.getLeft());
		}
		return new List<>(a.getValue(), merge(l, r));
	}

	/**
	 * method that return two lists merged
	 * 
	 * @param l Given a first list.
	 * @param r Given a second list.
	 * @return return a merged list
	 */
	private static <E> List<E> merge(List<E> l, List<E> r) {
		if (l.isEmpty())
			return r;
		return new List<>(l.getHead(), merge(l.getTail(), r));
	}

	// Exercise 5
	/**
	 * method that returns a boolean value indicating whether a is a binary search
	 * tree.
	 * 
	 * @param a Given a tree of integers.
	 * @return returns a boolean value indicating whether a is a binary search tree.
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		return helpMethod(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * method that returns a boolean value indicating whether a is a binary search
	 * tree.
	 * 
	 * @param a      Given a tree of integers.
	 * @param minVal min of integers.
	 * @param maxVal max of integers.
	 * @return returns a boolean value indicating whether a is a binary search tree.
	 */
	static boolean helpMethod(Tree<Integer> a, int minVal, int maxVal) {
		if (a.isEmpty()) {
			return true;
		}
		if (a.getValue() > minVal && a.getValue() < maxVal) {
			return helpMethod(a.getLeft(), minVal, a.getValue()) && helpMethod(a.getRight(), a.getValue(), maxVal);
		}

		return false;
	}

	// Exercise 6
	/**
	 * method that prints the values stored in it in descending order
	 * 
	 * @param a Given a tree of integers.
	 * @return prints the values stored in it in descending order
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty()) {
			return;
		}
		printDescending(a.getRight());
		System.out.println(a.getValue());
		printDescending(a.getLeft());
	}

	// Exercise 7
	/**
	 * method that find the maximum value stored in the tree
	 * 
	 * @param a Given a tree of integers.
	 * @return the maximum value stored in the tree
	 */
	static int max(Tree<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		}
		if (a.getRight().isEmpty()) {
			return a.getValue();
		}
		return max(a.getRight());
	}

	// Exercise 8
	/**
	 * method that delete the value x from a and return the resulting tree
	 * 
	 * @param a Given a tree of integers.
	 * @param x Given a integer.
	 * @return delete the value x from a and return the resulting tree
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return null;
		}
		if (a.getValue() < x) {
			return new Tree<Integer>(a.getValue(), a.getLeft(), delete(a.getRight(), x));
		}
		if (a.getValue() > x) {
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), a.getRight());
		} else {
			if (a.getLeft().isEmpty()) {
				return a.getRight();
			} else if (a.getRight().isEmpty()) {
				return a.getLeft();
			} else {
				return new Tree<>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
			}
		}
	}

	// Exercise 9
	/**
	 * method to see if it is height-balanced, returning a boolean value.
	 * 
	 * @param a Given a tree of integers.
	 * @return a boolean value.
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty())
			return true;
		int left = getDepth(a.getLeft(), 1);
		int right = getDepth(a.getRight(), 1);
		return Math.abs(left - right) <= 1 && isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());

	}
	/**
	 * method to get depth.
	 * 
	 * @param a Given a tree of integers.
	 * @param root depth
	 * @return tree depth.
	 */
	static <E> int getDepth(Tree<E> a, int depth) {
		if (a.isEmpty())
			return depth;
		int left = getDepth(a.getLeft(), depth + 1);
		int right = getDepth(a.getRight(), depth + 1);
		return Math.max(left, right);

	}

	// Exercise 10
	/**
	 * method to LL rotation
	 * 
	 * @param a Given a tree of integers.
	 * @return LL rotation tree
	 */
	private static Tree<Integer> leftLeft(Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		}
		return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(),
				new Tree<Integer>(a.getValue(), a.getLeft().getRight(), a.getRight()));
	}
	/**
	 * method to RR rotation
	 * 
	 * @param a Given a tree of integers.
	 * @return RR rotation tree
	 */
	private static Tree<Integer> rightRight(Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		}
		return new Tree<Integer>(a.getRight().getValue(),
				new Tree<Integer>(a.getValue(), a.getLeft(), a.getRight().getLeft()), a.getRight().getRight());
	}
	/**
	 * method to RL rotation
	 * 
	 * @param a Given a tree of integers.
	 * @return RL rotation tree
	 */
	private static Tree<Integer> rightLeft(Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		}
		return new Tree<Integer>(a.getRight().getLeft().getValue(),
				new Tree<Integer>(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()),
				new Tree<Integer>(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight()));
	}
	/**
	 * method to LR rotation
	 * 
	 * @param a Given a tree of integers.
	 * @return LR rotation tree
	 */
	private static Tree<Integer> leftRight(Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		}
		return new Tree<Integer>(a.getLeft().getRight().getValue(),
				new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight().getLeft()),
				new Tree<Integer>(a.getValue(), a.getLeft().getRight().getRight(), a.getRight()));
	}
	/**
	 * method to balance tree
	 * 
	 * @param a Given a tree of integers.
	 * @return balanced tree
	 */
	private static Tree<Integer> balance(Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		}
		if (a.getLeft().getHeight() - a.getRight().getHeight() > 1) {
			if (a.getLeft().getLeft().getHeight() > a.getLeft().getRight().getHeight()) {
				return leftLeft(a);
			} else {
				return leftRight(a);
			}
		}
		if (a.getRight().getHeight() - a.getLeft().getHeight() > 1) {
			if (a.getRight().getLeft().getHeight() > a.getRight().getRight().getHeight()) {
				return rightLeft(a);
			} else {
				return rightRight(a);
			}
		} else
			return a;
	}
	/**
	 * method to insert x to balanced tree
	 * 
	 * @param a Given a tree of integers.
	 * @param x Given a integer.
	 * @return inserted balanced tree
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>(x);
		}
		if (x < a.getValue()) {
			return balance(new Tree<>(a.getValue(), insertHB(a.getLeft(), x), a.getRight()));
		} else {
			return balance(new Tree<>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x)));
		}

	}
	/**
	 * method to delete x to balanced tree
	 * 
	 * @param a Given a tree of integers.
	 * @param x Given a integer.
	 * @return deleted balanced tree
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		return balance(delete(a, x));
	}
}
