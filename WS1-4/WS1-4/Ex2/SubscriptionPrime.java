/**
 * In the following I define the SubscriptionPrime class 
 * Which is the subclass of the Subscription and it has an additional filed variable 
 * deliveryAddress of type String.
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class SubscriptionPrime extends Subscription implements SubscriptionPrimeInterface {
    private String address;
    /**
     * Subscription is a class contains three parts:
     * title, email and cost which are,a string,a String and an int.
     * @param title The title of the Subscription.eg, Times is one of a title
     * @param email The email of the Subscription.eg,32523523@qq.com is one of a emails
     * @param cost The cost of the Subscription.eg,$5 is one of a costs
     */
    
    /**
     * This constructor creates a SubscriptionPrime from the four parts:
	 * passengerNumber, maxSpeed and fuelConsumption which are,an int,an int and a double
     * @param title The tile of the SubscriptionPrime.
     * @param email The email of the SubscriptionPrime.
     * @param cost The cost of the SubscriptionPrime.
     * @param deliveryAddress The deliveryAddress of the SubscriptionPrime.
     */
    public SubscriptionPrime(String title, String email, int cost, String address) {
        super(title, email,cost);
        this.address = address;
    }
    /**
     * Getter for the Title of the SubscriptionPrime.
     * @return The Title of the SubscriptionPrime.
     */
    @Override
    public String getTitle() {
        return super.getTitle();
    }
    /**
     * Getter for the Email of the SubscriptionPrime.
     * @return The Email of the SubscriptionPrime.
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }
    /**
     * Getter for the Cost of the SubscriptionPrime.
     * @return The Cost of the SubscriptionPrime.
     */
    @Override
    public int getCost() {
        return super.getCost();
    }
    /**
     * Getter for the address of the SubscriptionPrime.
     * @return The address of the SubscriptionPrime.
     */
    @Override
    public String getAddress() {
        return this.address;
    }
    /**
    *
	* @return the print format of a SubscriptionPrime.eg,
	* 				This SubscriptionPrime title: Garden News, email:josh@josh.org,
                cost:5 , address: CS Birmingham.
    */
    @Override
    public String toString() {
        return "This SubscriptionPrime" +" title: " + super.getTitle()  +", email: " + super.getEmail() +
                ", cost: " + super.getCost() +", address: " + address  +".";
    }
}