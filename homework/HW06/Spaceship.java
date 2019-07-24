// I worked on this alone.

import java.util.Random;

/**
* A class representing a Spaceship object. Extends AstronomicalObject and
* implements the Embarkable and Attackable interfaces.
* @author Christopher Messina
* @version 1.9
*/
public class Spaceship extends AstronomicalObject
    implements Attackable, Embarkable {
    /**
    * An array of the possible SizeClasses for a Spaceship object
    */
    private SizeClass[] mySize = new SizeClass[] {SizeClass.TEENY,
        SizeClass.TINY};

    /**
    * The class's only constructor. Randomly assigns a size.
    */
    public Spaceship() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        size = mySize[i];
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
    * A method for attempting to board an object.
    * @return a string representing if the object was boarded and what happened.
    */
    public String boarded() {
        Random rand = new Random();
        int i = rand.nextInt(100) + 1;
        if (i > CAN_EMBARK) {
            return "We were not able to board " + id + ", Captain!";
        } else {
            return "We boarded " + id
                + " and met the crew. Keep your eye on them.";
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