import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/** 
 *  8 tests for the Good class.
 * @author Ruopeng Jiang
 * @version 2019-10-17
 */
public class GoodTest {

	private Good milk;
	private Good meat;
	public final static double TOLERANCE = 0.00001;
	//  public Good(String name, double netprice, final static double VAT_RATE=20)
	@BeforeEach
	public void beforeEach() {
		milk = new Good("Milk", 0.50);
		meat = new Good("Meat", 3.00);
	}
	// testing getters of getName
	@Test
	public void testGetName() {
		String expected = "Milk";
		String actual = milk.getName();
		assertEquals(expected, actual, "error in getName");
	}
	// testing getters of getNetPrice
	@Test
	public void netNetPrice() {
		double expected = 0.50;
		double actual = milk.getNetPrice();
		assertEquals(expected, actual, "error in getPrice");
	}
	//testing getName,getNetPrice and VATRate of milk
	@Test
	public void testGetters1() {
		String expectedName = "Milk";
		double expectedNetPrice = 0.5;
		double expectedVATRate = 20;

		String actualName = milk.getName();
		double actualNetPrice = milk.getNetPrice();
		double actualVATRate = Good.VAT_RATE;
		assertTrue(expectedName.equals(actualName));
		assertTrue(expectedNetPrice==(actualNetPrice));
		assertTrue(expectedVATRate==(actualVATRate));
	} 
	//testing getName,getNetPrice and VATRate of meat
	@Test
	public void testGetters2() {
		String expectedName = "Meat";
		double expectedNetPrice = 1.15;
		double expectedVATRate = 20;

		String actualName = meat.getName();
		double actualNetPrice = meat.getNetPrice();
		double actualVATRate = Good.VAT_RATE;
		assertTrue(expectedName.equals(actualName));
		assertTrue(expectedNetPrice!=(actualNetPrice));
		assertTrue(expectedVATRate==(actualVATRate));
	} 
	// testing grossPrice method of milk
	@Test
	public void testGrossPriceMilk() {
		double expectedGrossPrice = 0.6;
		double actualGrossPrice = milk.grossPrice();

		assertEquals(expectedGrossPrice, actualGrossPrice, TOLERANCE,
		"error in GrossPriceMilk");
		}
	// testing grossPrice method of meat
	@Test
	public void testGrossPriceMeat() {
		double expectedGrossPrice = 3.60;
		double actualGrossPrice = meat.grossPrice();

		assertEquals(expectedGrossPrice, actualGrossPrice, TOLERANCE,
		"error in GrossPriceMeat");
		}
	// testing the discount Milk method  (via the toString())
	@Test
	public void testDiscountMilk() {
		milk.discount(20);
		String expectedString = "The Milk has a gross price of \u00A30.48.";
		String actualString = milk.toString();
		assertEquals(expectedString, actualString,
				"error in testDiscountMilk");
	}
	// testing the discount Meat method  (via the toString())
	@Test
	public void testDiscountMeat() {
		meat.discount(20);
		String expectedString = "The Meat has a gross price of \u00A32.88.";
		String actualString = meat.toString();
		assertEquals(expectedString, actualString,
				"error in testDiscountMeat");
	}
}