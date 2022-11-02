import java.util.ArrayList;

//Class (this ref) outer this ref knows about inner this ref, but inner this ref doesn't know outer this ref
//        ---> other class (nested class) (this ref)


public class Invoice { // this reference
    public static class Item { // Item is nested inside Invoice
        String description;
        int quantity;

        @Override
        public String toString() {
            return "Item{" +
                    "description='" + description + '\'' +
                    ", quantity=" + quantity +
                    ", unitPrice=" + unitPrice +
                    '}';
        }

        double unitPrice;

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        double price() {
            return quantity * unitPrice;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void display() {
//        for (int i=0; i < items.length, i++) {
//            System.out.println(items[i]);
//        }
        for (Item item: items) {
            System.out.println(item);
        }
    }
}