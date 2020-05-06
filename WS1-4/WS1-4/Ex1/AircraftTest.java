import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 7 tests for the Aicraft and Aeroplane classes
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class AircraftTest {
  public static final double TOLERANCE = 0.0000000001;
  private Aircraft aircraft1, aircraft2;
  private Aeroplane aeroplane1, aeroplane2;

  @BeforeEach
  public void init() {

    aircraft1 = new Aircraft(50, 150);
    aeroplane1 = new Aeroplane(388, 900, 18);
    aircraft2 = new Aeroplane(888, 888, 18.8);
    aeroplane2 = new Aeroplane(444, 999, 22.0);
  }

  // testing getters of aircraft1
  @Test
  public void test1() {

    int expectedNumOfPassengers = 50;
    int actualNumOfPassengers = aircraft1.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    int expectedMaxSpeed = 150;
    int actualMaxSpeed = aircraft1.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }

  // testing getters of aeroplane1
  @Test
  public void test2() {

    int expectedNumOfPassengers = 388;
    int actualNumOfPassengers = aeroplane1.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    int expectedMaxSpeed = 900;
    int actualMaxSpeed = aeroplane1.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);

    double expectedFuelCons = 18;
    double actualFuelCons = aeroplane1.getFuelConsumption();
    assertEquals(expectedFuelCons, actualFuelCons, TOLERANCE);
  }

  // testing setters of aircraft1
  @Test
  public void test3() {

    aircraft1.setPassengerNumber(888);
    int expectedNumOfPassengers = 888;
    int actualNumOfPassengers = aircraft1.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    aircraft1.setMaxSpeed(888);
    int expectedMaxSpeed = 888;
    int actualMaxSpeed = aircraft1.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }
  @Test
  public void test4() {

	    int expectedNumOfPassengers = 444;
	    int actualNumOfPassengers = aeroplane2.getPassengerNumber();
	    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

	    int expectedMaxSpeed = 999;
	    int actualMaxSpeed = aeroplane2.getMaxSpeed();
	    assertEquals(expectedMaxSpeed, actualMaxSpeed);

	    double expectedFuelCons = 22.0;
	    double actualFuelCons = aeroplane2.getFuelConsumption();
	    assertEquals(expectedFuelCons, actualFuelCons, TOLERANCE);
	  }
  // testing setters of aeroplane
  @Test
  public void test5() {

    aeroplane1.setPassengerNumber(388);
    int expectedNumOfPassengers = 388;
    int actualNumOfPassengers = aeroplane1.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    aeroplane1.setMaxSpeed(900);
    int expectedMaxSpeed = 900;
    int actualMaxSpeed = aeroplane1.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);


    aeroplane1.setFuelConsumption(18);
    double expectedFuelCons = 18;
    double actualFuelCons = aeroplane1.getFuelConsumption();
    assertEquals(expectedFuelCons, actualFuelCons, TOLERANCE);
  }


  // testing getters of aircraft2
  @Test
  public void test6() {

    int expectedNumOfPassengers = 888;
    int actualNumOfPassengers = aircraft2.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    int expectedMaxSpeed = 888;
    int actualMaxSpeed = aircraft2.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }

  // testing setters of aircraft2
  @Test
  public void test7() {

    aircraft2.setPassengerNumber(888);
    int expectedNumOfPassengers = 888;
    int actualNumOfPassengers = aircraft2.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    aircraft2.setMaxSpeed(888);
    int expectedMaxSpeed = 888;
    int actualMaxSpeed = aircraft2.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }
}
