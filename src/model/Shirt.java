package model;

public class Shirt extends ClothingItem {
    private String sleeveType; // "Short", "Long"
    private boolean hasCollar;

    public Shirt(String id, String name, Brand brand, Size size, String color, double price, int stock,
                 String sleeveType, boolean hasCollar) {
        super(id, name, brand, size, color, "Shirt", price, stock); // super FIRST
        this.sleeveType = sleeveType;
        this.hasCollar = hasCollar;
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

    @Override
    public String getMaterial(){
        return "Material for " + name + " (" + category + ")";
    }

    // ==================== Unique methods (not in parent) ====================
    public boolean isFormal() { return hasCollar; }
    public void iron() { System.out.println("Ironing shirt: " + name); }


    // getters
    public String getSleeveType() { return sleeveType; }
    public boolean hasCollar() { return hasCollar; } // optional

    // setters
    public void setSleeveType(String sleeveType) { this.sleeveType = sleeveType; }
    public void setHasCollar(boolean hasCollar) { this.hasCollar = hasCollar; } // optional
}
