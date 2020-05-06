
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  I wanted to mention earlier that 
 *  I was confused because this was the first time I had used JUNIT tests.
 *  Therefore, I referred to some of the teachers' tests.
 *  But through learning and changing the teacher's tests, 
 *  I have basically mastered the assert method.
 *  
 *  
 *  
 *  
 *  
 *  32 tests for the Car class.
 *  @author RUOPENG JIANG
 *  @version 2019-10-16
 */
class CarTest{
	private Car A;
	private Car B;
	private Car C;
	private Car D;

    //public Car(String make, int price, int maxSpeed, String colour)
	@BeforeEach
	public void beforeEach() {
            A = new Car("Ford", 20000, 150, "blue");
            B = new Car("General Motors", 15000, 160, "black");
            C = new Car("Jaguar", 0, -5, "white");
            D = new Car("Bentley", -10, 0, "");
	}
    //testing some boundary conditions above.
	// testing getter for make
	@Test
	public void testMake1() {
		String expected = "Ford";
		String actual = A.getMake();
		assertEquals(expected, actual, "error in getMake");
	}
	@Test
	public void testMake2() {
		String expected = "General Motors";
		String actual = B.getMake();
		assertEquals(expected, actual, "error in getMake");
	}
	@Test
	public void testMake3() {
		String expected = "Jaguar";
		String actual = C.getMake();
		assertEquals(expected, actual, "error in getMake");
	}
	@Test
	public void testMake4() {
		String expected = "Bentley";
		String actual = D.getMake();
		assertEquals(expected, actual, "error in getMake");
	}
	// testing getter for price
	@Test
	public void testPrice1() {
		int expected = 20000;
		int actual = A.getPrice();
		assertEquals(expected, actual, "error in getPrice");
	}
	@Test
	public void testPrice2() {
		int expected = 15000;
		int actual = B.getPrice();
		assertEquals(expected, actual, "error in getPrice");
	}
	@Test
	public void testPrice3() {
		int expected = 0;
		int actual = C.getPrice();
		assertEquals(expected, actual, "error in getPrice");
	}
	@Test
	public void testPrice4() {
		int expected = -10;
		int actual = D.getPrice();
		assertEquals(expected, actual, "error in getPrice");
	}
	// testing getter for maxSpeed
	@Test
	public void testmaxSpeed1() {
		int expected = 150;
		int actual = A.getMaxSpeed();
		assertEquals(expected, actual, "error in getMaxSpeed");
	}
	@Test
	public void testmaxSpeed2() {
		int expected = 160;
		int actual = B.getMaxSpeed();
		assertEquals(expected, actual, "error in getMaxSpeed");
	}
	@Test
	public void testmaxSpeed3() {
		int expected = -5;
		int actual = C.getMaxSpeed();
		assertEquals(expected, actual, "error in getMaxSpeed");
	}
	@Test
	public void testmaxSpeed4() {
		int expected = 0;
		int actual = D.getMaxSpeed();
		assertEquals(expected, actual, "error in getMaxSpeed");
	}
	// testing getter for colour
	@Test
	public void testColour1() {
		String expected = "blue";
		String actual = A.getColour();
		assertEquals(expected, actual, "error in getColour");
	}
	@Test
	public void testColour2() {
		String expected = "black";
		String actual = B.getColour();
		assertEquals(expected, actual, "error in getColour");
	}
	@Test
	public void testColour3() {
		String expected = "white";
		String actual = C.getColour();
		assertEquals(expected, actual, "error in getColour");
	}
	@Test
	public void testColour4() {
		String expected = "";
		String actual = D.getColour();
		assertEquals(expected, actual, "error in getColour");
	}
	// testing setter for make
	@Test
	public void testSetMake1() {
		A.setMake("Ford");
		String expected = "Ford";
		String actual = A.getMake();
		assertEquals(expected, actual, "error in setMake");
	}
	@Test
	public void testSetMake2() {
		B.setMake("General Motors");
		String expected = "General Motors";
		String actual = B.getMake();
		assertEquals(expected, actual, "error in setMake");
	}
	@Test
	public void testSetMake3() {
		C.setMake("Jaguar");
		String expected = "Jaguar";
		String actual = C.getMake();
		assertEquals(expected, actual, "error in setMake");
	}
	@Test
	public void testSetMake4() {
		D.setMake("Bentley");
		String expected = "Bentley";
		String actual = D.getMake();
		assertEquals(expected, actual, "error in setMake");
	}
	// testing setter for price
	@Test
	public void testSetPrice1() {
		A.setPrice(20000);
		int expected = 20000;
		int actual = A.getPrice();
		assertEquals(expected, actual, "error in setPrice");
	}
	@Test
	public void testSetPrice2() {
		B.setPrice(15000);
		int expected = 15000;
		int actual = B.getPrice();
		assertEquals(expected, actual, "error in setPrice");
	}
	@Test
	public void testSetPrice3() {
		C.setPrice(0);
		int expected = 0;
		int actual = C.getPrice();
		assertEquals(expected, actual, "error in setPrice");
	}
	@Test
	public void testSetPrice4() {
		D.setPrice(-10);
		int expected = -10;
		int actual = D.getPrice();
		assertEquals(expected, actual, "error in setPrice");
	}
    // testing setter for maxSpeed
	@Test
	public void testSetMaxSpeed1() {
		A.setMaxSpeed(150);
		int expected = 150;
		int actual = A.getMaxSpeed();
		assertEquals(expected, actual, "error in setMaxSpeed");
	}
	@Test
	public void testSetMaxSpeed2() {
		B.setMaxSpeed(160);
		int expected = 160;
		int actual = B.getMaxSpeed();
		assertEquals(expected, actual, "error in setMaxSpeed");
	}
	@Test
	public void testSetMaxSpeed3() {
		C.setMaxSpeed(-5);
		int expected = -5;
		int actual = C.getMaxSpeed();
		assertEquals(expected, actual, "error in setMaxSpeed");
	}
	@Test
	public void testSetMaxSpeed4() {
		D.setMaxSpeed(0);
		int expected = 0;
		int actual = D.getMaxSpeed();
		assertEquals(expected, actual, "error in setMaxSpeed");
	}
	// testing setter for setColour
	@Test
	public void testSetColour1() {
		A.setColour("blue");
		String expected = "blue";
		String actual = A.getColour();
		assertEquals(expected, actual, "error in setColour");
	}
	@Test
	public void testSetColour2() {
		B.setColour("black");
		String expected = "black";
		String actual = B.getColour();
		assertEquals(expected, actual, "error in setColour");
	}
	@Test
	public void testSetColour3() {
		C.setColour("white");
		String expected = "white";
		String actual = C.getColour();
		assertEquals(expected, actual, "error in setColour");
	}
	@Test
	public void testSetColour4() {
		D.setColour("");
		String expected = "";
		String actual = D.getColour();
		assertEquals(expected, actual, "error in setColour");
	}
}
