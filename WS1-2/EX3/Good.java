
/**
* In the following we define the Good class 
* @author Ruopeng Jiang
* @version 2019-10-10
*/
public class Good {
	String name;
	double netPrice;
	final static double VAT_RATE=20;
	/** This constructor creates a Good from the four parts:
	* name, netPrice, VAT_RATE,and grossprice, which are a String,a double,a final static double,
	* and a double, respectively.
	* @param name The name of the good (e.g., "milk" is one of the good name)
	* @param netPrice The netprice of the milk (e.g., $10 is a good netPrice)
	* @param VAT_RATE The VAT_RATE of the good It is always 0.2
	*/
	public Good(String name, double netPrice) {
		super();
		this.name = name;
		this.netPrice = netPrice;
	}
	/**
	* @return the name of the car (e.g., "milk" is one of the good name)
	*/
	public String getName() {
		return name;
	}
	/**
	* sets the name of a good
	* @param newname is the new name to which the good is set
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	* @return the make of the car (e.g., $10 is a good netPrice)
	*/
	public double getNetPrice() {
		return netPrice;
	}
	/**
	* sets the NetPrice of a good
	* @param NetPrice is the new NetPrice to which the good is set
	*/
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	/**
	* @return the print format of a good.eg,
	* 				The milk has a gross price of  £0.6.
	*/
	@Override
	public String toString() {
		return "The "+ name +" has a gross price of \u00A3"+ String.format("%.2f",grossPrice())+".";
	}
	/**
	* @return grossprice includes the VAT
	*/
	public double grossPrice() {
		return  netPrice*(1 + VAT_RATE/100);
	}
	/**
	* @param rate The discount rate of the good (e.g., 20 is one of the discount rate)
	* @return the grossprice of a good which includes discount.eg,
	* 				The milk has a gross price of  £0.48.
	*/
    public void discount(double rate) {
    	this.netPrice = netPrice * (100 - rate) / 100;
    }
}
