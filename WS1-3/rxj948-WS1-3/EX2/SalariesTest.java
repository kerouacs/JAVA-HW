import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ruopeng Jiang
 * @version 2019-10-28
 */

public class SalariesTest {
	public static final double TOLERANCE = 0.0000000001;
	private Salaries salaries;

	@BeforeEach
	public void init() {
		salaries = new Salaries();
		double[] alyssaSalary = { 3400, 1377, 4567, 2435, 5325, 0, 0, 0, 0, 0, 0, 0 };
		double[] marySalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 2000, 1000, 1000 };
		double[] tomSalary = { 0, 10000, 0, 20000, 0, 0, 40000, 0, 10000, 0, 0, 0 };
		double[] leoSalary = { 0, 2500, 2500, 0, 2000, 1000, 0, 0, 0, 0, 0 };
		salaries.add(alyssaSalary);
		salaries.add(marySalary);
		salaries.add(tomSalary);
		salaries.add(leoSalary);
	}
	// ----------------Testing average----------------------------------------------
	@Test
	public void test1() {
		double[] AlyssaSalary = { 3400, 1377, 4567, 2435, 5325, 0, 0, 0, 0, 0, 0, 0 };
		double expectedAverage = 3420.8;
		double actualAverage = Salaries.average(AlyssaSalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test2() {
		double[] marySalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 2000, 1000, 1000 };
		double expectedAverage = 1333.3333333333;
		double actualAverage = Salaries.average(marySalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test3() {
		double[] tomSalary = { 0, 10000, 0, 20000, 0, 0, 40000, 0, 10000, 0, 0, 0 };
		double expectedAverage = 20000;
		double actualAverage = Salaries.average(tomSalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test4() {
		double[] leoSalary = { 0, 2500, 2500, 0, 2000, 1000, 0, 0, 0, 0, 0 };
		double expectedAverage = 2000.;
		double actualAverage = Salaries.average(leoSalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test5() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		assertThrows(IllegalArgumentException.class, () -> {
			Salaries.average(noSalary);
		});
	}
	// ----------------Testing averageSalaries----------------------------------------------
	@Test
	public void test6() {

		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(3420.8);
		expectedAverageSalaries.add(1333.3333333333);
		expectedAverageSalaries.add(20000.);
		expectedAverageSalaries.add(2000.);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);
		}
	}

	@Test
	public void test7() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(3420.8);
		expectedAverageSalaries.add(1333.3333333333);
		expectedAverageSalaries.add(20000.);
		expectedAverageSalaries.add(2000.);
		expectedAverageSalaries.add(0.);
		salaries.add(noSalary);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);

		}
	}

	@Test
	public void test8() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] lucasSalary = { 0, 0, 0, 0, 0, 1874, 0, 0, 0, 0, 0, 0 };
		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(3420.8);
		expectedAverageSalaries.add(1333.3333333333);
		expectedAverageSalaries.add(20000.);
		expectedAverageSalaries.add(2000.);
		expectedAverageSalaries.add(1874.);

		salaries.add(noSalary);
		salaries.add(lucasSalary);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);

		}
	}
	// ----------------Testing not3TimesHigher----------------------------------------------
	@Test
	public void test9() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] lucasSalary = { 0, 0, 0, 0, 0, 1874, 0, 0, 0, 0, 0, 0 };
		salaries.add(noSalary);
		salaries.add(lucasSalary);
		assertFalse(salaries.not3TimesHigher());
	}

	@Test
	public void test10() {
		double[] jolinSalary = { 10000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		salaries.add(jolinSalary);
		assertFalse(salaries.not3TimesHigher());
	}

	@Test
	public void test11() {
		double[] bobSalary = { 1022, 2000, 3000, 4000, 0, 0, 0, 0, 0, 0, 0, 0 };
		salaries.add(bobSalary);
		assertFalse(salaries.not3TimesHigher());
	}

	@Test
	public void test12() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Salaries salaries2 = new Salaries();
		salaries2.add(noSalary);
		assertTrue(salaries2.not3TimesHigher());
	}
	
	@Test
	public void test13() {
		double[] TomasSalary = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Salaries salaries2 = new Salaries();
		salaries2.add(TomasSalary);
		assertTrue(salaries2.not3TimesHigher());
	}
}
