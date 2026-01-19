package model;

public class Size {
    private String size; // e.g. "XS", "S", "M", "L", "XL", "42", "44"
    private String type; // e.g., "Top", "Bottom", "Shoes"
    private Double chestCm;   // optional
    private Double waistCm;   // optional
    private Double hipCm;     // optional

    // constructor
    public Size(String size, String type) {
        this.size = size;
        this.type = type;
    }

    // getters
    public String getSize() { return size; }
    public String getType() { return type; }
    public Double getChestCm() { return chestCm; }
    public Double getWaistCm() { return waistCm; }
    public Double getHipCm() { return hipCm; }

    // setters
    public void setLabel(String size) { this.size = size; }
    public void setType(String type) { this.type = type; }

    public void setMeasurements(Double chestCm, Double waistCm, Double hipCm) {
        if (chestCm != null && chestCm <= 0) throw new IllegalArgumentException("chestCm must be > 0");
        if (waistCm != null && waistCm <= 0) throw new IllegalArgumentException("waistCm must be > 0");
        if (hipCm != null && hipCm <= 0) throw new IllegalArgumentException("hipCm must be > 0");
        this.chestCm = chestCm;
        this.waistCm = waistCm;
        this.hipCm = hipCm;
    }

    public boolean isMeasured() {
        return chestCm != null && chestCm > 0 &&
                waistCm != null && waistCm > 0 &&
                hipCm != null && hipCm > 0;
    }

    @Override
    public String toString() {
        return "size= '" + size + '\'' +
                ", type= '" + type + '\'' +
                ", chestCm= " + chestCm +
                ", waistCm= " + waistCm +
                ", hipCm= " + hipCm +
                '}';
    }
}