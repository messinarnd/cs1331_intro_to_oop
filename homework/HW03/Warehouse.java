//I worked on the homework assignment alone, using only course materials.

import java.util.Random;

public class Warehouse {

    private Rack[][] racksInHouse;


    public Warehouse(int rows) {
        Random gen = new Random();
        racksInHouse = new Rack[rows][];
        int cols;
        for (int r = 0; r < rows; r++) {
            cols = gen.nextInt(6) + 5;
            racksInHouse[r] = new Rack[cols];
            for (int c = 0; c < cols; c++) {
                racksInHouse[r][c] = new Rack();
            }
        }
    }

    public Item order(String itemName) {
        int rows = racksInHouse.length;
        for (int r = 0; r < rows; r++) {
            int cols = racksInHouse[r].length;
            for (int c = 0; c < cols; c++) {
                if (racksInHouse[r][c].equalsName(itemName)) {
                    Item removeItem = racksInHouse[r][c].remove(itemName);
                    return removeItem;
                }
            }
        }
        return null;
    }

    public boolean store(Item storingItem) {
        Random gen = new Random();
        int nRows = racksInHouse.length;
        int row = gen.nextInt(nRows);
        int nCols = racksInHouse[row].length;
        int col = gen.nextInt(nCols);
        if (racksInHouse[row][col].count() == 10) {
            return false;
        } else {
            return racksInHouse[row][col].add(storingItem);
        }
    }

    public double totalAssets() {
        double sum = 0.0;
        int nRows = racksInHouse.length;
        for (int r = 0; r < nRows; r++) {
            int nCols = racksInHouse[r].length;
            for (int c = 0; c < nCols; c++) {
                int count;
                count = racksInHouse[r][c].count();
                Item[] myItems = racksInHouse[r][c].getItems();
                for (int i = 0; i < count; i++) {
                    sum += myItems[i].getPrice();
                }
            }
        }
        return sum;
    }
}