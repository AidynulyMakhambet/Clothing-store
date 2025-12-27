public class Main {

  public static void main(String[] args) {
    System.out.println("=== Clothing store Management System ===");
    System.out.println();
    // Create Brand objects
    Brand brand1 = new Brand("1", "brand1", 100, "Kazakhstan");
    Brand brand2 = new Brand("2", "brand2", 100, "Germany");

    // Create Size objects
    Size size1 = new Size("S", "top");
    Size size2 = new Size("L", "top");

    // Create ClothingItem objects
    ClothingItem clothingItem1 = new ClothingItem("1", "T-shirt", brand1, size1, "red", "T-Shirt", 2000, 10);
    ClothingItem clothingItem2 = new ClothingItem("2", "coat", brand2, size2, "black", "coat", 5000, 5);

    // Create Customer objects
    Customer customer1 = new Customer("1", "Alice Johnson", "Email1@google.com", "+77011234567", "Address1", 1500);
    Customer customer2 = new Customer("2", "Bob Williams", "Email2@google.com", "+77012345678", "Address2", 500);

    // Create Employee objects
    Employee employee1 = new Employee("1", "Nick Robinson", "salesman", 120000);
    Employee employee2 = new Employee("2", "Mark Richardson", "loader", 100000);

    // Create Orders objects
    Order order1 = new Order(1, "Alice Johnson", 10000, "Pending");
    Order order2 = new Order(2, "Mark Richardson", 5000, "Pending");

    // testing

    System.out.println("--- BRANDS ---");
    System.out.println(brand1);
    System.out.println(brand2);
    System.out.println();

    System.out.println("--- SIZES ---");
    System.out.println(size1);
    System.out.println(size2);
    System.out.println();

    System.out.println("--- CLOTHING ITEMS ---");
    System.out.println(clothingItem1);
    System.out.println(clothingItem2);
    System.out.println();

    System.out.println("--- CUSTOMERS ---");
    System.out.println(customer1);
    System.out.println(customer2);
    System.out.println();

    System.out.println("--- EMPLOYEES ---");
    System.out.println(employee1);
    System.out.println(employee2);
    System.out.println();

    System.out.println("--- ORDERS ---");
    System.out.println(order1);
    System.out.println(order2);
    System.out.println();

    // 4) Test getters
    System.out.println("--- TESTING GETTERS ---");
    System.out.println("Item 1 name: " + clothingItem1.getName());
    System.out.println("Item 1 price: " + clothingItem1.getPrice() + " KZT");
    System.out.println("Customer 1 name: " + customer1.getName());
    System.out.println("Order 1 status: " + order1.getStatus());
    System.out.println();

    // 5) Test setters
    System.out.println("--- TESTING SETTERS ---");

    System.out.println("Updating brand2 country...");
    brand2.setCountry("Italy");
    System.out.println("Updated: " + brand2);
    System.out.println();

    System.out.println("Updating clothingItem2 price and stock...");
    clothingItem2.setPrice(4500);
    clothingItem2.setStockQuantity(8);
    System.out.println("Updated: " + clothingItem2);
    System.out.println();

    System.out.println("Changing order2 customer name...");
    order2.setCustomerName("Bob Williams");
    System.out.println("Updated: " + order2);
    System.out.println();

    // 6) Test additional methods (your “logic” methods)
    System.out.println("--- TESTING CLOTHINGITEM METHODS ---");
    System.out.println(clothingItem2.getName() + " is premium: " + clothingItem2.isPremium());
    System.out.println("Applying 10% discount to " + clothingItem2.getName());
    clothingItem2.applyDiscount(10);
    System.out.println("New price: " + clothingItem2.getPrice() + " KZT");
    System.out.println();

    System.out.println("--- TESTING CUSTOMER METHODS ---");
    System.out.println(customer1.getName() + " is VIP: " + customer1.isVIP());
    System.out.println("Adding 60 points to " + customer1.getName());

    customer1.addBonusPoints(60);
    System.out.println(customer1.getName() + " points: " + customer1.getBonusPoints());
    System.out.println(customer1.getName() + " is VIP: " + customer1.isVIP());
    System.out.println();

    System.out.println("--- TESTING ORDER METHODS ---");
    System.out.println("Order " + order1.getOrderId() + " pending: " + order1.isPending());
    order1.completeOrder(); // if you named it complete(), rename this call
    System.out.println("Order " + order1.getOrderId() + " status: " + order1.getStatus());
    System.out.println();

    System.out.println("Adding to order " + order2.getOrderId());
    order2.addAmount(1500);
    order2.addAmount(2000);
    System.out.println("Order " + order2.getOrderId() + " total: " + order2.getTotalAmount() + " KZT");
    System.out.println();

    // 7) Final state summary
    System.out.println("--- FINAL STATE ---");

    System.out.println("Brands:");
    System.out.println(brand1);
    System.out.println(brand2);
    System.out.println();

    System.out.println("Clothing Items:");
    System.out.println(clothingItem1);
    System.out.println(clothingItem2);
    System.out.println();

    System.out.println("Customers:");
    System.out.println(customer1);
    System.out.println(customer2);
    System.out.println();

    System.out.println("Employees:");
    System.out.println(employee1);
    System.out.println(employee2);
    System.out.println();

    System.out.println("Orders:");
    System.out.println(order1);
    System.out.println(order2);

    // 8) Completion message
    System.out.println("\n=== Program Complete ===");
  }
}