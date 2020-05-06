/**
 * In the following I define the Subscription class and implements SubscriptionInterface with three methods.
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class Subscription implements SubscriptionInterface {
    private String title;
    private String email;
    private int cost;
    /**
     * This constructor contains three parts:
     * title, email and cost which are,a string,a string, an int.
     * @param title The title of the Subscription.eg, Times is one of a title
     * @param email The email of the Subscription.eg,32523523@qq.com is one of a emails
     * @param cost The cost of the Subscription.eg,$5 is one of a costs
     */
    public Subscription(String title, String email, int cost) {
        this.title = title;
        this.email = email;
        this.cost = cost;
    }
    /**
     * Getter for the title of the Subscription.
     * @return The title of the Subscription.
     */
    @Override
    public String getTitle() {
        return this.title;
    }
    /**
     * Getter for the Email of the Subscription.
     * @return The Email of the Subscription.
     */
    @Override
    public String getEmail() {
        return this.email;
    }
    /**
     * Getter for the Cost of the Subscription.
     * @return The Cost of the Subscription.
     */
    @Override
    public int getCost() {
        return this.cost;
    }
    /**
    *
	* @return the print format of a Subscription.eg,
	* 				This Subscription tltle: Times, email: 21382567@qq.com, cost:5.
    */
    @Override
    public String toString() {
        return "This Subscription " +"title: " + title  +", email: " + email +", cost: " + cost +".";
    }
}