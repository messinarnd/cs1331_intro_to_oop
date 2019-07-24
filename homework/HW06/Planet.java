// I worked on this alone.

import java.util.Random;

/**
* A class representing a Planet object. Extends AstronomicalObject and
* implements the Embarkable and Scannable interfaces.
* @author Christopher Messina
* @version 1.7
*/
public class Planet extends AstronomicalObject implements
    Embarkable, Scannable {
    /**
    * An array of the possible SizeClasses for a Planet object.
    */
    private SizeClass[] mySize = new SizeClass[] {SizeClass.LARGISH,
        SizeClass.HUGE};

    /**
    * The class's only constructor. Randomly assigns a size.
    */
    public Planet() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        size = mySize[i];
    }

    /**
    * A method that describes what the Planet object consists of.
    * @return a description of the Planet.
    */
    public String scanned() {
        Random rand = new Random();
        int i = rand.nextInt(100) + 1;
        if (i > 95) {
            return id + " consists of gold soil. We're rich!!";
        } else if (i <= 60) {
            return id + " is just dirt. Rather boring.";
        } else {
            return id + " is an icy tundra. Let's go to Punta Cana instead.";
        }
    }

    /**
    * A method for attempting to board an object.
    * @return a string representing if the object was boarded and what happened
    */
    public String boarded() {
        Random rand = new Random();
        int i = rand.nextInt(100) + 1;
        if (i > CAN_EMBARK) {
            return "We were not able to explore " + id + ", Captain!";
        } else {
            return "We succesfully canvassed " + id
                + ". It might be able to support life.";
        }
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