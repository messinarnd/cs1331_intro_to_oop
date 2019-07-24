// I worked on this alone

/**
* This class represents a Restaurant Chef Robot Object, child of a Chef Robot.
* @author cmessina6
* @version 1.1
*/
public class RestaurantChefRobot extends ChefRobot {
    /**
    * The instance variable representing the number of celebrities met.
    */
    protected int celebritiesMet;

    /**
    * Creates an instance of a Restaurant Chef Robot.
    * @param n a name String
    * @param bd a String representing their best dish
    * @param meals an int respresenting the number of meals served
    * @param menu a String array of items on the menu
    * @param celebs an int of the number of celebrities served
    */
    public RestaurantChefRobot(String n, String bd,
        int meals, String[] menu, int celebs) {
        super(n, bd, meals, menu); // maybe no param construstor
        celebritiesMet = celebs;
    }

    /**
    * Overrides the toString method in ChefRobot.
    * @return a String with the Chef's name, the number of meals served,
    *         their best dish, and how many celebrities they have met.
    */
    @Override
    public String toString() {
        return "Restaurant Chef " + name + ". Meals served: " + mealsServedCount
            + ". Best dish: " + bestDish + ". Has met " + celebritiesMet
            + " celebrities.";
    }

    /**
    * Sets the number of Celebrities met.
    * @param c the number of celebrities met
    */
    public void setCelebritiesMet(int c) {
        celebritiesMet = c;
    }

    /**
    * Gets the number of celebrities met.
    * @return an int of the number of celebrities met
    */
    public int getCelebritiesMet() {
        return celebritiesMet;
    }
}