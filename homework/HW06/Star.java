// I worked on this alone.

import java.util.Random;

/**
* A class representing a Star object. Extends AstronomicalObject and implements
* the Scannable interface.
* @author Christopher Messina
* @version 1.6
*/
public class Star extends AstronomicalObject implements Scannable {
    /**
    * An array of the possible SizeClasses for a Star object.
    */
    private SizeClass[] mySize = new SizeClass[] {SizeClass.MASSIVE,
        SizeClass.GIGANTIC};

    /**
    * The class's only constructor. Randomly assigns a size.
    */
    public Star() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        size = mySize[i];
    }

    /**
    * A method that describes what the Star object consists of.
    * @return a description of the star.
    */
    public String scanned() {
        return id + " is a flaming ball of gas.";
    }

    /**
    * Overrides AstronomicalObject's toString method.
    * @return the object's id as a string
    */
    @Override
    public String toString() {
        return id;
    }
}