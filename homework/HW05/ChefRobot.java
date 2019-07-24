// I worked on this alone

import java.util.Random;

/**
* This class represents a Chef Robot Object, child of a Robot.
* @author cmessina6
* @version 1.1
*/
public class ChefRobot extends Robot {
    /**
    * The instance variable representing the Chef's best dish.
    */
    protected String bestDish;
    /**
    * The instance variable representing the number of meals served.
    */
    protected int mealsServedCount;
    /**
    * The instance variable representing the String array of menu items.
    */
    protected String[] menu;

    /**
    * Creates an instance of a Chef Robot.
    * @param n a name String
    * @param bd a String of their best dish
    * @param meals an int of the number of meals they have served
    * @param menu a String array of all of their meals
    */
    public ChefRobot(String n, String bd, int meals, String[] menu) {
        super(n);
        bestDish = bd;
        mealsServedCount = meals;
        this.menu = menu;
    }

    /**
    * Overrides the Robot toString method.
    * @return a String with the Chef's name,
    *         number of meals served, and their best dish
    */
    @Override
    public String toString() {
        return "Chef " + name + ". Meals served: " + mealsServedCount
            + ". Best dish: " + bestDish + ".";
    }

    /**
    * Serves a random meal to the guest and increases mealsServedCount.
    * @return a string of the meal served
    */
    public String serveMeal() {
        Random gen = new Random();
        int i = gen.nextInt(menu.length);
        mealsServedCount += 1;
        return menu[i];
    }

    /**
    * Gets the Chef's best dish.
    * @return a String of the best dish
    */
    public String getBestDish() {
        return bestDish;
    }

    /**
    * Sets the Chef's best dish.
    * @param s a String of their best dish
    */
    public void setBestDish(String s) {
        bestDish = s;
    }

    /**
    * Gets the number of meals served.
    * @return an int of the number of meals served
    */
    public int getMealsServed() {
        return mealsServedCount;
    }

    /**
    * Sets the number of meals served.
    * @param i an int of the meals served
    */
    public void setMealsServed(int i) {
        mealsServedCount = i;
    }

    /**
    * Gets the Chef's menu.
    * @return a String array of the menu items
    */
    public String[] getMenu() {
        return menu;
    }

    /**
    * Sets the Chef's menu.
    * @param m a String array of the Chef's menu items
    */
    public void setMenu(String[] m) {
        menu = m;
    }
}