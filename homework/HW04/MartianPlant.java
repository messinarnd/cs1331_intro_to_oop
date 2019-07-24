//I worked on this alone.

import java.util.Random;

public class MartianPlant {

    private double nutrientLvl;
    private static int totalPlants = 1;
    private int plantNum;

    public MartianPlant() {
        nutrientLvl = 12.5;
        plantNum = totalPlants++;
    }

    public void grow() {
        Random gen = new Random();
        nutrientLvl += gen.nextInt(5) + 1;
    }

    public boolean shrivel() {
        Random gen = new Random();
        nutrientLvl -= gen.nextInt(7) + 1;
        if (nutrientLvl <= 0) {
            nutrientLvl = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        MartianPlant otherPlant = (MartianPlant) obj;
        return this.plantNum == otherPlant.plantNum;
    }

    public double getNutrientLvl() {
        return nutrientLvl;
    }

    public int getPlantNum() {
        return plantNum;
    }
}