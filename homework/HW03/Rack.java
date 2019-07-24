//I worked on the homework assignment alone, using only course materials.

public class Rack {

    private Item[] itemsOnRack;
    private int count;


    public Rack() {
        itemsOnRack = new Item[10];
    }

    public int count() {
        count = 0;
        for (int i = 0; i < 10; i++) {
            if (itemsOnRack[i] != null) {
                count = count + 1;
            }
        }
        return count;
    }

    public boolean add(Item yourItem) {
        if (count() != 10) {
            boolean ifNull = false;
            int index = 0;
            while (!ifNull && index < 10) {
                if (itemsOnRack[index] == null) {
                    itemsOnRack[index] = yourItem;
                    ifNull = true;
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    public Item remove(String name) {
        for (int i = 0; i < 10; i++) {
            if (itemsOnRack[i].getName().equals(name)) {
                Item itemRemoved = itemsOnRack[i];
                itemsOnRack[i] = null;
                for (int rest = i + 1; rest < 10; rest++) {
                    itemsOnRack[i] = itemsOnRack[rest];
                    i++;
                }
                return itemRemoved;
            }
        }
        return null;
    }

    public Item[] getItems() {
        return itemsOnRack;
    }

    public boolean equalsName(String s) {
        count = this.count();
        String[] itemNames = new String[count];
        Item[] theseItems = this.getItems();
        for (int i = 0; i < count; i++) {
            itemNames[i] = theseItems[i].getName();
        }
        for (int i = 0; i < count; i++) {
            if (itemNames[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
}