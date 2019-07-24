//I worked on this alone.

public class Astronaut {

    private String name;
    private int health;
    private boolean isAlive;

    public Astronaut(String n) {
        name = n;
        health = 100;
        isAlive = true;
    }

    public Astronaut() {
        name = "Anonymous";
        health = 100;
        isAlive = true;
    }

    public void eat(double plantNutrients) {
        health += (int) plantNutrients;
    }

    public boolean injure(int damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
            health = 0;
            return true;
        }
        return false;
    }

    public String toString() {
        if (health == 0) {
            return name + "has no health. We've lost him.";
        }
        return name + " has " + health + " health. He's still alive.";
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
}