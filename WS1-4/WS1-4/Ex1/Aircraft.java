/**
* In the following I define the Aircraft class 
* @author Ruopeng Jiang
* @version 2019-11-15
*/
public class Aircraft {
	private int passengerNumber;
	private int maxSpeed;
	/** This constructor creates a Aircraft from the two parts:
	* passengerNumber and maxSpeed which are,an int,an int.
    * @param passengerNumber The passengerNumber of the Aircraft.(e.g.,50 is one of a passengerNumber)
    * @param maxSpeed The maxSpeed of the Aircraft.(e.g., 150KM/H is one of a maxSpeed)
    */
   public Aircraft(int passengerNumber, int maxSpeed) {
       this.passengerNumber = passengerNumber;
       this.maxSpeed = maxSpeed;
   }
   /**
    * Setter for the passengerNumber. 
    * Sets the passenger number of a car
    * @param passengerNumber The passengerNumber of the Aircraft.
    */
   public void setPassengerNumber(int passengerNumber) {
       this.passengerNumber = passengerNumber;
   }
   /**
    * Setter for the maxSpeed. 
    * Sets the max speed of a Aircraft
    * @param maxSpeed The maxSpeed of the Aircraft.
    */
   public void setMaxSpeed(int maxSpeed) {
       this.maxSpeed = maxSpeed;
   }
   /**
    * Getter for the passengerNumber.
    * @return The passenger number of the Aircraft(e.g.,50 is one of a passengerNumber)
    */
   public int getPassengerNumber() {
       return passengerNumber;
   }
   /**
    * Getter for the maxSpeed.
    * @return The max speed of the Aircraft(e.g., 150KM/H is one of a maxSpeed)
    */
   public int getMaxSpeed() {
       return maxSpeed;
   }
   /**
    *
	* @return the print format of a aircraft.eg,
	* 				This aircraft passenger number : 50, and max speed : 150KM/H
    */
   @Override
   public String toString() {
       return "This aircraft " + "passenger number : " + passengerNumber +
               ", and maxSpeed : " + maxSpeed +"KM/H";
   }	
}
