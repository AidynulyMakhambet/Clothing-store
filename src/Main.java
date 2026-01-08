import java.util.ArrayList; // Allows us to use ArrayList
import java.util.Scanner; // Allows us to read user input

public class Main {
  // Step 1: ArrayLists and Scanner

  // These ArrayLists store all our objects
  // 'static' means they belong to the class, not individual objects
  // 'private' keeps them protected
  private static ArrayList<ClothingItem> clothingItems = new ArrayList<>();
  private static ArrayList<Customer> customers = new ArrayList<>();
  private static ArrayList<Order> orders = new ArrayList<>();
  // Scanner for reading user input
  private static Scanner scanner = new Scanner(System.in);

  // Step 4: Display menu

  private static void displayMenu() {
    System.out.println("\n========================================");
    System.out.println(" CLOTHING STORE MANAGEMENT SYSTEM");
    System.out.println("========================================");
    System.out.println("1. Add Clothing Item");
    System.out.println("2. View All Clothing Items");
    System.out.println("3. Add Customer");
    System.out.println("4. View All Customers");
    System.out.println("5. Add Order");
    System.out.println("6. View All Orders");
    System.out.println("0. Exit");
    System.out.println("========================================");
    System.out.print("Enter your choice: ");
  }

  // Step 5-6: Add and View methods

  private static void addClothingItem() {
    System.out.println("\n--- ADD CLOTHING ITEM ---");
    // Ask for each field
    System.out.print("Enter item clothingId: ");
    String clothingId = scanner.nextLine(); // Read string
    System.out.print("Enter item name: ");
    String name = scanner.nextLine(); // Read string

    System.out.print("Enter item's brand brandId: ");
    String brandId = scanner.nextLine(); // Read string
    System.out.print("Enter item's brand name: ");
    String brandName = scanner.nextLine(); // Read string
    System.out.print("Enter item's brand rating(can be null): ");
    double brandRating = scanner.nextDouble(); // Read double
    System.out.print("Enter item's brand country(can be null): ");
    String brandCountry = scanner.nextLine(); // Read string

    System.out.print("Enter item's size: ");
    String sizeSize = scanner.nextLine(); // Read string
    System.out.print("Enter item's size type: ");
    String sizeType = scanner.nextLine(); // Read string
    System.out.print("Enter item's size chestCm(optional): ");
    double sizeChestCm = scanner.nextDouble(); // Read double
    System.out.print("Enter item's size waistCm(optional): ");
    double sizeWaistCm = scanner.nextDouble(); // Read double
    System.out.print("Enter item's size hipCm(optional): ");
    double sizeHipCm = scanner.nextDouble(); // Read double

    System.out.print("Enter item color: ");
    String color = scanner.nextLine(); // Read string
    System.out.print("Enter item category: ");
    String category = scanner.nextLine(); // Read string
    System.out.print("Enter item price (KZT): ");
    double price = scanner.nextDouble(); // Read double
    System.out.print("Enter item stockQuantity: ");
    int stockQuantity = scanner.nextInt(); // Read double

    // Create new object with user's data
    ClothingItem item = new ClothingItem(clothingId, name, new Brand(brandId, brandName, brandRating, brandCountry), new Size(sizeSize, sizeType), color, category, price, stockQuantity);
    item.getSize().setMeasurements(sizeChestCm, sizeWaistCm, sizeHipCm);
    // Add to ArrayList
    clothingItems.add(item);
    System.out.println("\n✅ Clothing item added successfully!");
  }
  private static void viewAllClothingItems() {
    System.out.println("\n========================================");
    System.out.println(" ALL CLOTHING ITEMS");
    System.out.println("========================================");

    if (clothingItems.isEmpty()) {
      System.out.println("No clothing items found.");
      return;
    }

    System.out.println("Total items: " + clothingItems.size());
    System.out.println("----------------------------------------");

    for (int i = 0; i < clothingItems.size(); i++) {
      ClothingItem item = clothingItems.get(i);

      System.out.println((i + 1) + ") " + item.getName() + " | " + item.getCategory());
      System.out.println("   ID: " + item.getId());
      System.out.println("   Brand: " + (item.getBrand() != null ? item.getBrand().getName() : "N/A"));
      System.out.println("   Size: " + (item.getSize() != null ? item.getSize().getSize() : "N/A"));
      System.out.println("   Color: " + item.getColor());
      System.out.println("   Price: " + item.getPrice() + " KZT");
      System.out.println("   Stock: " + item.getStockQuantity() + " | Available: " + (item.isAvailable() ? "✅ Yes" : "❌ No"));
      System.out.println("----------------------------------------");
    }
  }

  private static void addCustomer() {
    System.out.println("\n--- ADD CUSTOMER ---");

    System.out.print("Enter customerId: ");
    String customerId = scanner.nextLine();

    System.out.print("Enter name: ");
    String name = scanner.nextLine();

    System.out.print("Enter email: ");
    String email = scanner.nextLine();

    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();

    System.out.print("Enter address: ");
    String address = scanner.nextLine();

    System.out.print("Enter bonus points: ");
    int bonusPoints = scanner.nextInt();
    scanner.nextLine(); // consume newline

    Customer customer = new Customer(customerId, name, email, phoneNumber, address, bonusPoints);
    customers.add(customer);

    System.out.println("\n✅ Customer added successfully!");
  }

