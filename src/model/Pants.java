package model;

public class Pants extends ClothingItem {
    private String fit; // "Slim", "Regular"
    private boolean hasBeltLoops;

    public Pants(String id, String name, Brand brand, Size size, String color, double price, int stock,
                 String fit, boolean hasBeltLoops) {
        super(id, name, brand, size, color, "Pants", price, stock);
        this.fit = fit;
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
        System.out.println("Wearing: " + name + " (fit: " + fit + ").");
    }

    public String getMaterial(){
        return "Material for " + name + " (" + category + ")";
    }

    @Override
    public double shippingFee() { return 1000; }

    // ==================== unique methods (not in parent) ====================
    public boolean needsBelt() { return hasBeltLoops; }

    // methods to demonstrate polymorphism
    public void hem(int cm) { System.out.println("Hemming pants by " + cm + " cm."); }


    // getters
    public String getFit() { return fit; }
    public boolean hasBeltLoops() { return hasBeltLoops; } // optional

    // setters
    public void setFit(String fit) { this.fit = fit; }
    public void setHasBeltLoops(boolean hasBeltLoops) { this.hasBeltLoops = hasBeltLoops; } // optional
}
