//I worked on this alone.

import java.util.Random;

public class MartianCrew {

    private Astronaut[] crew;
    private static int crewCount = 5;

    public MartianCrew(String[] names) {
        crew = new Astronaut[10];
        for (int i = 0; i < 5; i++) {
            if (names[i].isEmpty()) {
                crew[i] = new Astronaut();
            } else {
                crew[i] = new Astronaut(names[i]);
            }
        }
    }

    public void feedCrew(MartianPlant plant) {
        for (int i = 0; i < 5; i++) {
            int h = crew[i].getHealth();
            if (h != 0) {
                crew[i].eat(plant.getNutrientLvl());
            }
        }
    }

    public boolean damageCrew() {
        Random gen = new Random();
        boolean isDead = false;
        for (int i = 0; i < 5; i++) {
            int h = crew[i].getHealth();
            if (h != 0) {
                boolean dead = crew[i].injure(gen.nextInt(50));
                if (dead) {
                    isDead = true;
                }
            }
        } return isDead;
    }

    public int getCrewCount() {
        return crewCount;
    }

    public Astronaut[] getCrewArray() {
        return crew;
    }
}