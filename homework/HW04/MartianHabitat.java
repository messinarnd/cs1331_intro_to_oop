//I worked on this alone.

import java.util.Random;

public class MartianHabitat {

    private MartianDefense[] defenses;
    private static int defenseCount = 4;

    public MartianHabitat() {
        defenses = new MartianDefense[4];
        defenses[0] = new MartianDefense(Location.NORTH);
        defenses[1] = new MartianDefense(Location.SOUTH);
        defenses[2] = new MartianDefense(Location.EAST);
        defenses[3] = new MartianDefense(Location.WEST);
    }

    public void reBuildDefense(Location location) {
        for (int i = 0; i < 4; i++) {
            if (defenses[i].getLocation().name().equals(location.name())) {
                defenses[i].resetDefenseRating();
                return;
            }
        } return;
    }

    public boolean reinforceDefenses() {
        boolean isReinforced = false;
        for (int i = 0; i < 4; i++) {
            if (defenses[i].getDefenseRating() != 0) {
                defenses[i].reinforce();
                isReinforced = true;
            }
        } return isReinforced;
    }

    public String[] damageDefenses() {
        String[] deadDefenses = new String[4];
        Random gen = new Random();
        for (int i = 0; i < 4; i++) {
            boolean isDead = defenses[i].damage(gen.nextInt(10) + 1);
            if (isDead) {
                deadDefenses[i] = defenses[i].getLocation().name();
                defenseCount -= 1;
            }
        } return deadDefenses;
    }

    public int getDefenseCount() {
        return defenseCount;
    }

    public MartianDefense[] getDefenseArray() {
        return defenses;
    }
}