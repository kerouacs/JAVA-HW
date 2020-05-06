/**
 * In the following I define the Aeroplane class 
 * Which is the subclass of the Aircraft and it has an additional filed variable
 * fuelConsumption of type double.
 *
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class Aeroplane extends Aircraft {
    private double fuelConsumption;
    /**
     * Aircraft is a class contains two parts:
     * passengerNumber and maxSpeed which are,an int,an int.
     * @param passengerNumber The passengerNumber of the Aircraft.(e.g.,50 is one of a passengerNumber)
     * @param maxSpeed The maxSpeed of the Aircraft.(e.g., 150KM/H is one of a maxSpeed)
     */
    
    /**
     * This constructor creates a Aeroplane from the three parts:
	 * passengerNumber, maxSpeed and fuelConsumption which are,an int,an int and a double.
     * @param passengerNumber The passenger number of the Aeroplane.(e.g.,300 is one of a passengerNumber)
     * @param maxSpeed The max speed of the Aeroplane.(e.g., 400KM/H is one of a maxSpeed)
     * @param fuel consumption The fuelConsumption of the Aeroplane.(e.g.,20.0 is one of a fuelConsumption
     */
    public Aeroplane(int passengerNumber, int maxSpeed, double fuelConsumption) {
        super(passengerNumber, maxSpeed);
        this.fuelConsumption = fuelConsumption;
    } 
    /** 
    * Setter for the FuelConsumption. 
    * Sets the Fuel Consumption of a Aeroplane
    * @param FuelConsumption The Fuel Consumption of the Aeroplane.
    */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    /**
     * Getter for the fuelConsumption of the Aeroplane.
     * @return The fuel Consumption of the Aeroplane
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    /**
     *
	 * @return the print format of a aeroplane.eg,
	 * 				This aeroplane fuelConsumption : 20.0, and This aeroplane passenger number : 50, and max speed : 150KM/H
     */
    @Override
    public String toString() {
        return "This aeroplane" +" fuelConsumption: " + fuelConsumption +
                 ", and "+ super.toString();
    }
}