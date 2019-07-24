// I worked with Choukri Nyon

/**
* An exception used for the ListSongs class. Gets thrown if a command line
* argument is missing.
* @author Christopher Messina
* @version 1.1
*/
public class MissingArgumentException extends RuntimeException {

    /**
    * The constructor that takes in the argument index that is
    * missing and the message corresponding to that missing argument.
    * @param ndx The index of the missing argument
    * @param message The message corresponding the the missing argument
    */
    public MissingArgumentException(int ndx, String message) {
        super("Missing argument at position " + ndx + ": " + message);
    }

    /**
    * The exception's no arg constructor.
    */
    public MissingArgumentException() {
        super("No Arguments Provided.");
    }
}