import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <Ruopeng Jiang> This class contains the test cases for Worksheet2
 *         solutions. <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet2Test {
	Tree<Integer> T1;
	Tree<Integer> T2;
	Tree<Integer> T3;
	Tree<Integer> T4;

	@BeforeEach
	public void beforeEach() {

	}

	// test for exercise1
	@Test
	public void test1() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(-5, new Tree<>(-3, new Tree<>(-1), new Tree<>(-4)),
				new Tree<>(-8, new Tree<>(-6), new Tree<>()));
		;
		Tree<Integer> actual = Worksheet2.negateAll(T1);
		assertEquals(expected, actual, "error in exercise1");
	}

	@Test
	public void test2() {
		Tree T2 = new Tree<>(10, new Tree<>(8), new Tree<>(12, new Tree<>(11), new Tree<>(15)));
		Tree<Integer> expected = new Tree<>(-10, new Tree<>(-8), new Tree<>(-12, new Tree<>(-11), new Tree<>(-15)));
		Tree<Integer> actual = Worksheet2.negateAll(T2);
		assertEquals(expected, actual, "error in exercise1");
	}

	@Test
	public void test3() {
		Tree T3 = new Tree<>(-10, new Tree<>(-12, new Tree<>(-20), new Tree<>()),
				new Tree<>(0, new Tree<>(), new Tree<>(2)));
		Tree<Integer> expected = new Tree<>(10, new Tree<>(12, new Tree<>(20), new Tree<>()),
				new Tree<>(0, new Tree<>(), new Tree<>(-2)));
		Tree<Integer> actual = Worksheet2.negateAll(T3);
		assertEquals(expected, actual, "error in exercise1");
	}

	@Test
	public void test4() {
		Tree T4 = new Tree<>(10, new Tree<>(80), new Tree<>(2));
		Tree<Integer> expected = new Tree<>(-10, new Tree<>(-80), new Tree<>(-2));
		Tree<Integer> actual = Worksheet2.negateAll(T4);
		assertEquals(expected, actual, "error in exercise1");
	}

	// test for exercise2
	@Test
	public void test5() {
		Tree T4 = new Tree<>(10, new Tree<>(80), new Tree<>(2));
		Boolean expected = true;
		Boolean actual = Worksheet2.allEven(T4);
		assertEquals(expected, actual, "error in exercise2");
	}

	@Test
	public void test6() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Boolean expected = false;
		Boolean actual = Worksheet2.allEven(T1);
		assertEquals(expected, actual, "error in exercise2");
	}

	// test for exercise3
	@Test
	public void test7() {
		Tree T4 = new Tree<>(10, new Tree<>(80), new Tree<>(2));
		int expected = 1;
		int actual = Worksheet2.depth(T4, 80);
		assertEquals(expected, actual, "error in exercise3");
	}

	@Test
	public void test8() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		int expected = -1;
		int actual = Worksheet2.depth(T1, 80);
		assertEquals(expected, actual, "error in exercise3");
	}

	// test for exercise4
	@Test
	public void test9() {
		Tree T4 = new Tree<>(10, new Tree<>(80), new Tree<>(2));
		List<Integer> expected = new List<Integer>(10,
				new List<Integer>(80, new List<Integer>(2, new List<Integer>())));
		;
		List<Integer> actual = Worksheet2.preorder(T4);
		assertEquals(expected, actual, "error in exercise4");
	}

	@Test
	public void test10() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		List<Integer> expected = new List<Integer>(5, new List<Integer>(3, new List<Integer>(1,
				new List<Integer>(4, new List<Integer>(8, new List<Integer>(6, new List<Integer>()))))));
		List<Integer> actual = Worksheet2.preorder(T1);
		assertEquals(expected, actual, "error in exercise4");
	}

	// test for exercise5

	@Test
	public void test11() {
		Tree T4 = new Tree<>(10, new Tree<>(80), new Tree<>(2));
		Boolean expected = false;
		Boolean actual = Worksheet2.isSearchTree(T4);
		assertEquals(expected, actual, "error in exercise5");
	}

	@Test
	public void test12() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Boolean expected = true;
		Boolean actual = Worksheet2.isSearchTree(T1);
		assertEquals(expected, actual, "error in exercise5");
	}

	// test for exercise7
	@Test
	public void test13() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		int expected = 8;
		int actual = Worksheet2.max(T1);
		assertEquals(expected, actual, "error in exercise7");
	}

	@Test
	public void test14() {
		Tree T3 = new Tree<>(-10, new Tree<>(-12, new Tree<>(-20), new Tree<>()),
				new Tree<>(0, new Tree<>(), new Tree<>(2)));
		int expected = 2;
		int actual = Worksheet2.max(T3);
		assertEquals(expected, actual, "error in exercise7");
	}

	// test for exercise8
	@Test
	public void test15() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(), new Tree<>()));
		Tree<Integer> actual = Worksheet2.delete(T1, 6);
		assertEquals(expected, actual, "error in exercise8");
	}

	@Test
	public void test16() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(4, new Tree<>(3, new Tree<>(1), new Tree<>()),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> actual = Worksheet2.delete(T1, 5);
		assertEquals(expected, actual, "error in exercise8");
	}

	@Test
	public void test17() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(6, new Tree<>(), new Tree<>()));
		Tree<Integer> actual = Worksheet2.delete(T1, 8);
		assertEquals(expected, actual, "error in exercise8");
	}

	// test for exercise9
	@Test
	public void test18() {
		Tree T4 = new Tree<>(10, new Tree<>(80), new Tree<>(2));
		Boolean expected = true;
		Boolean actual = Worksheet2.isHeightBalanced(T4);
		assertEquals(expected, actual, "error in exercise9");
	}

	@Test
	public void test19() {
		Tree T5 = new Tree<>(10, new Tree<>(80, new Tree<>(5), new Tree<>()), new Tree<>());
		Boolean expected = false;
		Boolean actual = Worksheet2.isHeightBalanced(T5);
		assertEquals(expected, actual, "error in exercise9");
	}

	// test for exercise10
	@Test
	public void test20() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(4, new Tree<>(3, new Tree<>(1), new Tree<>()),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> actual = Worksheet2.deleteHB(T1, 5);
		assertEquals(expected, actual, "error in exercise10");
	}

	@Test
	public void test21() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(), new Tree<>()));
		Tree<Integer> actual = Worksheet2.deleteHB(T1, 6);
		assertEquals(expected, actual, "error in exercise10");
	}

	@Test
	public void test22() {
		Tree T7 = new Tree<>(10, new Tree<>(9, new Tree(8), new Tree()), new Tree<>(11));
		Tree<Integer> expected = new Tree<>(9, new Tree<>(8), new Tree<>(10));
		Tree<Integer> actual = Worksheet2.deleteHB(T7, 11);
		assertEquals(expected, actual, "error in exercise10");
	}

	@Test
	public void test23() {
		Tree T6 = new Tree<>(10, new Tree<>(9), new Tree<>());
		Tree<Integer> expected = new Tree<>(9, new Tree<>(6), new Tree<>(10));
		Tree<Integer> actual = Worksheet2.insertHB(T6, 6);
		assertEquals(expected, actual, "error in exercise10");
	}

	@Test
	public void test24() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>(10)));
		Tree<Integer> actual = Worksheet2.insertHB(T1, 10);
		assertEquals(expected, actual, "error in exercise10");
	}

	@Test
	public void test25() {
		Tree T1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>()));
		Tree<Integer> expected = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(7, new Tree<>(6), new Tree<>(8)));
		Tree<Integer> actual = Worksheet2.insertHB(T1, 7);
		assertEquals(expected, actual, "error in exercise10");
	}
}
