import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 14 tests for the Subscription and SubscriptionPrime classes
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class SubscriptionTest {

  private SubscriptionInterface sub_a;
  private SubscriptionPrime subPrime_a;
  private Subscription sub_b;
  private SubscriptionPrime subPrime_b;
  @BeforeEach
  public void init() {
    sub_a = new Subscription("NBA", "AILIN@AILIN.org", 4);
    subPrime_a = new SubscriptionPrime("Daily News", "KOBE@KOBE.org", 5, "CHINA TOWN London");
    sub_b = new SubscriptionPrime("Yummy", "poppy@poppy.org", 3, "oxbridge street 1999");
    subPrime_b = new SubscriptionPrime("", "", 5, "");
  }

  // testing sub_a's getTitle()
  @Test
  public void test1() {
    String expectedTitle = "NBA";
    String actualTitle = sub_a.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + actualTitle);
  }

  // testing sub_a's getEmail()
  @Test
  public void test2() {
    String expectedEmail = "AILIN@AILIN.org";
    String actualEmail = sub_a.getEmail();
    assertEquals(expectedEmail, actualEmail, "email should be: " + actualEmail);
  }

  // testing sub_a's getCost()
  @Test
  public void test3() {
    int expectedCost = 4;
    int actualCost = sub_a.getCost();
    assertEquals(expectedCost, actualCost, "cost should be: " + actualCost);
  }

  // testing subPrime_a's getTitle()
  @Test
  public void test4() {
    String expectedTitle = "Daily News";
    String actualTitle = subPrime_a.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + actualTitle);
  }

  // testing subPrime_a's getEmail()
  @Test
  public void test5() {
    String expectedEmail = "KOBE@KOBE.org";
    String actualEmail = subPrime_a.getEmail();
    assertEquals(expectedEmail, actualEmail, "mail should be: " + actualEmail);

  }

  // testing subPrime_a's getCost()
  @Test
  public void test6() {
    int expectedCost = 5;
    int actualCost = subPrime_a.getCost();
    assertEquals(expectedCost, actualCost, "cost should be: " + actualCost);
  }

  // testing subPrime_a's getAddress()
  @Test
  public void test7() {
    String expectedDeliveryAddress = "CHINA TOWN London";
    String actualDeliveryAddress = subPrime_a.getAddress();
    assertEquals(expectedDeliveryAddress, actualDeliveryAddress,
        "address should be: " + actualDeliveryAddress);
  }

  // testing getAddress()
  @Test
  public void test8() {
    SubscriptionPrimeInterface subPrime2 =
        new SubscriptionPrime("Daily News", "KOBE@KOBE.org", 3, "New Street 5005");
    String expectedAddress = "New Street 5005";
    String actualAddress = subPrime2.getAddress();
    assertEquals(expectedAddress, actualAddress, "address should be: " + actualAddress);
  }

  // testing sub_b's getTitle
  @Test
  public void test9() {
    String expectedTitle = "Yummy";
    String actualTitle = sub_b.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + actualTitle);
  }

  // testing sub_b's getEmail()
  @Test
  public void test10() {
    String expectedEmail = "poppy@poppy.org";
    String actualEmail = sub_b.getEmail();
    assertEquals(expectedEmail, actualEmail, "email should be: " + actualEmail);
  }

  // testing sub_b's getCost()
  @Test
  public void test11() {
    int expectedCost = 3;
    int actualCost = sub_b.getCost();
    assertEquals(expectedCost, actualCost, "cost should be: " + actualCost);
  }
  // testing subPrime_a's getAddress()
  @Test
  public void test12() {
    String expectedDeliveryAddress = "";
    String actualDeliveryAddress = subPrime_b.getAddress();
    assertEquals(expectedDeliveryAddress, actualDeliveryAddress,
        "address should be: " + actualDeliveryAddress);
  }
  // testing subPrime_b's getTtile()
  @Test
  public void test13() {
    String expectedTitle = "";
    String actualTitle = subPrime_b.getAddress();
    assertEquals(expectedTitle, actualTitle,
        "title should be: " + actualTitle);
  }
  // testing subPrime_b's getEmail()
  @Test
  public void test14() {
    String expectedEmail = "";
    String actualEmail = subPrime_b.getEmail();
    assertEquals(expectedEmail, actualEmail, "mail should be: " + actualEmail);
  }
}
