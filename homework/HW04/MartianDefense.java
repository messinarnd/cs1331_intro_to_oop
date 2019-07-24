//I worked on this alone.

public class MartianDefense {

    private int defenseRating;
    private Location loc;

    public MartianDefense(Location loc) {
        this.loc = loc;
        defenseRating = 20;
    }

    public MartianDefense() {
        this.loc = Location.NORTH;
        defenseRating = 20;
    }

    public boolean damage(int dam) {
        defenseRating -= dam;
        if (defenseRating <= 0) {
            defenseRating = 0;
            return true;
        }
        return false;
    }

    public void reinforce() {
        defenseRating += 5;
    }

    public void resetDefenseRating() {
        defenseRating = 20;
    }

    public String toString() {
        return "This defense is located on the " + loc
            + " side. It has a rating of " + defenseRating;
    }

    public Location getLocation() {
        return loc;
    }

    public int getDefenseRating() {
        return defenseRating;
    }
}