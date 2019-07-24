//I worked on the homework assignment alone, using only course materials.

public class Item {
    private String itemName;
    private double itemPrice;
    private int itemRating;


    public Item(String n, double p, int r) {
        itemName = n;
        itemPrice = p;
        if (r < 1) {
            itemRating = 1;
        } else if (r > 5) {
            itemRating = 5;
        } else {
            itemRating = r;
        }
    }

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return itemPrice;
    }

    public int getRating() {
        return itemRating;
    }
}