//I worked on this alone.

import java.util.Random;

public class MartianFarm {

    private MartianPlant[] plants;
    private static int farmSize;

    public MartianFarm() {
        plants = new MartianPlant[10];
        for (int i = 0; i < 10; i++) {
            plants[i] = new MartianPlant();
            farmSize += 1;
        }
    }

    public void growFarm() {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] != null) {
                plants[i].grow();
            }
        }
    }

    public boolean damagePlants() {
        boolean dead = false;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] != null) {
                boolean plantDead = plants[i].shrivel();
                if (plantDead) {
                    removePlant(plants[i]);
                    dead = true;
                }
            }
        } return dead;
    }

    public MartianPlant removePlant(MartianPlant p) {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] != null) {
                if (plants[i].equals(p)) {
                    MartianPlant plantRemoved = plants[i];
                    plants[i] = null;
                    farmSize -= 1;
                    return plantRemoved;
                }
            }
        } return null;
    }

    public void plantPlant() {
        boolean emptySpace = false;
        int len = plants.length;
        for (int i = 0; i < len; i++) {
            if (plants[i] == null) {
                plants[i] = new MartianPlant();
                return;
            }
        }
        MartianPlant[] temp = new MartianPlant[len * 2];
        for (int i = 0; i < len; i++) {
            temp[i] = plants[i];
            temp[len + 1] = new MartianPlant();
            this.plants = new MartianPlant[len * 2];
        }
        for (int i = 0; i < temp.length; i++) {
            this.plants[i] = temp[i];
        }
    }

    public MartianPlant getRandPlant() {
        Random gen = new Random();
        int len = plants.length;
        int i = gen.nextInt(len);
        if (plants[i] != null) {
            return plants[i];
        } else {
            MartianPlant p = getRandPlant();
            return p;
        }
    }

    public MartianPlant[] getPlantArray() {
        return plants;
    }

    public int getFarmSize() {
        return farmSize;
    }
}