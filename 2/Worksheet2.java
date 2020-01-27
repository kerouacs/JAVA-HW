/**
 * @author <PUT YOUR NAME HERE> This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {


	// Exercise 1

	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()) {
			return t;
		}
		return new Tree<Integer>(t.value * -1, negateAll(t.getLeft()), negateAll(t.getRight()));
	}

	// Exercise 2

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

	static int depth(Tree<Integer> a, int x) {
		if (a.isEmpty())
			return -1;
		if (a.value == x) {
			return 0;
		}
		return Math.max(depth(a.getLeft(), x) == -1 ? -1 : 1 + depth(a.getLeft(), x),
				depth(a.getRight(), x) == -1 ? -1 : 1 + depth(a.getRight(), x));
	}

	// Exercise 4

	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<>();
		}
		List<E> r = new List<>();
		List<E> l = new List<>();
		if (!a.right.isEmpty()) {
			 r = preorder(a.right);
		}
		if (!a.left.isEmpty()) {
			 l = preorder(a.left);
		}
		return new List<>(a.value, merge(l, r));
	}


	private static <E> List<E> merge(List<E> l, List<E> r) {
		if (l.isEmpty()) return r;
		return new List<>(l.getHead(), merge(l.getTail(), r));
	}


	// Exercise 5

	static boolean isSearchTree(Tree<Integer> a) {
		return helpMethod(a,0);
	}
	
	
	static boolean helpMethod(Tree<Integer> a,int last) {
    if(a.isEmpty())
        return true;
    if(!isSearchTree(a.getLeft()))
        return false;
    if(a.getValue()< last)
        return false;
    last = a.getValue();
    if(!isSearchTree(a.getRight()))
        return false;
    return true;
	}
    


	// Exercise 6

	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty() ) {
			return;
		}
		printDescending(a.right);
		System.out.println(a.value);
		printDescending(a.left);
	}
	

	// Exercise 7

	static int max(Tree<Integer> a) {
		if(a.isEmpty()) {
			return 0;
		}
		if(a.getRight().isEmpty()) {
			return a.getValue();
		}
		return max(a.getRight());
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

	static void printList(List<Integer> L) {
		if (L.isEmpty())
			return;
		else {
			System.out.println(L.getHead());
			printList(L.getTail());
		}
	}

	public static void main(String[] args) {
		Tree a = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)), new Tree<>(8, new Tree<>(6), new Tree<>()));
//		Tree.print(a);
//		printList(preorder(a));
		System.out.println(max(a));
//		printDescending(a);
	}

}
