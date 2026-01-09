public class Pants extends ClothingItem {
    private String fit; // "Slim", "Regular"
    private boolean hasBeltLoops;

    public Pants(String id, String name, Brand brand, Size size, String color, double price, int stock,
                 String fit, boolean hasBeltLoops) {
        super(id, name, brand, size, color, "Pants", price, stock);
        this.fit = fit;
        this.hasBeltLoops = hasBeltLoops;
    }

    // getters
    public String getFit() { return fit; }
    public boolean hasBeltLoops() { return hasBeltLoops; } // optional name

    @Override
    public String getType() { return "Pants"; }

    @Override
    public void wear() {
        System.out.println("Wearing pants: " + name + " (fit: " + fit + ").");
    }

    public void hem(int cm) { System.out.println("Hemming pants by " + cm + " cm."); }
    public boolean needsBelt() { return hasBeltLoops; }
}
