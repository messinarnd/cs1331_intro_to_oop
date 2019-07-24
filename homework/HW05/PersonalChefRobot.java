// I worked on this alone

/**
* This class represents a Personal Chef Robot Object, child of a Chef Robot.
* @author cmessina6
* @version 1.1
*/
public class PersonalChefRobot extends ChefRobot {
    /**
    * The instance variable representing whether or not
    * the Personal Chef can host guests.
    */
    protected boolean canHostGuests;

    /**
    * Creates an instance of a Personal Chef Robot.
    * @param name a name String
    * @param bestDish a String of the Chef's best dish
    * @param meals an int of the number of meals served
    * @param menu a String array of the items on the menu
    * @param host a boolean representing whether or not the Chef can host guests
    */
    public PersonalChefRobot(String name, String bestDish,
        int meals, String[] menu, boolean host) {
        super(name, bestDish, meals, menu); //maybe no params constructor
        canHostGuests = host;
    }

    /**
    * Overrides the toString method in ChefRobot.
    * @return a String with the Chef's name, number of meals served,
    *         their best dish, and if the can host guests or not.
    */
    @Override
    public String toString() {
        if (canHostGuests) {
            return "Personal Chef " + name + ". Meals served: "
                + mealsServedCount + ". Best dish: " + bestDish
                + ". Can host guests.";
        } else {
            return "Personal Chef " + name + ". Meals served: "
                + mealsServedCount + ". Best dish: " + bestDish
                + ". Cannot host guests.";
        }
    }

    /**
    * Gets whether the Chef can host guests or not.
    * @return a boolean value of the representation
    */
    public boolean getCanHostGuests() {
        return canHostGuests;
    }

    /**
    * Sets whether the Chef can host guests or not.
    * @param b a boolean value of this representation
    */
    public void setCanHostGuests(boolean b) {
        canHostGuests = b;
    }
}