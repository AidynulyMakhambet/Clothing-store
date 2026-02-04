package model;

public class Shirt extends ClothingItem {
    private String sleeveType; // "Short", "Long"

    public Shirt(String clothingItemId, String name, String color, String size, double price, int stockQuantity, String brand, String sleeveType) {
        super(clothingItemId, name, color, size, price, stockQuantity, brand); // super FIRST
        this.sleeveType = sleeveType;
    }

    // ==================== Implementing abstract methods ====================
    @Override public void clean(){
        System.out.println(name + " is cleaned, it's type is: " + getType());
    }

    @Override
    public String getType() { return "Shirt"; }

    @Override
    public double shippingFee() { return 1000; }


    // ==================== Implementing Wearable interface ====================
    @Override
    public void wear() {
        System.out.println("Wearing: " + name + " (" + sleeveType + " sleeves).");
    }

    // ==================== Unique methods (not in parent) ====================
    public void iron() { System.out.println("Ironing shirt: " + name); }


    // getters
    public String getSleeveType() { return sleeveType; }

    // setters
    public void setSleeveType(String sleeveType) { this.sleeveType = sleeveType; }
}
