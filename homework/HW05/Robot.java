// I worked on this alone.

/**
* This class is a super class that represents a robot.
* @author cmessina6
* @version 1.0
*/
public class Robot {
    /**
    * The robot's name.
    */
    protected String name;

    /**
    * Creates an Robot template after providing their name.
    * @param n name of robot String
    */
    public Robot(String n) {
        name = n;
    }

    /**
    * Overrides the toString method from the Object class.
    * @return a String with the name of the robot followed by a period
    */
    @Override
    public String toString() {
        return this.name + ".";
    }

    /**
    * Sets the name of the robot.
    * @param n name of robot String
    */
    public void setName(String n) {
        name = n;
    }

    /**
    * Gets the name of the robot.
    * @return a String with the name of the robot
    */
    public String getName() {
        return name;
    }
}