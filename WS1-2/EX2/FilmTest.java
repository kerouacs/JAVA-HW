
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 7 tests for the Film class.
 * @author RUOPENG JIANG
 * @version 2019-10-16
 */
public class FilmTest {

	private Date date;
	private Film Joker;

	@BeforeEach
    //public Film(String title, Date releaseDate, int length)
	//public Date (int day, String month, int year)
	public void beforeEach() {
		date = new Date(4, "December", 1995);
		Joker = new Film("Joker", date, 134);
	}
	// testing getter for getTitle
	@Test
	public void testGetTitle() {
		String expected = "Joker";
		String actual = Joker.getTitle();
		assertEquals(expected, actual, "error in getTtile");
	}
	// testing getter for Date Day
	@Test
	public void testDateDay() {
		int expectedDay = 4;
		int actualDay = Joker.getReleaseDate().getDay();
		assertEquals(expectedDay, actualDay, 
				"error in getDateDay");
	}
	// testing getter for Date Month
	@Test
	public void testDateMonth() {
		String expectedMonth = "December";
		String actualMonth = Joker.getReleaseDate().getMonth();
		assertEquals(expectedMonth, actualMonth,
				"error in getDatemonth");
	}
	// testing getter for Date Year
	@Test
	public void testDateYear() {
		int expectedYear = 1995;
		int actualYear = Joker.getReleaseDate().getYear();
		assertEquals(expectedYear, actualYear, 
				"error in getDateYear");
	}
	// testing getter for Length
	@Test
	public void testgetDateLength() {
		int expectedLength = 134;
		int actualLength = Joker.getLength();
		assertEquals(expectedLength, actualLength,
				"error in getLength");
	}
	// testing setter for ReleaseDate
	@Test
	public void testgetReleaseDate() {
		Date newReleaseDate = new Date(2, "January", 1999);
		Joker.setReleaseDate(newReleaseDate);
		String expectedDate = "2 January 1999";
		String actualDate = Joker.getReleaseDate().toString();
		assertEquals(expectedDate, actualDate, "error in getReleaseDate");
	}
	// testing whole class by creating a new objector
	@Test
	public void testWholeClass() {
		Date newReleaseDate = new Date(9, "July", 2025);
		Film ironMan = new Film("ironMan", newReleaseDate, 121);
		ironMan.setReleaseDate(new Date(8, "June", 2008));
		boolean expected = true;
		boolean actual = Joker.getReleaseDate() != newReleaseDate;
		assertEquals(expected, actual, "error in getReleaseDate");
		assertFalse(ironMan.getTitle().equals(Joker.getTitle()),
				"error in getTitle1");

		assertTrue(!ironMan.getTitle().equals(Joker.getTitle()),
				"error in getTitle2");

		assertTrue(ironMan.getReleaseDate().getDay() != Joker.getReleaseDate().getDay(),
				"error in getReleaseDate1");

		assertFalse(ironMan.getReleaseDate().getYear() == Joker.getReleaseDate().getYear(),
				"error in getReleaseDate2");
	}

}
