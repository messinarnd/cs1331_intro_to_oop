// I worked on this alone.

import java.util.Random;

/**
* A class representing an Asteroid object. Extends AstronomicalObject and
* implements the Embarkable, Attackable, and Scannable interfaces.
* @author Christopher Messina
* @version 1.8
*/
public class Asteroid extends AstronomicalObject implements Attackable,
    Scannable, Embarkable {
    /**
    * An array of the possible SizeClasses for a Asteroid object.
    */
    private SizeClass[] mySize = new SizeClass[] {SizeClass.SMALL,
        SizeClass.MEDIUM};

    /**
    * The class's only constructor. Randomly assigns a size.
    */
    public Asteroid() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        size = mySize[i];
    }

    /**
    * A method that describes what the Asteroid object consists of.
    * @return a description of the asteroid.
    */
    public String scanned() {
        return id + " is just your average ball of space rock.";
    }

    /**
    * A method for attempting to board an object.
    * @return a string representing if the object was boarded and what happened
    */
    public String boarded() {
        Random rand = new Random();
        int i = rand.nextInt(100) + 1;
        if (i > CAN_EMBARK) {
            return "We were not able to reach " + id + ", Captain!";
        } else {
            return "We explored " + id + " some. Nothing interesting.";
        }
    }

    /**
    * A method for attempting to attack an object.
    * @return a string representing if the object was attacked
    */
    public String attacked() {
        Random rand = new Random();
        int i = rand.nextInt(100) + 1;
        if (i <= DODGE_CHANCE) {
            return "Our attack missed " + id + ", Captain!";
        } else {
            return id + " hit! Great job.";
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