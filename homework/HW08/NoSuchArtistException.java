// I worked with Choukri Nyon

/**
* An exception used for the ListSongs class. Gets thrown if the artist
* given does not have any songs.
* @author Christopher Messina
* @version 1.2
*/
public class NoSuchArtistException extends RuntimeException {
    /**
    * The constructor that takes in the artist name that doesn't
    * exist and the directory being searched.
    * @param name The name of the artist
    * @param dir The directory being searched
    */
    public NoSuchArtistException(String name, String dir) {
        super("Could not find any songs by artist " + name
            + " in " + dir + ".");
    }
}