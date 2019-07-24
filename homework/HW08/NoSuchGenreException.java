// I worked with Choukri Nyon

/**
* An exception used for the ListSongs class. Gets thrown if the genre
* given does not exist.
* @author Christopher Messina
* @version 1.3
*/
public class NoSuchGenreException extends RuntimeException {
    /**
    * The constructor that takes in the genre name that doesn't
    * exist and the directory being searched.
    * @param genre The name of the genre
    * @param dir The directory being searched
    */
    public NoSuchGenreException(String genre, String dir) {
        super("Could not find any songs belonging to the " + genre
            + " genre in " + dir + ".");
    }
}