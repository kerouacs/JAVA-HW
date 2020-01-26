/**
 * @author <PUT YOUR NAME HERE>
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	private static List result;
	// Exercise 1

	static Tree<Integer> negateAll(Tree<Integer> t) {
		if(t.isEmpty()) {
			return t;
		}
		return new Tree<Integer>(t.value*-1,negateAll(t.getLeft()),negateAll(t.getRight()));
	}

	// Exercise 2

	static boolean allEven(Tree<Integer> a) {
		if(a.isEmpty()) {
			return true;
		}
		if(a.getValue()%2==0) {
			return allEven(a.getLeft())&&allEven(a.getRight());
		}else return false;

	}

	// Exercise 3

	static int depth(Tree<Integer> a, int x) {	
			return getDepth(a, x, 0);
	}
	static int getDepth(Tree<Integer> a, int x, int dep) {
		if (a.isEmpty()) return -1;
		if (a.value == x) {
			return dep;
		}
		return Math.max(getDepth(a.getLeft(), x, dep + 1),
				getDepth(a.getRight(), x, dep + 1));


	}
	// Exercise 4

	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<>();
		}
		List<E> ar = new List<>();
		List<E> al = new List<>();
		if (!a.right.isEmpty()) {
			 ar = preorder(a.right);
		}
		if (!a.left.isEmpty()) {
			 al = preorder(a.left);
		}
//		List<E> lr = merge(al, ar);
//		List<E> res = new List(a.value, lr);
		return new List<>(a.value, merge(al, ar));
	}

	/**
	 *
	 * @param al The list from the left subtree.
	 * @param ar The list from the right subtree.
	 * @param <E> The generic type of the List.
	 * @return The merge list of two list from subtrees.
	 */
	private static <E> List<E> merge(List<E> al, List<E> ar) {
		if (al.isEmpty()) return ar;
		return new List<>(al.getHead(), merge(al.getTail(), ar));
	}

	// Exercise 5

	static boolean isSearchTree(Tree<Integer> a) {
		return true;
	}

	// Exercise 6

	static void printDescending(Tree<Integer> a) {
	}

	// Exercise 7

	static int max(Tree<Integer> a) {
		return 0;
	}

	// Exercise 8

	static Tree<Integer> delete(Tree<Integer> a, int x) {
		return new Tree<Integer>();
	}

	// Exercise 9
	static <E> boolean isHeightBalanced(Tree<E> a) {
		return true;
	}

	// Exercise 10

	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		return new Tree<Integer>();
	}

	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		return new Tree<Integer>();
	}
	static void printList (List <Integer> L) {
		if (L.isEmpty())
		return;
		else {
		System.out.println(L.getHead());
		printList(L.getTail());
		}
		}
	public static void main(String[] args) {
		Tree a=new Tree<> (5,new Tree<>(3,new Tree<>(1),new Tree<>(4)),new Tree<>(8,new Tree<>(6),new Tree<>()));
//		Tree.print(a);
		printList(preorder(a));
	}
		
}
	
