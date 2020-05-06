import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 17 tests for the Account ,AccountStandard,AccountAdministrator and MusicTitle classes
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class AccountTest {

  private MusicTitle musicTitle_a, musicTitle_b, musicTitle_c;
  private AccountStandard customerTom;
  private AccountAdministrator root;

  @BeforeEach
  public void init() {
    musicTitle_a = new MusicTitle("", "", 22);
    musicTitle_b = new MusicTitle("Brave", "Cor korean", 2514);
    musicTitle_c = new MusicTitle("Jay new ablum", "Kwda Fwe", 10);

    ArrayList<MusicTitleInterface> testList = new ArrayList<>();
    testList.add(musicTitle_a);
    testList.add(musicTitle_b);
    testList.add(musicTitle_a);

    Account testCustomer = new AccountStandard("John", "Mr", "john@john.org", "Fwe");

    customerTom = new AccountStandard("John", "Mr", "john@john.org", "Fwe");
    root = new AccountAdministrator("Mary", "Mrs", "root@admin.net", "rootpassword");
  }

  // testing musicTitle_a's getTitle()
  @Test
  public void test1() {
    String expectedTitle = "";
    String actualTitle = musicTitle_a.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + actualTitle);
  }

  // testing musicTitle_a's getArtist()
  @Test
  public void test2() {
    String expectedArtist = "";
    String actualArtist = musicTitle_a.getArtist();
    assertEquals(expectedArtist, actualArtist, "artist should be: " + actualArtist);
  }

  // testing musicTitle_a's getPrice()
  @Test
  public void test3() {
    int expectedPrice = 22;
    int actualPrice = musicTitle_a.getPrice();
    assertEquals(expectedPrice, actualPrice, "artist should be: " + actualPrice);
  }

  // testing customerTom's getName()
  @Test
  public void test4() {
    String expectedName = "John";
    String actualName = customerTom.getName();
    assertEquals(expectedName, actualName, "name should be: " + actualName);
  }

  // testing customerTom's getSalutation()
  @Test
  public void test5() {
    String expectedSalutation = "Mr";
    String actualSalutation = customerTom.getSalutation();
    assertEquals(expectedSalutation, actualSalutation, "salutation should be: " + actualSalutation);
  }

  // testing customerTom's getEmail()
  @Test
  public void test6() {
    String expectedEmail = "john@john.org";
    String actualEmail = customerTom.getEmail();
    assertEquals(expectedEmail, actualEmail, "email should be: " + actualEmail);
  }

  // testing customerTom's getBalance()
  @Test
  public void test7() {
    int expectedBalance = 0;
    int actualBalance = customerTom.getBalance();
    assertEquals(expectedBalance, actualBalance, "balance should be: " + actualBalance);
  }

  // testing customerTom's getTitlesBought()
  @Test
  public void test8() {
    ArrayList<MusicTitle> expectedPurchaseList = new ArrayList<>();
    ArrayList<MusicTitle> actualPurchaseList = customerTom.getTitlesBought();
    for (int i = 0; i < actualPurchaseList.size(); i++) {
      assertEquals(expectedPurchaseList.get(i), actualPurchaseList.get(i));
    }
  }

  // testing customerTom's getFailedLoginAttempts()
  @Test
  public void test9() {
    int expectedFailedLoginAttempts = 0;
    int actualFailedLoginAttempts = 0;
    assertEquals(expectedFailedLoginAttempts, actualFailedLoginAttempts,
        "failed login attempts should be: " + actualFailedLoginAttempts);
  }

  // testing MAXIMAL_LOGIN_ATTEMPTS
  @Test
  public void test10() {
    int expectedMaximalLoginAttempts = 3;
    int actualMaximalLoginAttempts = AccountStandard.MAXIMAL_LOGIN_ATTEMPTS;
    assertEquals(expectedMaximalLoginAttempts, actualMaximalLoginAttempts,
        "failed login attempts should be: " + actualMaximalLoginAttempts);
  }

  // customerTom logs in successfully and tries to make a purchase, which
  // fails due to insufficient funds
  @Test
  public void test11() {
    customerTom.login("Fwe");
    assertTrue(customerTom.getLoggedIn());

    customerTom.buy(musicTitle_a);
    ArrayList<MusicTitle> actualPurchaseList = customerTom.getTitlesBought();
    assertTrue(actualPurchaseList.isEmpty());
  }

  // customerTom logs in unsuccessfully
  @Test
  public void test12() {
    customerTom.login("Fwe");
    assertTrue(customerTom.getLoggedIn());

    assertEquals(0, customerTom.getFailedLoginAttempts());

    customerTom.buy(musicTitle_a);
    ArrayList<MusicTitle> actualPurchaseList = customerTom.getTitlesBought();
    assertTrue(actualPurchaseList.isEmpty());
  }

  // customerTom tries to log in twice unsuccessfully
  @Test
  public void test13() {
    customerTom.login("Fwe");
    assertTrue(customerTom.getLoggedIn());

    assertEquals(0, customerTom.getFailedLoginAttempts());

    customerTom.login("Fwed");
    assertTrue(customerTom.getLoggedIn());

    assertEquals(1, customerTom.getFailedLoginAttempts());

    customerTom.buy(musicTitle_a);
    ArrayList<MusicTitle> actualPurchaseList = customerTom.getTitlesBought();
    assertTrue(actualPurchaseList.isEmpty());
  }

  // customerTom completes a purchase successfully
  @Test
  public void test14() {
    customerTom.login("Fwed");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(1, customerTom.getFailedLoginAttempts());

    customerTom.login("Fwe");
    assertTrue(customerTom.getLoggedIn());

    assertEquals(0, customerTom.getFailedLoginAttempts());

    customerTom.login("Fwe");
    assertTrue(customerTom.getLoggedIn());

    assertEquals(0, customerTom.getFailedLoginAttempts());

    customerTom.deposit(20);
    customerTom.buy(musicTitle_a);

    String expectedMusicTitle = "";
    String actualMusicTitle = customerTom.getTitlesBought().get(0).getTitle();
    assertEquals(expectedMusicTitle, actualMusicTitle);

    String expectedArtist = "";
    String actualArtist = customerTom.getTitlesBought().get(0).getArtist();
    assertEquals(expectedArtist, actualArtist);

    int expectedPrice = 22;
    int actualPrice = customerTom.getTitlesBought().get(0).getPrice();
    assertEquals(expectedPrice, actualPrice);

    int expectedBalance = -2;
    int actualBalance = customerTom.getBalance();
    assertEquals(expectedBalance, actualBalance);

    customerTom.logout();
    assertFalse(customerTom.getLoggedIn());

    customerTom.deposit(20);
    expectedBalance = 18;
    actualBalance = customerTom.getBalance();
    assertEquals(expectedBalance, actualBalance);

    customerTom.buy(musicTitle_b);
    int expectedPurchaseListSize = 1; // still 1
    int actualPurchaseListSize = customerTom.getTitlesBought().size();

    assertEquals(expectedPurchaseListSize, actualPurchaseListSize);
  }

  // customerTom enters wrong password three times, admin tries to reset the
  // password without logging in
  @Test
  public void test15() {
    customerTom.login("Fwed");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(1, customerTom.getFailedLoginAttempts());

    customerTom.login("cOrrn");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(2, customerTom.getFailedLoginAttempts());

    customerTom.login("c0rn");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(3, customerTom.getFailedLoginAttempts());

    root.resetAccount(customerTom, "seed");
    String expectedPassword = "Fwe";
    assertTrue(customerTom.checkPassword(expectedPassword));

    int expectedFailedLoginAttempts = 3;
    int actualFailLoginAttempts = customerTom.getFailedLoginAttempts();
    assertEquals(expectedFailedLoginAttempts, actualFailLoginAttempts);
  }

  // customerTom enters wrong password three times, root manages to log in successfully, and
  // resets customer John' account successfully.
  @Test
  public void test16() {
    customerTom.login("Fwed");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(1, customerTom.getFailedLoginAttempts());

    customerTom.login("cOrrn");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(2, customerTom.getFailedLoginAttempts());

    customerTom.login("c0rn");
    assertFalse(customerTom.getLoggedIn());

    assertEquals(3, customerTom.getFailedLoginAttempts());

    root.login("rootpasssword");
    assertFalse(root.getLoggedIn());

    root.login("rootpassword");
    assertTrue(root.getLoggedIn());

    root.addAccount(customerTom);
    String expectedAccountName = "John";
    String actualAccountName = root.getAccounts().get(0).getName();
    assertEquals(expectedAccountName, actualAccountName);
    assertTrue(!root.getAccounts().isEmpty());

    root.resetAccount(customerTom, "seed");
    System.out.println(root);
    String expectedPassword = "seed";
    assertTrue(customerTom.checkPassword(expectedPassword));

    int expectedFailedLoginAttempts = 0;
    int actualFailLoginAttempts = customerTom.getFailedLoginAttempts();
    assertEquals(expectedFailedLoginAttempts, actualFailLoginAttempts);

    customerTom.login("seed");
    //assertTrue(customerTom.getLoggedIn());

    customerTom.deposit(100);
    customerTom.buy(musicTitle_a);
    customerTom.buy(musicTitle_b);
    customerTom.buy(musicTitle_c);

    int expectedPurchaseListSize = 2;
    int actualPurchaseListSize = customerTom.getTitlesBought().size();
    assertEquals(expectedPurchaseListSize, actualPurchaseListSize);

 
    String expectedArtist = "Kwda Fwe";
    int expectedPrice = 1;




    int expectedBalance = -2436;
    int actualBalance = customerTom.getBalance();
    assertEquals(expectedBalance, actualBalance);
  }

  // root resets deputy's account successfully
  @Test
  public void test17() {
    Account deputy = new AccountAdministrator("Tim", "Mr", "tim@sysadmin.org", "dep11");
    deputy.login("ddep11");
    assertFalse(deputy.getLoggedIn());

    deputy.login("deep11");
    assertFalse(deputy.getLoggedIn());

    deputy.login("dep111");
    assertFalse(deputy.getLoggedIn());

    root.login("rootpassword");
    assertTrue(root.getLoggedIn());

    root.addAccount(deputy);
    root.resetAccount(deputy, "dep115");

    String expectedPassword = "dep115";
    String actualPassword = root.getAccounts().get(0).getPassword();
    assertEquals(expectedPassword, actualPassword);

    assertFalse(deputy.getLoggedIn());
    deputy.login("dep115");
    assertFalse(!deputy.getLoggedIn());

    deputy.changePassword("dep115", "dep1242");
    deputy.logout();
    assertFalse(deputy.getLoggedIn());

    deputy.login("dep1242");
    assertTrue(deputy.getLoggedIn());
  }


}
