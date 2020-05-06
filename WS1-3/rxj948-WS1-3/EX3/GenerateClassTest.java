import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenerateClassTest {
    private GenerateClass goodOneClass, goodTwoClass, goodThreeClass, goodFourClass;
    @BeforeEach
    public void init() {
		String classgood1 = "Good1";
		String[] variablegoods1 = { "good", "releaseDate" };
		String[] variableTypes1 = { "String", "Date" };
		goodOneClass = new GenerateClass(classgood1, variablegoods1, variableTypes1);

		String classgood2 = "Good2";
		String[] variablegoods2 = { "good", "releaseDate", "price" };
		String[] variableTypes2 = { "String", "Date", "double" };
		goodTwoClass = new GenerateClass(classgood2, variablegoods2, variableTypes2);

		String classgood3 = "Good3";
		String[] variablegoods3 = { "good" };
		String[] variableTypes3 = { "String" };

		goodThreeClass = new GenerateClass(classgood3, variablegoods3, variableTypes3);

		String classgood4 = "Good4";
		String[] variablegoods4 = {};
		String[] variableTypes4 = {};

		goodFourClass = new GenerateClass(classgood4, variablegoods4, variableTypes4);

	}

	// ----------------Testing GoodOneClass----------------------------------------------
	@Test
	public void test1() {
		String expectedFields = "  private String good;\n" + "  private Date releaseDate;\n\n";
		String actualFields = goodOneClass.makeFields();
		assertEquals(expectedFields, actualFields);
	}

	@Test
	public void test2() {
		String expectedConstructor = "  public Good1(String good, Date releaseDate){\n" + "    this.good = good;\n"
				+ "    this.releaseDate = releaseDate;\n" + "  }\n";
		String actualConstructor = goodOneClass.makeConstructor();
		assertEquals(expectedConstructor, actualConstructor);
	}

	@Test
	public void test3() {
		String expectedGetters = "  public String getGood(){\n" + "    return good;\n" + "  }\n"
				+ "  public Date getReleaseDate(){\n" + "    return releaseDate;\n" + "  }\n";
		String actualGetters = goodOneClass.makeGetters();
		assertEquals(expectedGetters, actualGetters);
	}

	@Test
	public void test4() {
		String expectedSetters = "  public void setGood(String good){\n" + "    this.good = good;\n" + "  }\n"
				+ "  public void setReleaseDate(Date releaseDate){\n" + "    this.releaseDate = releaseDate;\n" + "  }\n";
		String actualSetters = goodOneClass.makeSetters();
		assertEquals(expectedSetters, actualSetters);
	}

	// ----------------Testing GoodTwoClass----------------------------------------------

	@Test
	public void test5() {
		String expectedFields = "  private String good;\n" + "  private Date releaseDate;\n" + "  private double price;\n\n";
		String actualFields = goodTwoClass.makeFields();
		assertEquals(expectedFields, actualFields);
	}

	@Test
	public void test6() {
		String expectedConstructor = "  public Good2(String good, Date releaseDate, double price){\n"
				+ "    this.good = good;\n" + "    this.releaseDate = releaseDate;\n" + "    this.price = price;\n" + "  }\n";
		String actualConstructor = goodTwoClass.makeConstructor();
		assertEquals(expectedConstructor, actualConstructor);
	}

	@Test
	public void test7() {
		String expectedGetters = "  public String getGood(){\n" + "    return good;\n" + "  }\n"
				+ "  public Date getReleaseDate(){\n" + "    return releaseDate;\n" + "  }\n" + "  public double getPrice(){\n"
				+ "    return price;\n" + "  }\n";
		String actualGetters = goodTwoClass.makeGetters();
		assertEquals(expectedGetters, actualGetters);
	}

	@Test
	public void test8() {
		String expectedSetters = "  public void setGood(String good){\n" + "    this.good = good;\n" + "  }\n"
				+ "  public void setReleaseDate(Date releaseDate){\n" + "    this.releaseDate = releaseDate;\n" + "  }\n"
				+ "  public void setPrice(double price){\n" + "    this.price = price;\n" + "  }\n";
		String actualSetters = goodTwoClass.makeSetters();
		assertEquals(expectedSetters, actualSetters);
	}

	// ----------------Testing GoodThreeClass----------------------------------------------

	@Test
	public void test9() {
		String expectedFields = "  private String good;\n\n";
		String actualFields = goodThreeClass.makeFields();
		assertEquals(expectedFields, actualFields);
	}

	@Test
	public void test10() {
		String expectedConstructor = "  public Good3(String good){\n" + "    this.good = good;\n" + "  }\n";
		String actualConstructor = goodThreeClass.makeConstructor();
		assertEquals(expectedConstructor, actualConstructor);
	}

	@Test
	public void test11() {
		String expectedGetters = "  public String getGood(){\n" + "    return good;\n" + "  }\n";
		String actualGetters = goodThreeClass.makeGetters();
		assertEquals(expectedGetters, actualGetters);
	}

	@Test
	public void test12() {
		String expectedSetters = "  public void setGood(String good){\n" + "    this.good = good;\n" + "  }\n";
		String actualSetters = goodThreeClass.makeSetters();
		assertEquals(expectedSetters, actualSetters);
	}

	// ----------------Testing GoodFourClass----------------------------------------------

	@Test
	public void test13() {
		String expectedFields = "\n";
		String actualFields = goodFourClass.makeFields();
		assertEquals(expectedFields, actualFields);
	}

	@Test
	public void test14() {
		String expectedConstructor = "  public Good4(){}\n";
		String actualConstructor = goodFourClass.makeConstructor();
		assertEquals(expectedConstructor, actualConstructor);
	}

	@Test
	public void test15() {
		String expectedGetters = "";
		String actualGetters = goodFourClass.makeGetters();
		assertEquals(expectedGetters, actualGetters);
	}

	@Test
	public void test16() {
		String expectedSetters = "";
		String actualSetters = goodFourClass.makeSetters();
		assertEquals(expectedSetters, actualSetters);
	}
	// ----------------Testing writeFile----------------------------------------------
	 @Test
	void writeFile() {
		 goodOneClass.writeFile();
	}
}
