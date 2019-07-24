// I worked on this alone.

import java.util.Random;

/**
* An abstract class implementing the Comparable interface that represents
* an AstronomicalObject object.
* @author Christopher Messina
* @version 1.1
*/
public abstract class AstronomicalObject implements Comparable {
    /**
    * A string representing the id of an object. Includes the type of
    * object and a random hexadecimal.
    */
    protected String id;
    /**
    * An enumerated type SizeClass representing the size of the object.
    */
    protected SizeClass size;
    /**
    * A static variable that counts the number of AstronomicalObjects
    * created.
    */
    private static int count = 0;

    /**
    * The only constructor for this class. Generates an id.
    */
    public AstronomicalObject() {
        id = generateid();
        count++;
    }

    /**
    * A method that describes an object based on its size.
    * @return a string describing the object
    */
    protected String observed() {
        if (size.ordinal() == 0) {
            return id + " isn't much.";
        } else if (size.ordinal() == 1) {
            return id + " might be a ship to worry about.";
        } else if (size.ordinal() == 2) {
            return id + " is a pebble in a pond.";
        } else if (size.ordinal() == 3) {
            return id + " isn't much concern.";
        } else if (size.ordinal() == 4) {
            return id + " has a little mass to it.";
        } else if (size.ordinal() == 5) {
            return id + " is so fat, Dora couldn't explore it.";
        } else if (size.ordinal() == 6) {
            return id + " shines brightly.";
        } else {
            return id + " is a blinding light.";
        }
    }

    /**
    * Compares two AstronomicalObjects' sizes.
    * @param obj an Object that you want to compare
    * @return an int showing if they are the same or not. -1 if this is
    *         smaller than the object, 0 if same, and 1 if this is bigger
    */
    public int compareTo(Object obj) {
        if (!(obj instanceof AstronomicalObject)) {
            return -101010101;
        }
        AstronomicalObject a = (AstronomicalObject) obj;
        if (this.size.ordinal() == a.size.ordinal()) {
            return 0;
        } else if (this.size.ordinal() < a.size.ordinal()) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
    * Overrides Object's toString method.
    * @return the object's id as a string
    */
    @Override
    public String toString() {
        return id;
    }

    /**
    * Gets the object's id
    * @return the object's id as a string
    */
    public String getid() {
        return id;
    }

    /**
    * Gets the object's size.
    * @return the object's size as a SizeClass enumerated type
    */
    public SizeClass getSize() {
        return size;
    }

    /**
    * Gets the count of AstronomicalObjects created.
    * @return the class's count
    */
    public static int getCount() {
        return count;
    }


    //NOTE: DON'T CHANGE ANY CODE PAST THIS LINE
    /**
     * A method that generates a random id based upon the type of the
     * object. You should use this each time the AstronomicalObject constructor
     * is called.
     *
     * @return The A randomly generated id for the instance the method
     *         is called on
     */
    private String generateid() {
        Random randGen = new Random();
        String hex = Integer.toHexString(randGen.nextInt());
        return this.getClass().getName() + "-" + hex;
    }
}
