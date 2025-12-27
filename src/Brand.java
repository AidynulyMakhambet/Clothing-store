public class Brand {
    private String brandId;
    private String name;
    private double rating; // optional
    private String country; // optional

    // constructor
    public Brand(String brandId, String name, double rating, String country) {
        this.brandId = brandId;
        this.name = name;
        this.rating = rating; // can be null
        this.country = country; // can be null
    }

    // methods

    // check if brand is rated
    public boolean isRated() { return rating != 0; }

    // check if brand has country info
    public boolean isCountryGiven() { return country != null; }

    // getters
    public String getBrandId() { return brandId; }
    public String getName() { return name; }
    public double getRating() { return rating; }
    public String getCountry() { return country; }

    // setters
    public void setBrandId(String brandId) { this.brandId = brandId; }
    public void setName(String name) { this.name = name; }
    public void setRating(double rating) { this.rating = rating; }
    public void setCountry(String country) { this.country = country; }

    // output data

    @Override
    public String toString() {
        return "Brand{" +
                "brandId= '" + brandId + '\'' +
                ", name= '" + name + '\'' +
                ", rating= " + rating +
                ", country= " + country +
                '}';
    }
}