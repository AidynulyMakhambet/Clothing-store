public class ClothingItem {
    protected String clothingId;
    protected String name;
    protected Brand brand;
    protected Size size;
    protected String color;
    protected String category;
    protected double price;
    protected int stockQuantity;

    // constructor
    public ClothingItem(String clothingId, String name, Brand brand, Size size,
                        String color, String category, double price, int stockQuantity){
        this.clothingId = clothingId;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.category = category;
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public String getType() { return "Generic"; }

    public void wear() {
        System.out.println(name + " is being worn.");
    }

    public double shippingFee() { return 1000; } // example

    // getters
    public String getId() { return clothingId; }
    public String getName() { return name; }
    public Brand getBrand() { return brand; }
    public Size getSize() { return size; }
    public String getColor() { return color; }
    public String getCategory() {return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    // setters

    public void setId(String id) { this.clothingId = id; }
    public void setName(String name) { this.name = name; }
    public void setBrand(Brand brand) { this.brand = brand; }
    public void setSize(Size size) { this.size = size; }
    public void setColor(String color) { this.color = color; }
    public void setCategory(String category) {this.category = category; }

    public void setPrice(double price){
        if (price < 0) throw new IllegalArgumentException("Price can not be negative.");
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity < 0) throw new IllegalArgumentException("Stock can not be negative.");
        this.stockQuantity = stockQuantity;
    }

    // methods

    public void applyDiscount( double percentage) {
        this.price = this.price - (this.price * percentage*0.01);
    }

    public boolean isAvailable() {
        return stockQuantity > 0;
    }

    public boolean isPremium() { return brand.getRating() >= 100; }

    // output data

    @Override
    public String toString() {
        return "ClothingItem{" +
                "clothingId= '" + clothingId + '\'' +
                ", brand= '" + brand.getName() + '\'' +
                ", size= '" + size.getSize() + '\'' +
                ", color= '" + color + '\'' +
                ", category= '" + category + '\'' +
                ", price= " + price +
                ", stockQuantity= " + stockQuantity +
                '}';
    }
}