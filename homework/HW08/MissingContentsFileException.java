// I worked with Choukri Nyon

/**
* An exception used for the ListSongs class. Gets thrown if the contents file
* is missing in a directory.
* @author Christopher Messina
* @version 1.2
*/
public class MissingContentsFileException extends Exception {
    /**
    * The one arg constructor.
    * @param dir The directory that does not have a contents.txt file
    */
    public MissingContentsFileException(String dir) {
        super("Directory " + dir + " does not contain a contents.txt file.");
    }
}