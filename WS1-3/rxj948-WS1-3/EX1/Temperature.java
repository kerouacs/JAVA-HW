/**
* In the following I define the Temperature class to show the coldest day in a year
* @author Ruopeng Jiang
* @version 2019-10-28
*/
public class Temperature {
    /**
     *  Method to coldest :get the coldest day of the given days.
     *  @param temperature :the temperatures of 365 given days.
     *  @return the coldest day in a year.
     */
	public static int coldest(double[] temperature) {	
		double coldestTemperature= temperature[0];//store the coldest temperature.
		int date=0;
		for(int i=0;i<temperature.length;i++) {
			if (temperature[i]<coldestTemperature) {
				coldestTemperature=temperature[i];
				date=i;
			}
		}
	return date+1;//make the first index is 1.
	}
}