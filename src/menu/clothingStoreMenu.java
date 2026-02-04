package menu;

import model.*;
import exception.InvalidInputException;
import database.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class clothingStoreMenu implements Menu{
    private Scanner scanner;
    private ClothingItemDAO clothingItemDAO;

    public clothingStoreMenu() {
        this.scanner = new Scanner(System.in);
        this.clothingItemDAO = new ClothingItemDAO();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  CLOTHING STORE MANAGEMENT SYSTEM v2.0   ║");
        System.out.println("║  Week 8: Fully Database-Driven 🗄️     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("✅ All data is stored in PostgreSQL");
        System.out.println("✅ No in-memory ArrayLists");
        System.out.println("✅ Complete CRUD operations");
    }

    // Display menu
    @Override
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MAIN MENU - Week 8            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("┌─ CLOTHING ITEMS MANAGEMENT ─────────────┐");
        System.out.println("│ 1. Add Pants                            │");
        System.out.println("│ 2. Add Shirt                            │");
        System.out.println("│ 3. View All ClothingItems               │");
        System.out.println("│ 4. View Pants Only                      │");
        System.out.println("│ 5. View Shirt Only                      │");
        System.out.println("│ 6. Update ClothingItem                  │");
        System.out.println("│ 7. Delete ClothingItem                  │");
        System.out.println("├─ SEARCH & FILTER ───────────────────────┤");
        System.out.println("│ 8. Search by Name                       │");
        System.out.println("│ 9. Search by Price Range                │");
        System.out.println("│10. High-Cost ClothingItems (Salary >= X)│");
        System.out.println("├─ DEMO & OTHER ──────────────────────────┤");
        System.out.println("│11. Polymorphism Demo                    │");
        System.out.println("│ 0. Exit                                 │");
        System.out.println("└─────────────────────────────────────────┘");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("\n👉 Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

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
                        updateClothingItem();
                        break;
                    case 7:
                        deleteClothingItem();
                        break;
                    case 8:
                        searchByName();
                        break;
                    case 9:
                        searchByPriceRange();
                        break;
                    case 10:
                        searchByMinPrice();
                        break;
                    case 11:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!      ║");
                        System.out.println("║  Goodbye! 👋                          ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please select 0-11.");
                }

                if (choice != 0) {
                    pressEnterToContinue();
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
                pressEnterToContinue();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
                pressEnterToContinue();
            }
        }

        scanner.close();
    }

    // ========================================
    // CREATE OPERATIONS
    // ========================================

    private void addPants() {
        try {
            System.out.println("\n--- ADD PANTS (Child) ---");

            System.out.print("Enter clothingItemId: ");
            String clothingItemId = scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter color: ");
            String color = scanner.nextLine();

            System.out.print("Enter size: ");
            String size = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter stockQuantity: ");
            int stockQuantity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();

            // child fields

            System.out.print("Has belt loops? (true/false): ");
            boolean hasBeltLoops = scanner.nextBoolean();
            scanner.nextLine();

            clothingItemDAO.insertPants(new Pants(clothingItemId, name, color, size, price, stockQuantity, brand, hasBeltLoops));

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void addShirt() {
        try {
            System.out.println("\n--- ADD SHIRT (Child) ---");

            System.out.print("Enter clothingItemId: ");
            String clothingItemId = scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter color: ");
            String color = scanner.nextLine();

            System.out.print("Enter size: ");
            String size = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter stockQuantity: ");
            int stockQuantity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();

            // child fields
            System.out.print("Enter sleeveType (Short/Long): ");
            String sleeveType = scanner.nextLine();

            clothingItemDAO.insertShirt(new Shirt(clothingItemId, name, color, size, price, stockQuantity, brand, sleeveType));

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void viewAllClothingItems() {
        clothingItemDAO.displayAllClothingItems();
    }

    private void viewPantsOnly() {
        List<Pants> pantsList = clothingItemDAO.getAllPants();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         PANTS ONLY                    ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (pantsList.isEmpty()) {
            System.out.println("📭 No chefs in database.");
        } else {
            for (int i = 0; i < pantsList.size(); i++) {
                Pants pants = pantsList.get(i);
                System.out.println((i + 1) + ". " + pants.toString());
                System.out.println("   hasBeltLoops: " + pants.getHasBeltLoops());
                if (pants.needsBelt()) {
                    System.out.println("   ⭐ NEEDS BELT (have belt loops)");
                }
                System.out.println();
            }
            System.out.println("Total Pants: " + pantsList.size());
        }
    }

    private void viewShirtsOnly() {
        List<Shirt> shirts = clothingItemDAO.getAllShirts();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        SHIRT ONLY                     ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (shirts.isEmpty()) {
            System.out.println("📭 No waiters in database.");
        } else {
            for (int i = 0; i < shirts.size(); i++) {
                Shirt shirt = shirts.get(i);
                System.out.println((i + 1) + ". " + shirt.toString());
                System.out.println("   sleeveType: " + shirt.getSleeveType());
                System.out.println();
            }
            System.out.println("Total Shirts: " + shirts.size());
        }
    }

    // ========================================
    // UPDATE OPERATION (Week 8)
    // ========================================

    private void updateClothingItem() {
        System.out.println("\n┌─ UPDATE CLOTHING ITEM ─────────────────────────┐");
        System.out.print("│ Enter clothing item ID to update: ");

        try {
            String clothingItemId = scanner.nextLine();

            // First, get existing staff from database
            ClothingItem existingClothingItem = clothingItemDAO.getClothingItemById(clothingItemId);

            if (existingClothingItem == null) {
                System.out.println("❌ No clothingItem found with ID: " + clothingItemId);
                return;
            }

            // Display current info
            System.out.println("│ Current Info:");
            System.out.println("│ " + existingClothingItem.toString());
            System.out.println("└────────────────────────────────────────┘");

            // Get new values
            System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
            System.out.println("│ (Press Enter to keep current value)   │");

            System.out.print("│ New Name [" + existingClothingItem.getName() + "]: ");
            String newName = scanner.nextLine();
            if (newName.trim().isEmpty()) {
                newName = existingClothingItem.getName();
            }

            System.out.print("│ New Color [" + existingClothingItem.getColor() + "]: ");
            String newColor = scanner.nextLine();
            if (newColor.trim().isEmpty()) {
                newColor = existingClothingItem.getColor();
            }

            System.out.print("│ New Size [" + existingClothingItem.getSize() + "]: ");
            String newSize = scanner.nextLine();
            if (newSize.trim().isEmpty()) {
                newSize = existingClothingItem.getSize();
            }

            System.out.print("│ New Price [" + existingClothingItem.getPrice() + "]: ");
            String priceInput = scanner.nextLine();
            double newPrice = priceInput.trim().isEmpty() ?
                    existingClothingItem.getPrice() : Double.parseDouble(priceInput);

            System.out.print("│ New StockQuantity [" + existingClothingItem.getStockQuantity() + "]: ");
            String stockQuantityInput = scanner.nextLine();
            int newStockQuantity = stockQuantityInput.trim().isEmpty() ?
                    existingClothingItem.getStockQuantity() : Integer.parseInt(stockQuantityInput);

            System.out.print("│ New Brand [" + existingClothingItem.getBrand() + "]: ");
            String newBrand = scanner.nextLine();
            if (newBrand.trim().isEmpty()) {
                newBrand = existingClothingItem.getBrand();
            }

            // Update based on type
            if (existingClothingItem instanceof Pants) {
                System.out.print("│ New hasBeltLoops [" + ((Pants) existingClothingItem).getHasBeltLoops() + "]: ");
                String hasBeltLoopsInput = scanner.nextLine();
                boolean newHasBeltLoops = hasBeltLoopsInput.trim().isEmpty() ?
                        ((Pants) existingClothingItem).getHasBeltLoops() : Boolean.parseBoolean(hasBeltLoopsInput);

                Pants updatedPants = new Pants(clothingItemId, newName, newColor, newSize, newPrice, newStockQuantity, newBrand, newHasBeltLoops);
                clothingItemDAO.updatePants(updatedPants);

            } else if (existingClothingItem instanceof Shirt) {
                Shirt shirt = (Shirt) existingClothingItem;
                System.out.print("│ SleeveType [" + shirt.getSleeveType() + "]: ");
                String newSleeveType = scanner.nextLine();

                if (newSleeveType.trim().isEmpty()) {
                    newSleeveType = ((Shirt) existingClothingItem).getSleeveType();
                }

                Shirt updatedShirt = new Shirt(clothingItemId, newName, newColor, newSize, newPrice, newStockQuantity, newBrand, newSleeveType);
                clothingItemDAO.updateShirt(updatedShirt);
            }

            System.out.println("└────────────────────────────────────────┘");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid number format!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    // ========================================
    // DELETE OPERATION (Week 8)
    // ========================================

    private void deleteClothingItem() {
        System.out.println("\n┌─ DELETE CLOTHING ITEM ─────────────────────────┐");
        System.out.print("│ Enter CLOTHING ITEM ID to delete: ");

        try {
            String clothingItemId = scanner.nextLine();

            // First, show who will be deleted
            ClothingItem clothingItem = clothingItemDAO.getClothingItemById(clothingItemId);

            if (clothingItem == null) {
                System.out.println("❌ No staff found with ID: " + clothingItemId);
                return;
            }

            System.out.println("│ Staff to delete:");
            System.out.println("│ " + clothingItem.toString());
            System.out.println("└────────────────────────────────────────┘");

            System.out.print("⚠️  Are you sure? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                clothingItemDAO.deleteClothingItem(clothingItemId);
            } else {
                System.out.println("❌ Deletion cancelled.");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input!");
            scanner.nextLine();
        }
    }

    // ========================================
    // SEARCH OPERATIONS (Week 8)
    // ========================================

    private void searchByName() {
        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
        System.out.print("│ Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");

        List<ClothingItem> results = clothingItemDAO.searchByName(name);

        displaySearchResults(results, "Search: '" + name + "'");
    }

    private void searchByPriceRange() {
        try {
            System.out.println("\n┌─ SEARCH BY PRICE RANGE ───────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();

            System.out.print("│ Enter maximum price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<ClothingItem> results = clothingItemDAO.searchByPriceRange(minPrice, maxPrice);

            displaySearchResults(results, "Salary: " + minPrice + " - " + maxPrice + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void searchByMinPrice() {
        try {
            System.out.println("\n┌─ HIGH-PRICE CLOTHING ITEM ──────────────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<ClothingItem> results = clothingItemDAO.searchByMinPrice(minPrice);

            displaySearchResults(results, "Salary >= " + minPrice + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void displaySearchResults(List<ClothingItem> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No clothingItems found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                ClothingItem c = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + c.getType() + "] ");
                System.out.println(c.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }

    // ========================================
    // POLYMORPHISM DEMO
    // ========================================

    private void demonstratePolymorphism() {
        clothingItemDAO.demonstratePolymorphism();
    }

    // ========================================
    // HELPER METHOD
    // ========================================

    private void pressEnterToContinue() {
        System.out.println("\n[Press Enter to continue...]");
        scanner.nextLine();
    }
}
