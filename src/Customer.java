public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private int bonusPoints;

    // Constructor
    public Customer(String customerId, String name, String email, String phoneNumber, String address, int bonusPoints) {
        this.customerId = customerId;
        this.name = name;
        setEmail(email);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bonusPoints = bonusPoints;
    }



    // Getters
    public String getCustomerId() { return customerId;}
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public int getBonusPoints() { return bonusPoints; }

    // Setters
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) {
        if(email.contains("@") && email.contains(".")){
            this.email = email;
        } else {
            this.email = "Invalid Email";
        }
    }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setBonusPoints(int bonusPoints) { this.bonusPoints = bonusPoints; }

    // add bonus points
    public void addBonusPoints(int points) {
        this.bonusPoints = this.bonusPoints + points;
    }

    // use bonus points
    public void useBonusPoints(int points) {
        if (bonusPoints < points) throw new IllegalArgumentException("Not enough bonus points");
        this.bonusPoints = this.bonusPoints - points;
    }

    // check if customer is VIP one
    public boolean isVIP() { return bonusPoints > 1000; }

    // simple check if email is valid
    public boolean isEmailValid() {
        return this.email.contains("@") && this.email.contains(".");
    }

    // Convert name to uppercase for shipping labels
    public String getLabelName() {
        return this.name.toUpperCase();
    }

    // output data

    @Override
    public String toString() {
        return "Customer{" +
                "customerId= '" + customerId + '\'' +
                ", name= '" + name + '\'' +
                ", email= '" + email + '\'' +
                ", phone number= " + phoneNumber +
                ", address= '" + address + '\'' +
                '}';
    }
}