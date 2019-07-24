// I worked on this alone.

/**
* An interface extending the Comparable interface.
* @author Christopher Messina
* @version 1.3
*/
public interface Attackable extends Comparable {
    /**
    * A variable representing the chance of an attack being dodged.
    */
    int DODGE_CHANCE = 40;
    /**
    * A method for attacking an object.
    * @return a string representing if the attack was successful or not
    */
    String attacked(); // string representing if you successfully attacked it
}