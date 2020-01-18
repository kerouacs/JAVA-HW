import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <Ruopeng Jiang> This class contains the test cases for Worksheet1
 *         solutions. <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet1Test {

	List<Integer> L1;
	List<Integer> L2;
	List<Integer> L3;
	List<Integer> L4;

	@BeforeEach
	public void beforeEach() {
		L1 = new List(9, new List(8, new List(7, new List(6, new List()))));
		L2 = new List(8, new List(8, new List(8, new List(8, new List()))));
		L3 = new List(0, new List(-1, new List(-2, new List(-3, new List()))));
		L4 = new List(1000, new List(1500, new List(1800, new List(0, new List()))));
	}

	// test for exercise1 power
	@Test
	public void test1() {
		int expected = 8;
		int actual = Worksheet1.power(2, 3);
		assertEquals(expected, actual, "error in exercise1");
	}

	@Test
	public void test2() {
		int expected = 16;
		int actual = Worksheet1.power(2, 4);
		assertEquals(expected, actual, "error in exercise1");
	}

	// test for exercise1 fastPower
	@Test
	public void test3() {
		int expected = 8;
		int actual = Worksheet1.fastPower(2, 3);
		assertEquals(expected, actual, "error in exercise1");
	}

	@Test
	public void test4() {
		int expected = 16;
		int actual = Worksheet1.fastPower(2, 4);
		assertEquals(expected, actual, "error in exercise1");
	}

	// test for exercise2
	@Test
	public void test5() {
		List<Integer> expected = new List<Integer>(-9,
				new List<Integer>(-8, new List<Integer>(-7, new List(-6, new List()))));
		List actual = Worksheet1.negateAll(L1);
		assertEquals(expected, actual, "error in exercise2");
	}

	@Test
	public void test6() {
		List<Integer> expected = new List(0, new List(1, new List(2, new List(3, new List()))));
		List<Integer> actual = Worksheet1.negateAll(L3);
		assertEquals(expected, actual, "error in exercise2");
	}

	// test for exercise3
	@Test
	public void test7() {
		int expected = 3;
		int actual = Worksheet1.find(6, L1);
		assertEquals(expected, actual, "error in exercise3");
	}

	@Test
	public void test8() {
		int expected = 0;
		int actual = Worksheet1.find(8, L2);
		assertEquals(expected, actual, "error in exercise3");
	}

	@Test
	public void test9() {
		try {
			int expected = Worksheet1.find(2, L2);
			int actual = -1;
			Assertions.assertEquals(expected, actual);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("No this number in List", e.getMessage());
		}
	}

	// test for exercise4
	@Test
	public void test10() {
		boolean expected = false;
		boolean actual = Worksheet1.allEven(L1);
		assertEquals(expected, actual, "error in exercise4");
	}

	@Test
	public void test11() {
		boolean expected = true;
		boolean actual = Worksheet1.allEven(L2);
		assertEquals(expected, actual, "error in exercise4");
	}

	// test for exercise5
	@Test
	public void test12() {
		List<Integer> expected = new List<Integer>(8, new List<Integer>(6, new List<Integer>()));
		List actual = Worksheet1.evenNumbers(L1);
		assertEquals(expected, actual, "error in exercise5");
	}

	@Test
	public void test13() {
		List<Integer> expected = new List<Integer>(0, new List<Integer>(-2, new List<Integer>()));
		List actual = Worksheet1.evenNumbers(L3);
		assertEquals(expected, actual, "error in exercise5");
	}

	// test for exercise6
	@Test
	public void test14() {
		boolean expected = true;
		boolean actual = Worksheet1.sorted(L1);
		assertEquals(expected, actual, "error in exercise6");
	}

	@Test
	public void test15() {
		boolean expected = true;
		boolean actual = Worksheet1.sorted(L2);
		assertEquals(expected, actual, "error in exercise6");
	}

	@Test
	public void test16() {
		boolean expected = false;
		boolean actual = Worksheet1.sorted(L4);
		assertEquals(expected, actual, "error in exercise6");
	}

	// test for exercise7
	@Test
	public void test17() {
		List L5 = new List(0, new List(0, new List()));
		List L6 = new List(5, new List(2, new List()));
		List expected = new List(5, new List(2, new List(0, new List(0, new List()))));
		List actual = Worksheet1.merge(L5, L6);
		assertEquals(expected, actual, "error in exercise7");
	}

	@Test
	public void test18() {
		List L7 = new List(-8, new List(-10, new List()));
		List L8 = new List(500, new List(200, new List()));
		List expected = new List(500, new List(200, new List(-8, new List(-10, new List()))));
		List actual = Worksheet1.merge(L7, L8);
		assertEquals(expected, actual, "error in exercise7");
	}

	// test for exercise8
	@Test
	public void test19() {
		List expected = new List(9, new List(8, new List(7, new List(6, new List()))));
		List actual = Worksheet1.removeDuplicates(L1);
		assertEquals(expected, actual, "error in exercise8");
	}

	@Test
	public void test20() {
		List L9 = new List(9, new List(8, new List(8, new List(6, new List()))));
		List expected = new List(9, new List(8, new List(6, new List())));
		List actual = Worksheet1.removeDuplicates(L9);
		assertEquals(expected, actual, "error in exercise8");
	}

}
