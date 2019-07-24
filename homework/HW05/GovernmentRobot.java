// I worked on this alone.

/**
* This class represents a Government Robot Object, child of a Robot.
* @author cmessina6
* @version 1.1
*/
public class GovernmentRobot extends Robot {
    /**
    * The instance variable representing the project count.
    */
    protected int projectCount;
    /**
    * The instance variable representing the security clearance.
    */
    protected boolean hasSecurityClearance;

    /**
    * Creates a Government Robot.
    * @param n a String representing the robot's name
    * @param pc an int represting the number of projects completed
    * @param sc a boolean representing if the robot has securit clearance
    */
    public GovernmentRobot(String n, int pc, boolean sc) {
        super(n);
        projectCount = pc; //maybe include no argument constructor
        hasSecurityClearance = sc;
    }

    /**
    * Overrides Robot's toString.
    * @return a String containing the name of the robot,
    *         the number of projects completed and thier security clearance.
    */
    @Override
    public String toString() {
        if (hasSecurityClearance) {
            return "Government Robot " + name + " has completed "
                + projectCount + " projects and has security clearance.";
        } else {
            return "Government Robot " + name + " has completed "
                + projectCount
                + " projects and does not have security clearance.";
        }
    }

    /**
    * Gets the project count.
    * @return an int representing the project count
    */
    public int getProjectCount() {
        return projectCount;
    }

    /**
    * Sets the project count.
    * @param p an int representing the new project count
    */
    public void setProjectCount(int p) {
        projectCount = p;
    }

    /**
    * Gets the security clearance.
    * @return the boolean value of whether or not they have clearance
    */
    public boolean getHasSecurityClearance() {
        return hasSecurityClearance;
    }

    /**
    * Sets the security clearance.
    * @param b a boolean value of whether or not they have clearance
    */
    public void setHasSecurityClearance(boolean b) {
        hasSecurityClearance = b;
    }
}