// I worked on this alone.

/**
* An interface extending the Comparable interface.
* @author Christopher Messina
* @version 1.4
*/
public interface Embarkable extends Comparable {
    /**
    * A variable representing the chance of boarding an object.
    */
    int CAN_EMBARK = 70;
    /**
    * A method for boarding an object.
    * @return a string representing if the object was boarded or not
    */
    String boarded(); // string representing if you boarded it or not
}