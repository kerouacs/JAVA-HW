/**
* In the following we define the Expenditure class 
* @author Ruopeng Jiang
* @version 2019-11-26
*/
public class Expenditure {
	private String description;
	private int value;
	/** This constructor creates a Good from the two parts:
	* description and value, which are a String and an int.
	* @param description The description of Expenditure(e.g., "travel" is a Expenditure description)
	* @param value The value of Expenditure (e.g., 10000 is a Expenditure value)
	*/
	public Expenditure(String description, int value) {
		this.description = description;
		this.value = value;
	}
	/**
	* @return description The description of Expenditure(e.g., "travel" is a Expenditure description)
	*/
	public String getDescription() {
		return description;
	}
	/**
	* @return value The value of Expenditure (e.g., 10000 is a Expenditure value)
	*/
	public int getValue() {
		return value;
	}
}


