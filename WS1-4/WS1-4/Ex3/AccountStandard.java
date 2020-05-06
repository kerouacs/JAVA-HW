import java.util.ArrayList;

/**
 * In the following I define the AccountStandard class extends Account and implements AccountStandardInterface
 * which has three additional field variables balance, titlesBought, failedLoginAttempts of types
 * an int, an ArrayList and and int.
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class AccountStandard extends Account implements AccountStandardInterface {
    public static final int MAXIMAL_LOGIN_ATTEMPTS = 3;
    private int balance;
    private ArrayList<MusicTitle> titlesBought = new ArrayList<>();
    private int failedLoginAttempts;

    /**
     * This constructor contains four parts:
     * name, salutation ,email and password which are,a string,a string, ,a string and a string.
     * @param name The name of the AccountStandard.
     * @param salutation The salutation of the AccountStandard.
     * @param email The email of the AccountStandard.
     * @param password The password of the AccountStandard.
     */
    public AccountStandard(String name, String salutation, String email, String password) {
        super(name, salutation, email, password);
      //this.balance = balance; set following
      //this.titlesBought = titlesBought;set following
      //this.failedLoginAttempts = failedLoginAttempts;set following
    }
    /**
     *  Setter for the balance.
     *  @param balance The balance of the account.
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }
    /**
     *  Setter for the failed login attempts.
     *  @param failedLoginAttempts The number of failed login attempts.
     */
    @Override
    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }
    /**
     * Getter for the balance.
     * @return Balance The balance of the AccountStandard.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }
    /**
     * Getter for the number of failed login attempts.
     * @return FailedLoginAttempts The number of failed login attempts.
     */
    @Override
    public int getFailedLoginAttempts() {
        return this.failedLoginAttempts;
    }
    /**
     *  This method is to log in to user account.
     *  If is first checked whether the account is still active 
     *  And after will check the password depend on the password is correct. 
     *  If a correct login the number of login, the attempts is reset to 0.
     *  Otherwise catch exception and increased by 1
     *  @param password The password provided for the login
     */
    @Override
    public void login(String password) {
        try {
            super.login(password);
            setFailedLoginAttempts(0);
        } catch (IllegalArgumentException e) {
            this.failedLoginAttempts = getFailedLoginAttempts() + 1;
        }
    }
    /**
     * Getter for the list of all titles user bought.
     * @return The list of titles user bought.
     */
    @Override
    public ArrayList<MusicTitle> getTitlesBought() {
        return this.titlesBought;
    }
    /**
     * Adds deposit by adding amount,the amount should be postive.
     * @param amount The amount has been deposited.
     */
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance = getBalance() + amount;
        }
    }

    /**
     *  If the user is logged in and has enough balance, 
     *  the user could buy a music title by subtracting the balance which
     *  is equal to music price.
     *  @param musicTitle The music title that the user wants to buy.
     */
    @Override
    public void buy(MusicTitle musicTitle) {
        if (super.getLoggedIn() && getBalance() > 0) {
            titlesBought.add(musicTitle);
            this.balance = getBalance() - musicTitle.getPrice();
        }
    }
     /**
	 * @return the print format of a AccountStandard.
     */
    @Override
    public String toString() {
        return "This accountStandard " +"balance: " + balance +", titlesBought: " + titlesBought +
                ", failedLoginAttempts: " + failedLoginAttempts +super.toString() +".";
    }
}