package model;

import exception.InvalidInputException;

public abstract class ClothingItem implements Wearable {
    protected String clothingItemId;
    protected String name;
    protected String color;
    protected String size;
    protected double price;
    protected int stockQuantity;
    protected String brand;

    // constructor
    public ClothingItem(String clothingItemId, String name, String color, String size, double price, int stockQuantity, String brand){
        this.clothingItemId = clothingItemId;
        this.name = name;
        this.color = color;
        this.size = size;
        setPrice(price);
        setStockQuantity(stockQuantity);
        this.brand = brand;
    }

    // =================== Abstract methods =================== //
    public abstract void clean();
    public abstract String getType();
    public abstract double shippingFee();

    // Other methods
    public void applyDiscount( double percentage) {
        this.price = this.price - (this.price * percentage*0.01);
    }

    public boolean isAvailable() {
        return stockQuantity > 0;
    }


    // getters
    public String getClothingItemId() { return clothingItemId; }
    public String getName() {return name; }
    public String getColor() { return color; }
    public String getSize() { return size; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public String getBrand() { return brand; }

    // setters
    public void setClothingItemId(String clothingItemId) { this.clothingItemId = clothingItemId; }
    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    public void setSize(String size) { this.size = size; }

    public void setPrice(double price){
        if (price < 0) throw new IllegalArgumentException("Price can not be negative.");
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity < 0) throw new IllegalArgumentException("Stock can not be negative.");
        this.stockQuantity = stockQuantity;
    }

    public void setBrand(String brand) { this.brand = brand; }



    // output data

    @Override
    public String toString() {
        return "ClothingItem{" +
                ", name= '" + name + '\'' +
                ", color= '" + color + '\'' +
                ", size= '" + size + '\'' +
                ", price= " + price +
                ", stockQuantity= " + stockQuantity +
                ", brand= '" + brand + '\'' +
                '}';
    }
}