  private static void viewAllCustomers() {
    System.out.println("\n========================================");
    System.out.println(" ALL CUSTOMERS");
    System.out.println("========================================");

    if (customers.isEmpty()) {
      System.out.println("No customers found.");
      return;
    }

    System.out.println("Total customers: " + customers.size());
    System.out.println("----------------------------------------");

    for (int i = 0; i < customers.size(); i++) {
      Customer c = customers.get(i);

      System.out.println((i + 1) + ") " + c.getName());
      System.out.println("   ID: " + c.getCustomerId());
      System.out.println("   Email: " + c.getEmail() + " | Valid: " + (c.isEmailValid() ? "✅" : "❌"));
      System.out.println("   Phone: " + c.getPhoneNumber());
      System.out.println("   Address: " + c.getAddress());
      System.out.println("   Bonus: " + c.getBonusPoints() + " | VIP: " + (c.isVIP() ? "✅ Yes" : "No"));
      System.out.println("----------------------------------------");
    }
  }

  private static void addOrder() {
    System.out.println("\n--- ADD ORDER ---");

    System.out.print("Enter orderId: ");
    int orderId = scanner.nextInt();
    scanner.nextLine(); // consume newline

    System.out.print("Enter customer name: ");
    String customerName = scanner.nextLine();

    System.out.print("Enter total amount: ");
    double totalAmount = scanner.nextDouble();
    scanner.nextLine(); // consume newline

    System.out.print("Enter status (Pending/Completed/Canceled): ");
    String status = scanner.nextLine();
    if (status.trim().isEmpty()) status = "Pending";

    Order order = new Order(orderId, customerName, totalAmount, status);
    orders.add(order);

    System.out.println("\n✅ Order added successfully!");
  }

  private static void viewAllOrders() {
    System.out.println("\n========================================");
    System.out.println(" ALL ORDERS");
    System.out.println("========================================");

    if (orders.isEmpty()) {
      System.out.println("No orders found.");
      return;
    }

    System.out.println("Total orders: " + orders.size());
    System.out.println("----------------------------------------");

    for (int i = 0; i < orders.size(); i++) {
      Order o = orders.get(i);

      System.out.println((i + 1) + ") Order #" + o.getOrderId());
      System.out.println("   Customer: " + o.getCustomerName());
      System.out.println("   Total: " + o.getTotalAmount() + " KZT");
      System.out.println("   Status: " + o.getStatus() + (o.isPending() ? " (⏳ pending)" : ""));
      System.out.println("----------------------------------------");
    }
  }

  public static void main(String[] args) {
    // Step 2: Add test data

    // Add initial test data so user can see examples
    Brand brand1 = new Brand("1", "brand1", 100, "KZ");
    Brand brand2 = new Brand("2", "brand2", 100, "German");
    Brand brand3 = new Brand("3", "brand3", 100, "USA");

    Size size1 = new Size("S", "top");
    Size size2 = new Size("M", "bottom");
    Size size3 = new Size("L", "top");

    clothingItems.add(new ClothingItem("1", "T-shirt", brand1, size1, "red", "T-shirt", 3000, 10));
    clothingItems.add(new ClothingItem("2", "skirt", brand2, size2, "green", "skirt", 5000, 10));
    clothingItems.add(new ClothingItem("3", "hat", brand3, size3, "black", "hat", 5000, 5));
    customers.add(new Customer("1001", "Aidar", "Email1@google.com", "+77011234567", "Address1", 150));
    customers.add(new Customer("1002", "Asel", "Email2@google.com", "+77012345678", "Address1", 200));
    orders.add(new Order(5001, "Aidar", 6500, "Completed"));
    orders.add(new Order(5002, "Asel", 3000, "Pending"));

    // Step 3: Menu loop

    // Menu loop - continues until user exits
    boolean running = true;
    while (running) {
      displayMenu(); // Show menu options
      int choice = scanner.nextInt(); // Read user's choice
      scanner.nextLine(); // IMPORTANT: consume leftover newline
      switch (choice) {
        case 1:
          addClothingItem();
          break;
        case 2:
          viewAllClothingItems();
          break;
        case 3:
          addCustomer();
          break;
        case 4:
          viewAllCustomers();
          break;
        case 5:
          addOrder();
          break;
        case 6:
          viewAllOrders();
          break;
        case 0:
          System.out.println("\nGoodbye! \uD83D\uDC4B");
          running = false; // Exit loop
          break;
        default:
          System.out.println("\n ❌Invalid choice!");
      }
      if (running) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine(); // Wait for user
      }
    }
    scanner.close(); // Clean up
    // Completion message
    System.out.println("\n=== Program Complete ===");

  } // End of main method
}