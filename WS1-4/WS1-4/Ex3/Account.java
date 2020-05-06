/**
 * In the following I define the Account class and implements AccountInterface.
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public abstract class Account implements AccountInterface {
    private String name;
    private String salutation;
    private String email;
    private String password;
    private boolean loggedIn;	
    // loggedIn is to check the state of log in. 
    /**
     * This constructor contains four parts:
     * name, salutation ,email and password which are,a string,a string, ,a string and a string.
     * @param name The name of the Account.eg, Jiang is one of a name.
     * @param salutation The salutation of the Account.eg,Dr is one of a salutation.
     * @param email The email of the Account.eg,325235@163.com is one of a email.
     * @param password The password of the Account.eg,32563Afw is one of a password.
     */
    public Account(String name, String salutation, String email, String password) {
        this.name = name;
        this.salutation = salutation;
        this.email = email;
        this.password = password;
        //this.loggedIn = loggedIn,Set following.
    }
    /**
    * Getter for the name of the account.
    * @return The name of the account.eg, Jiang is one of a name.
    */
   @Override
   public String getName() {
       return this.name;
   }
    /**
    * Getter for the Salutation of the account.
    * @return The Salutation of the account.eg,Dr is one of a salutation.
    */
   @Override
   public String getSalutation() {
       return this.salutation;
   }
   /**
   * Getter for the Email of the account.
   * @return The Email of the account.eg,325235@163.com is one of a salutation.
   */
   @Override
   public String getEmail() {
       return this.email;
   }
   /**
    *  Setter for the password.
    *  @param password The new password.
    */
   @Override
   public void setPassword(String password) {
       this.password = password;
   }
   /**
    * Getter method to return the password.
    * @return The password of the account.
    */
   @Override
   public String getPassword() {
       return this.password;
   }
    /**
     *
     * This method is to check the password 
     * user have entered is right or not compared to the stored one.
     * If it is right,the loggedin will get true ,otherwise will throw a exception.
     * @param password The password of the Account.
     */
    @Override
    public void login(String password) {
        if (this.password == password) {
            loggedIn = true;
        } else
        throw new IllegalArgumentException("The password  you enter is wrong");
    }
    /**
     * Setter for the LoggedIn. 
     * Sets the loggedIn of a account 
     * @param loggedIn The state of loggedIn of the Account
     */
   @Override
   public void setLoggedIn(boolean loggedIn) {
       this.loggedIn = loggedIn;
   }
    /**
     *  Getter for the LoggedIn of the Account.
     *  @return The state of login of the Account.
     *
     */
    @Override
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    /**
     *  This method is to check the state of logout for the account
     *  The user is log out, the loggedIn variable will get false.
     */
    @Override
    public void logout() {
        this.loggedIn = false;
    }
    /**
     * This method is to check the password for the account
     * @param password The password of the Account.eg,32563Afw is one of a password.
     * @return true if the password of the account is right, false else.
     */
    @Override
    public boolean checkPassword(String password) {
        return this.password == password;
    }
    /**
     * This method is to change the password from old to new if the old password 
     * If the old one is wrong, an error message is printed.
     * @param oldPassword The old password.
     * @param newPassword The new password.
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            this.password = newPassword;
        }
    }
    /**
    *
	* @return the print format of a account.
    */
    @Override
    public String toString() {
        return "This account " +"name: " + name +", salutation: " + salutation +", email: " + email +
                ", password: " + password +", loggedIn: " + loggedIn +".";
    }
}