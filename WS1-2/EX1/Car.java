/**
* In the following we define the Car class 
* @author Ruopeng Jiang
* @version 2019-10-10
*/
class Car{
	String make;
	int price;
	int maxSpeed;
	String colour;
	/** This constructor creates a Car from the four parts:
	* make, price, maxSpeed,and colour, which are a String,an int,an int,
	* and a String, respectively.
	* @param make The make of the car (e.g., "Ford" is one of the car make)
	* @param price The price of the car (e.g., $20000 is a car price)
	* @param maxSpeed The maxSpeed of the car (e.g., 250KN/H is the maxSpeed of the car)
	* @param coulour The colour of the car (e.g., "blue" is a car colour)
	*/
	public Car(String make,int price,int maxSpeed,String colour){
		this.make=make;
		this.price=price;
		this.maxSpeed=maxSpeed;
		this.colour=colour;
	}
	/**
	* @return the make of the car (e.g., "Ford" is one of the car make)
	*/
	public String getMake(){
		return make;
	}
	/**
	* @return the price of the car (e.g., $20000 is a car price)
	*/
	public int getPrice(){
		return price;
	}
	/**
	* @return the maxSpeed The maxSpeed of the car (e.g., 250KN/H is the maxSpeed of the car)
	*/
	public int getMaxSpeed(){
		return maxSpeed;
	}
	/**
	* @return the colour of the car (e.g., "blue" is a car coulour)
	*/
	public String getColour(){
		return colour;
	}
	/**
	* sets the make of a car
	* @param newmake is the new make to which the car is set
	*/
	public void setMake(String make){
		this.make=make;
	}
	/**
	* sets the price of a car
	* @param newprice is the new price to which the car is set
	*/
	public void setPrice(int price){
		this.price=price;
	}
	/**
	* sets the maxSpeed of a car
	* @param newmaxSpeed is the new maxSpeed to which the car is set
	*/
	public void setMaxSpeed(int maxSpeed){
		this.maxSpeed=maxSpeed;
	}
	/**
	* sets the colour of a car
	* @param newcolour is the new colour to which the car is set
	*/
	public void setColour(String colour){
		this.colour=colour;
	}
	/**
	* @return the print format of a car.eg,
	* 				Car make :ford Car price: 20000 Car maxSpeed:200KM/H Car colour: blue.
	*/
	@Override
	public String toString(){
		return "Car make:"+make+" Car price: "+price+" Car maxSpeed: "+maxSpeed+ "KM/H"+" Car colour:"+ colour;
	}
}