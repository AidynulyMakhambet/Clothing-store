package menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class clothingStoreMenu implements Menu{
    // ArrayLists and Scanner
    private ArrayList<ClothingItem> allClothingItems;
    private ArrayList<Customer> allCustomers;
    private ArrayList<Order> allOrders;
    private Scanner scanner;

    // Constructor
    public clothingStoreMenu() {
        this.allClothingItems = new ArrayList<>();
        this.allCustomers = new ArrayList<>();
        this.allOrders = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // Add test data
        try {
            Brand brand1 = new Brand("1", "First Brand", 100, "Kazakhstan");
            Brand brand2 = new Brand("2", "Second Brand", 100, "Germany");
            Brand brand3 = new Brand("3", "Third Brand", 100, "USA");

            Size size1 = new Size("S", "Shirt");
            Size size2 = new Size("L", "Pants");

            allCustomers.add(new Customer("1", "Mark", "Email1@google.com", "0 000 000 00 01", "Address1", 1000));
            allCustomers.add(new Customer("2", "Alex", "Email2@google.com", "0 000 000 00 02", "Address2", 1500));

            allClothingItems.add(new Pants("1", "Pants1", brand1, size2, "red", 5000, 10, "slim", true));
            allClothingItems.add(new Shirt("2", "Shirt1", brand2, size1, "yellow", 2000, 10, "long", false));
            allClothingItems.add(new Pants("3", "Pants2", brand3, size2, "blue", 3000, 10, "slim", false));

            allOrders.add(new Order(1, "Alex", 1, "Pending"));
            allOrders.add(new Order(2, "Mark", 2, "Completed"));
            allOrders.add(new Order(3, "Steve", 3, "Canceled"));

        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }



    // Display menu

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("  CLOTHING STORE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Pants");
        System.out.println("2. Add Shirt");
        System.out.println("3. View All Clothing Items");
        System.out.println("4. View Pants Only");
        System.out.println("5. View Shirts Only");
        System.out.println("6. Clear All Clothing items (Polymorphism)");
        System.out.println("7. Add Customer");
        System.out.println("8. Add Order");
        System.out.println("9. View All Customers");
        System.out.println("10. View All Orders");
        System.out.println("11. Wear clothing item");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {

        // Menu loop - continues until user exits
        boolean running = true;
        while (running) {
            try {
                displayMenu(); // Show menu options
                int choice = scanner.nextInt(); // Read user's choice
                scanner.nextLine(); // IMPORTANT: consume leftover newline
                switch (choice) {
                    case 1:
                        addPants();
                        break;
                    case 2:
                        addShirt();
                        break;
                    case 3:
                        viewAllClothingItems();
                        break;
                    case 4:
                        viewPantsOnly();
                        break;
                    case 5:
                        viewShirtsOnly();
                        break;
                    case 6:
                        demonstratePolymorphism();
                        break;
                    case 7:
                        addCustomer();
                        break;
                    case 8:
                        addOrder();
                        break;
                    case 9:
                        viewAllCustomers();
                        break;
                    case 10:
                        viewAllOrders();
                        break;
                    case 11:
                        wearClothingItem();
                        break;
                    case 0:
                        System.out.println("\nGoodbye! 👋");
                        running = false;
                        break;
                    default:
                        System.out.println("\n❌ Invalid choice!");
                }
            } catch(java.util.InputMismatchException e){
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
            } catch(Exception e){
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close(); // Clean up
        // Completion message
        System.out.println("\n=== Program Complete ===");

    } // End of main method

    private void addPants() {
        System.out.println("\n--- ADD PANTS (Child) ---");

        System.out.print("Enter clothingId: ");
        String clothingId = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter brandId: ");
        String brandId = scanner.nextLine();
        System.out.print("Enter brand name: ");
        String brandName = scanner.nextLine();
        System.out.print("Enter brand rating: ");
        double brandRating = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter brand country: ");
        String brandCountry = scanner.nextLine();

        System.out.print("Enter size: ");
        String sizeSize = scanner.nextLine();
        System.out.print("Enter size type: ");
        String sizeType = scanner.nextLine();

        System.out.print("Enter chestCm: ");
        double chest = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter waistCm: ");
        double waist = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter hipCm: ");
        double hip = scanner.nextDouble(); scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble(); scanner.nextLine();

        System.out.print("Enter stockQuantity: ");
        int stock = scanner.nextInt(); scanner.nextLine();

        // child fields
        System.out.print("Enter fit (Slim/Regular/...): ");
        String fit = scanner.nextLine();

        System.out.print("Has belt loops? (true/false): ");
        boolean hasBeltLoops = scanner.nextBoolean();
        scanner.nextLine();

        Brand brand = new Brand(brandId, brandName, brandRating, brandCountry);
        Size size = new Size(sizeSize, sizeType);
        size.setMeasurements(chest, waist, hip);

        allClothingItems.add(new Pants(clothingId, name, brand, size, color, price, stock, fit, hasBeltLoops));
        System.out.println("\n✅ Pants added successfully!");
    }

    private void addShirt() {
        System.out.println("\n--- ADD SHIRT (Child) ---");

        System.out.print("Enter clothingId: ");
        String clothingId = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter brandId: ");
        String brandId = scanner.nextLine();
        System.out.print("Enter brand name: ");
        String brandName = scanner.nextLine();
        System.out.print("Enter brand rating: ");
        double brandRating = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter brand country: ");
        String brandCountry = scanner.nextLine();

        System.out.print("Enter size: ");
        String sizeSize = scanner.nextLine();
        System.out.print("Enter size type: ");
        String sizeType = scanner.nextLine();

        System.out.print("Enter chestCm: ");
        double chest = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter waistCm: ");
        double waist = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter hipCm: ");
        double hip = scanner.nextDouble(); scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble(); scanner.nextLine();

        System.out.print("Enter stockQuantity: ");
        int stock = scanner.nextInt(); scanner.nextLine();

        // child fields
        System.out.print("Enter sleeveType (Short/Long): ");
        String sleeveType = scanner.nextLine();

        System.out.print("Has collar? (true/false): ");
        boolean hasCollar = scanner.nextBoolean();
        scanner.nextLine();

        Brand brand = new Brand(brandId, brandName, brandRating, brandCountry);
        Size size = new Size(sizeSize, sizeType);
        size.setMeasurements(chest, waist, hip);

        allClothingItems.add(new Shirt(clothingId, name, brand, size, color, price, stock, sleeveType, hasCollar));
        System.out.println("\n✅ Model.Shirt added successfully!");
    }

    private void viewAllClothingItems() {
        System.out.println("\n========================================");
        System.out.println(" ALL CLOTHING ITEMS ");
        System.out.println("========================================");

        if (allClothingItems.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }

        System.out.println("Total items: " + allClothingItems.size());
        System.out.println("----------------------------------------");

        int i = 1;
        for (ClothingItem item : allClothingItems) {
            System.out.println(i + ") [" + item.getType() + "] " + item.getName());
            System.out.println("   ID: " + item.getId());
            System.out.println("   Brand: " + (item.getBrand() != null ? item.getBrand().getName() : "N/A"));
            System.out.println("   Size: " + (item.getSize() != null ? item.getSize().getSize() : "N/A"));
            System.out.println("   Color: " + item.getColor());
            System.out.println("   Price: " + item.getPrice() + " KZT");
            System.out.println("   Stock: " + item.getStockQuantity() + " | Available: " + (item.isAvailable() ? "✅ Yes" : "❌ No"));

            // Child-specific info
            if (item instanceof Shirt) {
                Shirt s = (Shirt) item;
                System.out.println("   Shirt Info: Formal: " + (s.isFormal() ? "✅" : "❌"));
            } else if (item instanceof Pants) {
                Pants p = (Pants) item;
                System.out.println("   Pants Info: Needs belt" + (p.needsBelt() ? "✅" : "❌"));
            }

            System.out.println("----------------------------------------");
            i++;
        }
    }

    private void viewPantsOnly() {
        System.out.println("\n=== PANTS ONLY ===");
        int count = 0;

        for (ClothingItem item : allClothingItems) {
            if (item instanceof Pants) {
                Pants p = (Pants) item;
                count++;
                System.out.println(count + ") " + p.getName());
                System.out.println("   Fit: " + p.getFit());
                System.out.println("   Needs belt: " + (p.needsBelt() ? "✅ Yes" : "❌ No"));
                System.out.println("----------------------------------------");
            }
        }

        if (count == 0) System.out.println("No pants found.");
    }

    private void viewShirtsOnly() {
        System.out.println("\n=== SHIRTS ONLY ===");
        int count = 0;

        for (ClothingItem item : allClothingItems) {
            if (item instanceof Shirt) {
                Shirt s = (Shirt) item;
                count++;
                System.out.println(count + ") " + s.getName());
                System.out.println("   Sleeve: " + s.getSleeveType());
                System.out.println("   Formal (collar): " + (s.isFormal() ? "✅ Yes" : "❌ No"));
                System.out.println("----------------------------------------");
            }
        }

        if (count == 0) System.out.println("No shirts found.");
    }

    private void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMO ===");
        for (ClothingItem item : allClothingItems) {
            item.clean(); // same call, different output for Shirt/Pants
        }
    }

    private void addCustomer() {
        try {
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
            allCustomers.add(customer);

            System.out.println("\n✅ Customer added successfully!");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void viewAllCustomers() {
        System.out.println("\n========================================");
        System.out.println(" ALL CUSTOMERS");
        System.out.println("========================================");

        if (allCustomers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("Total customers: " + allCustomers.size());
        System.out.println("----------------------------------------");

        for (int i = 0; i < allCustomers.size(); i++) {
            Customer c = allCustomers.get(i);

            System.out.println((i + 1) + ") " + c.getName());
            System.out.println("   ID: " + c.getCustomerId());
            System.out.println("   Email: " + c.getEmail() + " | Valid: " + (c.isEmailValid() ? "✅" : "❌"));
            System.out.println("   Phone: " + c.getPhoneNumber());
            System.out.println("   Address: " + c.getAddress());
            System.out.println("   Bonus points: " + c.getBonusPoints() + " | VIP: " + (c.isVIP() ? "✅ Yes" : "No"));
            System.out.println("----------------------------------------");
        }
    }

    private void addOrder() {
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
        allOrders.add(order);

        System.out.println("\n✅ Model.Order added successfully!");
    }

    private void viewAllOrders() {
        System.out.println("\n========================================");
        System.out.println(" ALL ORDERS");
        System.out.println("========================================");

        if (allOrders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("Total orders: " + allOrders.size());
        System.out.println("----------------------------------------");

        for (int i = 0; i < allOrders.size(); i++) {
            Order o = allOrders.get(i);

            System.out.println((i + 1) + ") Model.Order #" + o.getOrderId());
            System.out.println("   Model.Customer: " + o.getCustomerName());
            System.out.println("   Total: " + o.getTotalAmount() + " KZT");
            System.out.println("   Status: " + o.getStatus() + (o.isPending() ? " (⏳ pending)" : ""));
            System.out.println("----------------------------------------");
        }
    }

    private void wearClothingItem() {
        System.out.println("\n--- Wear Clothing item ---");

        if (allClothingItems.isEmpty()) {
            System.out.println("❌ No Clothing items available to wear!");
            return;
        }

        System.out.println("Available Clothing items:");
        for (int i = 0; i < allClothingItems.size(); i++) {
            System.out.println((i + 1) + ". " + allClothingItems.get(i).getName());
        }

        try {
            System.out.print("Select item number to wear: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > allClothingItems.size()) {
                throw new InvalidInputException("Invalid item number!");
            }

            ClothingItem item = allClothingItems.get(choice - 1);
            item.wear();
            System.out.println("Material: " + item.getMaterial());

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Please enter a valid number!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

}
