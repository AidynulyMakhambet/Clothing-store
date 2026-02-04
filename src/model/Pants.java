package model;

public class Pants extends ClothingItem {
    private boolean hasBeltLoops;

    public Pants(String clothingItemId, String name, String color, String size, double price, int stockQuantity, String brand, boolean hasBeltLoops) {
        super(clothingItemId, name, color, size, price, stockQuantity, brand);
        this.hasBeltLoops = hasBeltLoops;
    }

    // ==================== Implementing abstract methods ====================
    @Override
    public String getType() { return "Pants"; }

    @Override public void clean(){
        System.out.println(name + " is cleaned, it's type is: " + getType());
    }

    // ==================== Implementing Wearable interface ====================
    @Override
    public void wear() {
        System.out.println("Wearing: " + name);
    }

    @Override
    public double shippingFee() { return 1000; }

    // ==================== unique methods (not in parent) ====================
    public boolean needsBelt() { return hasBeltLoops; }

    // methods to demonstrate polymorphism
    public void hem(int cm) { System.out.println("Hemming pants by " + cm + " cm."); }


    // getters
    public boolean getHasBeltLoops() { return hasBeltLoops; } // optional

    // setters
    public void setHasBeltLoops(boolean hasBeltLoops) { this.hasBeltLoops = hasBeltLoops; } // optional

}
