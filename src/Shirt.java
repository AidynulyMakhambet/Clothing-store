public class Shirt extends ClothingItem {
    private String sleeveType; // "Short", "Long"
    private boolean hasCollar;

    public Shirt(String id, String name, Brand brand, Size size, String color, double price, int stock,
                 String sleeveType, boolean hasCollar) {
        super(id, name, brand, size, color, "Shirt", price, stock); // super FIRST
        this.sleeveType = sleeveType;
        this.hasCollar = hasCollar;
    }

    // getters
    public String getSleeveType() { return sleeveType; }
    public boolean hasCollar() { return hasCollar; } // optional name

    @Override
    public String getType() { return "Shirt"; }

    @Override
    public void wear() {
        System.out.println("Wearing shirt: " + name + " (" + sleeveType + " sleeves).");
    }

    // unique methods (not in parent)
    public boolean isFormal() { return hasCollar; }
    public void iron() { System.out.println("Ironing shirt: " + name); }
}
