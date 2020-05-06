import java.util.ArrayList;

	/**
	*  In the following I define the AccountAdministrator class extends Account 
	*  and implements AccountAdministratorInterface with three methods.
	*  AccountAdministratorInterface has an additional field variable accounts of type ArrayList
	*  @author Ruopeng Jiang
	*  @version 2019-11-15
    */
public class AccountAdministrator extends Account implements AccountAdministratorInterface {
    private ArrayList<Account> accounts;

    /**
     *  
     * This constructor contains five parts:
     * name, salutation email and password which are,a string,a string, a string and a string.
     * @param name The name of the AccountAdministrator.
     * @param salutation The salutation of the AccountAdministrator.
     * @param email The email of the AccountAdministrator.
     * @param password The password of the AccountAdministrator.
     *
     */
    public AccountAdministrator(String name, String salutation, String email, String password) {
        super(name, salutation, email, password);
        //this.accounts = accounts,sets following.
    }

    /**
     * This method is to return the list of accounts.
     * @return The ArrayList of accounts .
     */
    @Override
    public ArrayList<Account> getAccounts() {
        if (this.accounts == null) {
            this.accounts = new ArrayList<>();
        }
        return this.accounts;
    }
    /**
     *  This method is to reset a Account and password.
     *  The administrator can reset new password and reset
     *  the number of failed login attempts to zero 
     *  Since the user failed to attempt passwords or want to set a new one.
     *  @param account The account that is to be reset.
     *  @param password The new password that is to be reset.
     */
    @Override
    public void resetAccount(Account account, String password) {
        if (this.getLoggedIn()) {
            if (account instanceof AccountStandard) {
                AccountStandard accountStandard = (AccountStandard) account;
                accountStandard.setPassword(password);
                accountStandard.setFailedLoginAttempts(0);
                addAccount(accountStandard);
            } else {
                account.setPassword(password);
                addAccount(account);
            }
        }
    }
    /**
     *  The method is to add an account to the list of accounts.
     *  @param account The new account to be added to the arraylist.
     */
    @Override
    public void addAccount(Account account) {
        if (this.accounts == null) {
            this.accounts = new ArrayList<>();
        }
        this.accounts.add(account);
    }
    /**
     * This method is to log in
     * It is checked whether the password provided is correct or not
     * If not will catch a exception.
     * @param password The password entered for the login.
     */
    public void login(String password) {
        try {
            super.login(password);
        } catch (IllegalArgumentException e) {
            System.out.println("your password is wrong");
        }
    }
    /**
	* @return the print format of a AccountAdministrator.
    */
    @Override
    public String toString() {
        return "This accountAdministrator has" +"accounts: " + accounts + super.toString() +".";
    }
}