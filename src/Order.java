public class Order {
    private int orderId;
    private String customerName;
    private double totalAmount;
    private String status;

    // Constructor
    public Order(int orderId, String customerName, double totalAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
    }


    // Getters
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }

    // Setters
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCustomerName(String itemName) { this.customerName = customerName; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setStatus(String status) { this.status = status; }

    // methods

    // set order status to "Completed"
    public void completeOrder() { this.status = "Completed"; }

    // cancel order
    public void cancelOrder() { this.status = "Canceled"; }

    // check if status in "Pending"
    public boolean isPending() { return status.equals("Pending"); }

    // add amount
    public void addAmount(double amount) { this.totalAmount = this.totalAmount + amount; }

    // output data

    @Override
    public String toString() {
        return "Order{" +
                "orderId= " + '\'' + orderId + '\'' +
                ", customerName= " + '\'' + customerName + '\'' +
                ", totalAmount= " + totalAmount +
                ", status= " + '\'' + status + '\'' +
                "}";
    }
}