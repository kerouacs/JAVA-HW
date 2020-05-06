/**
* In the following we define the Film class 
* @author Ruopeng Jiang
* @version 2019-10-10
*/
public class Film {
	private String title;
	private Date releaseDate;
	private int length;
	/** This constructor creates a Film from the three parts:
	* title, releaseDate, length, which are a String,a Date(a class definition),an int, respectively.
	* @param title The name of the Film (e.g., "Joker" is one of the Film title)
	* @param releaseDate The release date of the Film (e.g., 20 MAY 2018 is a Film releaseDate)
	* @param length The length of the Film (e.g., 120 minutes is the length of a film)
	*/
	public Film(String title, Date releaseDate, int length) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.length = length;
	}
	/** 
	*  @return The ReleaseDate of a film.
	*/
	public Date getReleaseDate() {
		return releaseDate;
	}
	/**
	* sets the ReleaseDate of a movie
	* @param newReleaseDate is the new ReleaseDate to which the film is set
	*/
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	* @return the title of a film 
	*/
	public String getTitle() {
		return title;
	}
	/** 
	*  @return The length of a film.
	*/
	public int getLength() {
		return length;
	}
	/**
	* @return the print format of a film.eg,
	* 				Film [title=Ad Astra, releaseDate=18 September 2019, length=123 minutes].
	*/
	@Override
	public String toString() {
		return "Film [title=" + title + ", releaseDate=" + releaseDate + ", length=" + length + " minutes]";
	}
/**
* In the following we define the main method to execute 
* the example from worksheet2. 
*/
	public static void main(String[] args) {
		Film adAstra=new Film( "Ad Astra", new Date(18, "September", 2019),123);
		System.out.println(adAstra.toString());
	}
}



