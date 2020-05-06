/**
 * In the following I define the MusicTitle class and implements MusicTitleInterface.
 * @author Ruopeng Jiang
 * @version 2019-11-15
 */
public class MusicTitle implements MusicTitleInterface {
    private String title;
    private String artist;
    private int price;
    /**
     * This constructor contains three parts:
     * title, artist and price which are,a string,a string, an int.
     * @param title The title of the MusicTitle.eg, Pop is one of a title
     * @param artist The artist of the MusicTitle.eg,gem is one of a artist
     * @param price The Price of the MusicTitle.eg,$5 is one of a Price
     */
    public MusicTitle(String title, String artist, int price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    /**
     * Getter for the title of the MusicTitle.
     * @return The title of the MusicTitle.
     */
    @Override
    public String getTitle() {
        return this.title;
    }
    /**
     * Getter for the Artist of the MusicTitle.
     * @return The Artist of the MusicTitle.
     */
    @Override
    public String getArtist() {
        return this.artist;
    }
    /**
     * Getter for the Price of the MusicTitle.
     * @return The Price of the MusicTitle.
     */
    @Override
    public int getPrice() {
        return this.price;
    }
}